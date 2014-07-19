package com.ratemytree.rmt.tree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * David Schilling - davejs92@gmail.com
 */
@Controller
@RequestMapping(value = "/trees")
public class TreeController {

    private static final String TREE_COLLECTION = "tree";

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createTree(@RequestBody String tree){
        mongoTemplate.save(tree, TREE_COLLECTION);
        return new ResponseEntity<>(tree, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getTree(@PathVariable String id) {
        String tree = mongoTemplate.findById(id, String.class, TREE_COLLECTION);
        return new ResponseEntity<>(tree, HttpStatus.OK);
    }
}
