package com.example.demo.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;

public class QueryOperations {
    private MongoCollection<Document> collection;

    public QueryOperations(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void QueryCRUDs(String status) {
        FindIterable<Document> findAllDocs = collection.find(new Document());
        System.out.println(); // Prettier print
        for (Document doc : findAllDocs) {
            System.out.println(doc.toJson());
        }

        FindIterable<Document> findDocsWithStatus = collection.find(eq("status", status));
        System.out.println(); // Prettier print
        for (Document doc : findDocsWithStatus) {
            System.out.println(doc.toJson());
        }

        FindIterable<Document> findDocsAandLessThan30 = collection.find(and(eq("status", "A"), lt("qty", 30)));
        System.out.println(); // Prettier print
        for (Document doc : findDocsAandLessThan30) {
            System.out.println(doc.toJson());
        }

        FindIterable<Document> findDocsAorLessThan30 = collection.find(or(eq("status", "A"), lt("qty", 30)));
        System.out.println(); // Prettier print
        for (Document doc : findDocsAorLessThan30) {
            System.out.println(doc.toJson());
        }

        FindIterable<Document> findAndOrOrConditions = collection.find(
                and(eq("status", "A"), or(lt("qty", 30), regex("item", "^p")))
        );
        System.out.println(); // Prettier print
        for (Document doc : findAndOrOrConditions) {
            System.out.println(doc.toJson());
        }
    }
}
