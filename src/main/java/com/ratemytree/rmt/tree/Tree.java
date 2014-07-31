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
    private String creator;
    @Field
    private int votesUp;
    @Field
    private int votesDown;
    @Field
    private DBObject content;


    public Tree() {
        //default constructor needed
    }

    public Tree(String content, String creator) {
        this.content = (DBObject)JSON.parse(content);
        this.creator = creator;
    }

    public int incrementVotesUp() {
        return ++votesUp;
    }

    public int incrementVotesDown() {
        return ++votesDown;
    }

    public String getId() {
        return id;
    }

    public int getVotesUp() {
        return votesUp;
    }

    public int getVotesDown() {
        return votesDown;
    }

    public DBObject getContent() {
        return content;
    }

    public String getCreator() {
        return creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tree tree = (Tree) o;

        if (votesDown != tree.votesDown) return false;
        if (votesUp != tree.votesUp) return false;
        if (content != null ? !content.equals(tree.content) : tree.content != null) return false;
        if (id != null ? !id.equals(tree.id) : tree.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + votesUp;
        result = 31 * result + votesDown;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id='" + id + '\'' +
                ", votesUp=" + votesUp +
                ", votesDown=" + votesDown +
                ", content=" + content +
                '}';
    }
}

