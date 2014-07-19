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
}
