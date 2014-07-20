package com.ratemytree.rmt.tree;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * David Schilling - davejs92@gmail.com
 */
@Document(collection = "tree")
public class Tree {

    @Id
    private String id;
    @Field
    private int votes;
    @Field
    private DBObject content;


    public Tree() {
        //default constructor needed
    }

    public Tree(String content) {
        this.content = (DBObject)JSON.parse(content);
    }

    public int incrementVote() {
        return ++votes;
    }

    public String getId() {
        return id;
    }

    public int getVotes() {
        return votes;
    }

    public DBObject getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tree tree = (Tree) o;

        if (votes != tree.votes) return false;
        if (content != null ? !content.equals(tree.content) : tree.content != null) return false;
        if (id != null ? !id.equals(tree.id) : tree.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + votes;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}

