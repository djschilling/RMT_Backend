package com.ratemytree.rmt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * David Schilling - davejs92@gmail.com
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ratemytree.rmt")
public class ApplicationContext {
}
