package com.ratemytree.rmt.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * David Schilling - davejs92@gmail.com
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("foo", HttpStatus.OK);
    }
}
