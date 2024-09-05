package com.example.demo.Controllers;

import com.example.demo.Managers.PollManager;
import com.example.demo.Models.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voteOptions")
public class VoteOptionController {

    @Autowired
    private PollManager repo;

    @PostMapping
    public ResponseEntity<VoteOption> createVoteOption(@RequestBody VoteOption voteOption) {
        VoteOption createdVO = repo.createVoteOption(voteOption);
        return new ResponseEntity<>(createdVO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoteOption> getVoteOption(@PathVariable Integer id) {
        VoteOption voteOption = repo.getVoteOption(id);
        return new ResponseEntity<>(voteOption, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VoteOption>> getAllVoteOptions() {
        return new ResponseEntity<>(repo.getAllVoteOptions(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VoteOption> updateVoteOption(@PathVariable Integer id, @RequestBody VoteOption voteOption) {
        VoteOption updatedVoteOption = repo.updateVoteOption(id, voteOption);
        return new ResponseEntity<>(updatedVoteOption, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VoteOption> deleteVoteOption(@PathVariable Integer id) {
        repo.deleteVoteOption(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
