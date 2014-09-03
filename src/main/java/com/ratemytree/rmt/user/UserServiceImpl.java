package com.ratemytree.rmt.user;

import com.ratemytree.rmt.EntityNotFoundException;
import com.ratemytree.rmt.tree.Tree;
import com.ratemytree.rmt.tree.TreeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * David Schilling - davejs92@gmail.com
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TreeService treeService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TreeService treeService) {
        this.userRepository = userRepository;
        this.treeService = treeService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        return user;
    }

    @Override
    public User createUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            return userRepository.save(new User(username, password));
        } else {
            throw new UserServiceException("User with name " + username + " already exists.");
        }
    }


    @Override
    public UserStatistics getUserStatistics(String username) {
        try {
            loadUserByUsername(username);
            List<Tree> trees = treeService.findByCreator(username);
            UserStatistics userStatistics = new UserStatistics(trees.size());
            for (Tree tree : trees) {
                userStatistics.addUpVotes(tree.getVotesUp());
                userStatistics.addDownVotes(tree.getVotesDown());
            }
            return userStatistics;

        } catch (UsernameNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
