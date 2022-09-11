package com.loadbalancer.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "loadbalancer")
public class LoadBalancerProperties {

    
    /**
     * Load Balancer endpoints: see {@link Endpoint}.
     */
    private List<Endpoint> endpoints;


    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }
}
