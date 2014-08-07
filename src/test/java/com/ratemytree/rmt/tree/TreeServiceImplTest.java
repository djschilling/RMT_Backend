package com.ratemytree.rmt.tree;

import com.ratemytree.rmt.user.AuthenticationService;
import com.ratemytree.rmt.user.User;
import com.ratemytree.rmt.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * David Schilling - davejs92@gmail.com
 */
@RunWith(MockitoJUnitRunner.class)
public class TreeServiceImplTest {

    private TreeServiceImpl sut;

    @Mock
    private TreeRepository treeRepositoryMock;

    @Mock
    private AuthenticationService authenticationService;

    @Before
    public void setUp() throws Exception {
        sut = new TreeServiceImpl(treeRepositoryMock, authenticationService);

    }

    @Test
    public void voteUpForTree() {
        Tree tree = new Tree();
        Tree incrementedVotesTree = new Tree();
        incrementedVotesTree.incrementVotesUp();
        when(treeRepositoryMock.findOne("5")).thenReturn(tree);
        when(treeRepositoryMock.save(incrementedVotesTree)).thenReturn(incrementedVotesTree);
        when(authenticationService.getCurrentlyLoggedIn()).thenReturn(new User("foo", "bar"));

        Tree updatedTree = sut.voteForTree("5", true);

        assertThat(updatedTree.getVotesUp(), is(1));
    }
}
