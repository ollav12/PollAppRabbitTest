package com.example.Managers;

import com.example.Models.Poll;
import com.example.Models.User;
import com.example.Models.Vote;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DomainManager {

    // Lagring i minnet ved bruk av HashMaps
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Poll> polls = new HashMap<>();
    private Map<Integer, Vote> votes = new HashMap<>();

    // User management
    public User createUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(Integer id) {
        return users.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public void deleteUser(Integer id) {
        users.remove(id);
    }

    // Poll CRUDs
    public Poll createPoll(Poll poll) {
        polls.put(poll.getId(), poll);
        return poll;
    }

    public Poll getPoll(Integer id) {
        return polls.get(id);
    }

    public Poll updatePoll(Integer id, Poll updatedPoll) {
        return polls.put(id, updatedPoll);
    }

    public Poll deletePoll(Integer id) {
        return polls.remove(id);
    }

    // Vote CRUDs
    public Vote createVote(Vote vote) {
        votes.put(vote.getId(), vote);
        return vote;
    }

    public Vote getVote(Integer id) {
        return votes.get(id);
    }

    public Vote updateVote(Integer id, Vote updatedVote) {
        return votes.put(id, updatedVote);
    }

    public Vote deleteVote(Integer id) {
        return votes.remove(id);
    }
}
