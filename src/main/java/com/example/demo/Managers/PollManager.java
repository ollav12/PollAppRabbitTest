package com.example.demo.Managers;

import com.example.demo.Models.Poll;
import com.example.demo.Models.User;
import com.example.demo.Models.Vote;
import com.example.demo.Models.VoteOption;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PollManager {

    // Lagring i minnet ved bruk av HashMaps
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Poll> polls = new HashMap<>();
    private Map<Integer, Vote> votes = new HashMap<>();
    private Map<Integer, VoteOption> voteOptions = new HashMap<>();

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

    public User updateUser(Integer id, User updatedUser) {
        User existingUser = users.get(id);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
        }
        return existingUser;
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

    public List<Poll> getAllPolls() {
        return new ArrayList<>(polls.values());
    }

    public Poll updatePoll(Integer id, Poll updatedPoll) {
        return polls.put(id, updatedPoll);
    }

    public void deletePoll(Integer id) {
        polls.remove(id);
    }

    // Vote CRUDs
    public Vote createVote(Vote vote) {
        votes.put(vote.getId(), vote);
        return vote;
    }

    public Vote getVote(Integer id) {
        return votes.get(id);
    }

    public List<Vote> getAllVotes() {
        return new ArrayList<>(votes.values());
    }

    public Vote updateVote(Integer id, Vote updatedVote) {
        return votes.put(id, updatedVote);
    }

    public void deleteVote(Integer id) {
        votes.remove(id);
    }

    // VoteOption CRUDs
    public VoteOption createVoteOption(VoteOption voteOption) {
        voteOptions.put(voteOption.getId(), voteOption);
        return voteOption;
    }
    public VoteOption getVoteOption(Integer id) { return voteOptions.get(id); }

    public List<VoteOption> getAllVoteOptions() {
        return new ArrayList<>(voteOptions.values());
    }

    public VoteOption updateVoteOption(Integer id, VoteOption updatedVoteOption) { return voteOptions.put(id, updatedVoteOption); }

    public void deleteVoteOption(Integer id) { voteOptions.remove(id); }

}
