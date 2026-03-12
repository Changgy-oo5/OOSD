package common;

import java.io.Serializable;

public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int votes;

    public Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        votes++;
    }

    @Override
    public String toString() {
        return name + " - Votes: " + votes;
    }
}
