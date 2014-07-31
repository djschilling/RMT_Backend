package com.ratemytree.rmt.tree;

import java.util.List;

/**
 * David Schilling - davejs92@gmail.com
 */
public interface TreeService {

    Tree create(String content);

    Tree save(Tree tree);

    Tree findById(String id);

    Tree voteUpForTree(String id);

    Tree voteDownForTree(String id);

    List<Tree> findTreesByVotes();
}
