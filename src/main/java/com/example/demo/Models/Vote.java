package com.example.demo.Models;

import java.time.Instant;
import java.util.UUID;

public class Vote {

    private Integer id;
    private Instant publishedAt;

    public Vote(Instant publishedAt) {
        this.id = Math.abs(UUID.randomUUID().hashCode());
        this.publishedAt = publishedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }
}
