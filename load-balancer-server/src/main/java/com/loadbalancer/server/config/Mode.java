package com.loadbalancer.server.config;

/**
 * Load Balancer application mode enum.<br>
 * 1) Round Robin.<br>
 * 2) Session Persistence.<br>
 * 3) URL mapping.
 */
public enum Mode {
    ROUND_ROBIN, SESSION_PERSISTENCE, URL_MAPPING
}
