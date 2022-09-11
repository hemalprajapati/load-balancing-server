package com.loadbalancer.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "loadbalancer")
public class LoadBalancerProperties {

    /**
     * Application mode: see {@link Mode}.
     */
    private Mode mode;

    /**
     * Load Balancer endpoints: see {@link Endpoint}.
     */
    private List<Endpoint> endpoints;

    /*** Getters ***/

    public Mode getMode() {
        return mode;
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    /*** Setters ***/

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }
}
