package com.ratemytree.rmt;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * David Schilling - davejs92@gmail.com
 */
public class HelloTest {
    @Test
    public void testHello() throws Exception {
        assertThat(Hello.hello(), is("Hello"));
    }
}
