package com.example.demo.Aggregator;

import org.springframework.stereotype.Repository;

import com.example.demo.Models.Poll;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PollRepository extends MongoRepository<Poll, Integer> {

    // Add methods and properties as needed
}
