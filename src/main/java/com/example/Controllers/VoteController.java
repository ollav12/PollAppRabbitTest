package com.example.Controllers;

import com.example.Managers.DomainManager;
import com.example.Models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private DomainManager repo;

    @PostMapping
    public Vote createVote(@RequestBody Vote vote) {
        return repo.createVote(vote);
    }

    @GetMapping("/{id}")
    public Vote getVote(@PathVariable Integer id) {
        return repo.getVote(id);
    }

    @PutMapping("/{id}")
    public Vote updateVote(@PathVariable Integer id, @RequestBody Vote vote) {
        return repo.updateVote(id, vote);
    }

    @DeleteMapping("/{id}")
    public Vote deleteVote(@PathVariable Integer id) {
        return repo.deleteVote(id);
    }
}
