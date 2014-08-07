package com.ratemytree.rmt.user;

/**
 * David Schilling - davejs92@gmail.com
 */
public class UserStatistics {

    private int upVotes;
    private int downVotes;
    private int treeCount;

    public UserStatistics(int upVotes, int downVotes, int treeCount) {
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.treeCount = treeCount;
    }

    public UserStatistics(int treeCount) {
        this.treeCount = treeCount;
        upVotes = 0;
        downVotes = 0;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public int getTreeCount() {
        return treeCount;
    }

    public void addUpVotes(int upVotes) {
        this.upVotes += upVotes;
    }
    public void addDownVotes(int downVotes) {
        this.downVotes += downVotes;
    }
}
