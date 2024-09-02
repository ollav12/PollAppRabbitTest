package com.example.Controllers;

import com.example.Managers.DomainManager;
import com.example.Domains.DomainModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/suggest")
public class DomainController {

    private final DomainManager repo;

    public DomainController(@Autowired DomainManager repo) {
        this.repo = repo;
    }
/*
    @GetMapping("/oslo")
    public Suggestion suggestOslo() {
        return new Suggestion(38, "umbrella");
    }
*/
/*
    @GetMapping("/{location}")
    public ResponseEntity<Suggestion> suggestBergen(@PathVariable String location) {
        if(location.equals("bergen")) {
            return ResponseEntity.ok(new Suggestion(38,"sunglasses"));
        } else if(location.equals("oslo")) {
            return ResponseEntity.ok(new Suggestion(38, "umbrella"));
        }
        return ResponseEntity.notFound().build();
    }
*/

    @GetMapping("/{location}")
    public ResponseEntity<DomainModel> suggestBergen(@PathVariable String location) {
        if(repo.getMap().containsKey(location)) {
            return ResponseEntity.ok(repo.getMap().get(location));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{location}")
    public ResponseEntity<DomainModel> createSuggestion(@PathVariable String location, @RequestBody DomainManager suggestion) {
        repo.getMap().put(location, suggestion);
        return ResponseEntity.created(URI.create("/" + location)).body(suggestion);
    }
}
