package com.ratemytree.rmt.user;

import com.ratemytree.rmt.tree.Tree;
import com.ratemytree.rmt.tree.TreeService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;
    private TreeService treeService;

    @Autowired
    public UserController(UserService userService, TreeService treeService) {
        this.userService = userService;
        this.treeService = treeService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public HttpEntity<UserDTO> createUser(@RequestBody @Valid UserPasswordDTO userPasswordDTO) {
        User user = userService.createUser(userPasswordDTO.getUsername(), userPasswordDTO.getPassword());
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{username}/trees", method = RequestMethod.GET)
    public HttpEntity<List<Tree>> getTreesForUser(@PathVariable String username) {
        List<Tree> trees = treeService.findByCreator(username);
        return new ResponseEntity<>(trees, HttpStatus.OK);
    }
}
