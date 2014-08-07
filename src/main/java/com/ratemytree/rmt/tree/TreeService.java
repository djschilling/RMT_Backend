package com.ratemytree.rmt.tree;

import java.util.List;

/**
 * David Schilling - davejs92@gmail.com
 */
public interface TreeService {

    Tree create(String content);

    Tree save(Tree tree);

    Tree findById(String id);

    Tree voteForTree(String id, boolean up);

    List<Tree> findTreesByVotes();

    TreeVote getCurrentUserVote(String treeId);

    List<Tree> findByCreator(String creator);
}
