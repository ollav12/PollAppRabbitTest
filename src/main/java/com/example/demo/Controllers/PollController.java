package com.example.demo.Controllers;

import com.example.demo.Models.Poll;
import com.example.demo.Aggregator.PollRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private PollRepository pollRepository;

    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        Poll createdPoll = pollRepository.save(poll);
        rabbitTemplate.convertAndSend("pollQueue", poll.getQuestion());
        return new ResponseEntity<>(createdPoll, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable String id) {
        Optional<Poll> poll = pollRepository.findById(Integer.parseInt(id));
        if (poll.isPresent()) {
            return new ResponseEntity<>(poll.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Poll>> getAllPolls() {
        List<Poll> polls = pollRepository.findAll();
        return new ResponseEntity<>(polls, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Poll> updatePoll(@PathVariable String id, @RequestBody Poll pollDetails) {
        Optional<Poll> optionalPoll = pollRepository.findById((Integer.parseInt(id)));
        if (optionalPoll.isPresent()) {
            Poll poll = optionalPoll.get();
            poll.setQuestion(pollDetails.getQuestion());
            poll.setVoteOptions(pollDetails.getVoteOptions());
            // poll.setVotes(pollDetails.getVoteOptions());
            Poll updatedPoll = pollRepository.save(poll);
            return new ResponseEntity<>(updatedPoll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoll(@PathVariable String id) {
        if (pollRepository.existsById(Integer.parseInt(id))) {
            pollRepository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
