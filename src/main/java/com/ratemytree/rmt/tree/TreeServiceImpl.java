package com.ratemytree.rmt.tree;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * David Schilling - davejs92@gmail.com
 */
@Service
public class TreeServiceImpl implements TreeService {

    private TreeRepository treeRepository;

    @Autowired
    public TreeServiceImpl(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    @Override
    public Tree create(String content) {
        return treeRepository.save(new Tree(content));
    }

    @Override
    public Tree save(Tree tree) {
        return treeRepository.save(tree);
    }

    @Override
    public Tree findById(String id) {
        return treeRepository.findOne(id);
    }

    @Override
    public Tree voteForTree(String id) {
        Tree tree = treeRepository.findOne(id);
        tree.incrementVote();
        return  treeRepository.save(tree);
    }

    @Override
    public List<Tree> findTreesByVotes() {
        Sort votesSort = new Sort(Sort.Direction.DESC, "votes");
        return treeRepository.findAll(votesSort);
    }
}
