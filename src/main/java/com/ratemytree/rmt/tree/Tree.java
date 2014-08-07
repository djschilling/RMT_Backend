package com.ratemytree.rmt.tree;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.ratemytree.rmt.VoterException;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static java.util.Arrays.asList;

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
    @Field
    private DateTime created;

    private List<TreeVote> voters;


    public Tree() {
        voters = new ArrayList<>();
    }

    public Tree(String content, String creator, DateTime created) {
        this();
        this.content = (DBObject)JSON.parse(content);
        this.creator = creator;
        this.created = created;
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

    public Long getCreated() {
        return created.getMillis();
    }

    public void addVoter(TreeVote treeVote){
        if (voters.contains(treeVote)) {
            throw new VoterException("Voting can only be done one time per user.");
        }
        voters.add(treeVote);
    }

    public static List<String> getPossibleOrders() {
        return asList("votesUp", "votesDown", "created");
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

    public TreeVote getVoteForUser(String username) {
        for (TreeVote voter : voters) {
            if (voter.getUsername().equals(username)) {
                return voter;
            }
        }
        return null;
    }
}

