package com.loadbalancer.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.loadbalancer.server.config.Endpoint;
import com.loadbalancer.server.config.LoadBalancerProperties;

@SpringBootApplication
@EnableConfigurationProperties({ LoadBalancerProperties.class })
public class LoadBalancerServerApplication  implements ApplicationRunner{

	@Autowired
	private LoadBalancerProperties properties;
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());


	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerServerApplication.class, args);
	}

	/**
     * Application method.<br>
     * Checks & handles command line arguments.
     *
     * @param args Application arguments
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (args.containsOption("config")) {
            List<Endpoint> endpointList = new ArrayList<>();
            for (String value : args.getOptionValues("config")) {
                File file = new File(value);
                if (file.exists()) {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        try {
                            endpointList.add(Endpoint.parseUriString(line));
                        } catch (URISyntaxException e) {
                            logger.warn("Incorrect URI syntax: " + line);
                        }
                    }
                    br.close();
                    fr.close();
                }
                else {
                    logger.warn("File " + value + " doesn't exist.");
                }
                if (!endpointList.isEmpty()) {
                    properties.setEndpoints(endpointList);
                }
            }
        }
    }
}
