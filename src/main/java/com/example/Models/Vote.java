package com.example.Models;

import java.time.Instant;
import java.util.UUID;

public class Vote {

    private Integer id = UUID.randomUUID().hashCode();
    private Instant publishedAt;

    public Vote(Integer id, Instant publishedAt) {
        this.id = id;
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
