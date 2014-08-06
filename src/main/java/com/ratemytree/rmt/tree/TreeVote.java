package com.ratemytree.rmt.tree;

/**
 * David Schilling - davejs92@gmail.com
 */
public class TreeVote {

    private String username;

    private boolean up;

    public TreeVote(String username, boolean up) {
        this.username = username;
        this.up = up;
    }

    public String getUsername() {
        return username;
    }

    public boolean isUp() {
        return up;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeVote treeVote = (TreeVote) o;

        if (username != null ? !username.equals(treeVote.username) : treeVote.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}
