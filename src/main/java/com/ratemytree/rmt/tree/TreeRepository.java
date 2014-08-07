package com.ratemytree.rmt.tree;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * David Schilling - davejs92@gmail.com
 */
public interface TreeRepository extends MongoRepository<Tree, String> {

    List<Tree> findByCreator(String creator);
}
