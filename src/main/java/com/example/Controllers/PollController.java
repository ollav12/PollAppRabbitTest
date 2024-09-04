package com.example.Controllers;

import com.example.Managers.DomainManager;
import com.example.Models.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private DomainManager repo;

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return repo.createPoll(poll);
    }

    @GetMapping("/{id}")
    public Poll getPoll(@PathVariable Integer id) {
        return repo.getPoll(id);
    }

    @PutMapping("/{id}")
    public Poll updatePoll(@PathVariable Integer id, @RequestBody Poll poll) {
        return repo.updatePoll(id, poll);
    }

    @DeleteMapping("/{id}")
    public Poll deletePoll(@PathVariable Integer id) {
        return repo.deletePoll(id);
    }
}
