package com.example.demo.mongodb;

import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.Objects;
import java.util.List;

public class InsertOperations {
    private MongoCollection<Document> collection;

    public InsertOperations(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void InsertCRUDs() {
        // Insert a single document
        Document canvas = new Document("item", "canvas")
                .append("qty", 100)
                .append("tags", List.of("cotton"));

        Document size = new Document("h", 28)
                .append("w", 35.5)
                .append("uom", "cm");
        canvas.put("size", size);
        collection.insertOne(canvas);

        // Insert multiple documents
        Document journal = new Document("item", "journal")
                .append("qty", 25)
                .append("tags", List.of("blank", "red"));

        Document journalSize = new Document("h", 14)
                .append("w", 21)
                .append("uom", "cm");
        journal.put("size", journalSize);

        Document mat = new Document("item", "mat")
                .append("qty", 85)
                .append("tags", List.of("gray"));

        Document matSize = new Document("h", 27.9)
                .append("w", 35.5)
                .append("uom", "cm");
        mat.put("size", matSize);

        Document mousePad = new Document("item", "mousePad")
                .append("qty", 25)
                .append("tags", List.of("gel", "blue"));

        Document mousePadSize = new Document("h", 19)
                .append("w", 22.85)
                .append("uom", "cm");
        mousePad.put("size", mousePadSize);

        collection.insertMany(List.of(journal, mat, mousePad));

        FindIterable<Document> allDocuments = collection.find();
        for (Document doc : allDocuments) {
            System.out.println(doc.toJson());
        }

        FindIterable<Document> result = collection.find(eq("item", "canvas"));
        System.out.println(Objects.requireNonNull(result.first()).toJson());
    }
}
