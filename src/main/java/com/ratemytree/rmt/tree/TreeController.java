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


    @Autowired
    private TreeRepository treeRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Tree> createTree(@RequestBody String tree) {
        Tree savedTree = treeRepository.save(new Tree(tree));
        return new ResponseEntity<>(savedTree, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tree> getTree(@PathVariable String id) {
        Tree tree = treeRepository.findOne(id);
        return new ResponseEntity<>(tree, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/vote", method = RequestMethod.POST)
    public ResponseEntity<Tree> voteForTree(@PathVariable String id) {
        Tree tree = treeRepository.findOne(id);
        tree.incrementVote();
        Tree updatedTree = treeRepository.save(tree);
        return new ResponseEntity<>(updatedTree, HttpStatus.OK);
    }

}
