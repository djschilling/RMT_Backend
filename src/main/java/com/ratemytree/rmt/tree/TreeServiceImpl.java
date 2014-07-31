package com.ratemytree.rmt.tree;

import com.ratemytree.rmt.user.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * David Schilling - davejs92@gmail.com
 */
@Service
public class TreeServiceImpl implements TreeService {

    private final TreeRepository treeRepository;
    private final UserService userService;

    @Autowired
    public TreeServiceImpl(TreeRepository treeRepository, UserService userService) {
        this.treeRepository = treeRepository;
        this.userService = userService;
    }

    @Override
    public Tree create(String content) {
        return treeRepository.save(new Tree(content, userService.getCurrentlyLoggedIn().getUsername()));
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
    public Tree voteUpForTree(String id) {
        Tree tree = treeRepository.findOne(id);
        tree.incrementVotesUp();
        return  treeRepository.save(tree);
    }

    @Override
    public Tree voteDownForTree(String id) {
        Tree tree = treeRepository.findOne(id);
        tree.incrementVotesDown();
        return  treeRepository.save(tree);
    }


    @Override
    public List<Tree> findTreesByVotes() {
        Sort votesSort = new Sort(Sort.Direction.DESC, "votesUp");
        return treeRepository.findAll(votesSort);
    }
}
