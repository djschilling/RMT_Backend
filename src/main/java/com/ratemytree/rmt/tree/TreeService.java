package com.ratemytree.rmt.tree;

/**
 * David Schilling - davejs92@gmail.com
 */
public interface TreeService {

    Tree create(String content);

    Tree save(Tree tree);

    Tree findById(String id);

    Tree voteForTree(String id);
}
