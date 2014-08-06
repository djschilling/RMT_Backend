package com.ratemytree.rmt.tree;

import com.ratemytree.rmt.restapi.EntryNotFoundException;
import com.ratemytree.rmt.user.User;
import com.ratemytree.rmt.user.UserService;
import java.util.List;
import org.joda.time.DateTime;
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
        return treeRepository.save(new Tree(content, userService.getCurrentlyLoggedIn().getUsername(), new DateTime()));
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
    public Tree voteForTree(String id, boolean up) {
        Tree tree = treeRepository.findOne(id);
        User currentUser = userService.getCurrentlyLoggedIn();
        tree.addVoter(new TreeVote(currentUser.getUsername(), up));
        if(up){
            tree.incrementVotesUp();
        } else {
            tree.incrementVotesDown();
        }
        return treeRepository.save(tree);
    }

    @Override
    public List<Tree> findTreesByVotes() {
        Sort votesSort = new Sort(Sort.Direction.DESC, "votesUp");
        return treeRepository.findAll(votesSort);
    }

    @Override
    public TreeVote getCurrentUserVote(String treeId) {
        Tree tree = treeRepository.findOne(treeId);
        User currentUser = userService.getCurrentlyLoggedIn();

        TreeVote treeVote = tree.getVoteForUser(currentUser.getUsername());
        if(treeVote == null) {
            throw new EntryNotFoundException("Not vote for user " + currentUser.getUsername());
        }
        return treeVote;
    }
}
