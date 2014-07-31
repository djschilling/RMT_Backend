package com.ratemytree.rmt.tree;

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

    @Before
    public void setUp() throws Exception {
        sut = new TreeServiceImpl(treeRepositoryMock, null);

    }

    @Test
    public void voteUpForTree() {
        Tree tree = new Tree();
        Tree incrementedVotesTree = new Tree();
        incrementedVotesTree.incrementVotesUp();
        when(treeRepositoryMock.findOne("5")).thenReturn(tree);
        when(treeRepositoryMock.save(incrementedVotesTree)).thenReturn(incrementedVotesTree);

        Tree updatedTree = sut.voteUpForTree("5");

        assertThat(updatedTree.getVotesUp(), is(1));
    }


}
