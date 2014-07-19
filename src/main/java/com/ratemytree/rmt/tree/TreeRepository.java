package com.ratemytree.rmt.tree;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * David Schilling - davejs92@gmail.com
 */
public interface TreeRepository extends MongoRepository<Tree, String> {
}
