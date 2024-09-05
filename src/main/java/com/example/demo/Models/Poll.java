package com.example.demo.Models;

import java.time.Instant;
import java.util.UUID;

public class Poll {

    private Integer id;
    private String question;
    private Instant publishedAt;
    private Instant validUntil;

    public Poll(String question, Instant publishedAt, Instant validUntil) {
        this.id = Math.abs(UUID.randomUUID().hashCode());
        this.question = question;
        this.publishedAt = publishedAt;
        this.validUntil = validUntil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }
}
