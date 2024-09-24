package com.example.demo.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class DeleteOperations {
    private MongoCollection<Document> collection;

    public DeleteOperations(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void DeleteAllDocs() {
        collection.deleteMany(new Document());
        System.out.println("\nAll documents deleted. \n");

        FindIterable<Document> AllDocs = collection.find();
        for(Document doc : AllDocs) {
            System.out.println(doc.toJson());
        }
    }

    public void DeleteSpecificDocs() {
        FindIterable<Document> allDocumentsBefore = collection.find(eq("status", "A"));
        System.out.println("Documents to be deleted");
        for(Document doc : allDocumentsBefore) {
            System.out.println(doc.toJson());
        }

        collection.deleteMany(eq("status", "A"));

        FindIterable<Document> allDocumentsAfter = collection.find(eq("status", "A"));
        System.out.println("Documents deleted");
        for(Document doc : allDocumentsAfter) {
            System.out.println(doc.toJson());
        }
    }

    public void DeleteOneSpecificDoc() {
        FindIterable<Document> DocumentsBefore = collection.find(eq("status", "D"));
        System.out.println("Documents to delete from");
        for(Document doc : DocumentsBefore) {
            System.out.println(doc.toJson());
        }

        collection.deleteOne(eq("status", "D"));

        FindIterable<Document> DocumentsAfter = collection.find(eq("status", "D"));
        System.out.println("\n One document deleted");
        for(Document doc : DocumentsAfter) {
            System.out.println(doc.toJson());
        }
    }




}
