package com.ratemytree.rmt.config;

import javax.servlet.ServletContext;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * Initializes the Security Context and adds the CORS Filter to the network stack.
 *
* @author David Schilling - davejs92@gmail.com
*/
public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {
}