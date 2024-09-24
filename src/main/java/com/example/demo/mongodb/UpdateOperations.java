package com.example.demo.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Updates.*;

public class UpdateOperations {
    private MongoCollection<Document> collection;

    public UpdateOperations(MongoCollection<Document> collection) { this.collection = collection;}

    public void UpdateCRUDs() {
        System.out.println("Before update");
        FindIterable<Document> allDocumentsBefore = collection.find();
        for (Document doc : allDocumentsBefore) {
            System.out.println(doc.toJson());
        }

        System.out.println(collection.updateOne(eq("item", "mat"),
                combine(set("size.uom", "cm"), set("status", "P"), currentDate("lastModified"))));

        System.out.println(collection.updateMany(lt("qty", 50),
                combine(set("size.uom", "in"), set("status", "P"), currentDate("lastModified"))));

        System.out.println(collection.replaceOne(eq("item", "paper"),
                Document.parse("{ item: 'paper', instock: [ { warehouse: 'A', qty: 60 }, { warehouse: 'B', qty: 40 } ] }")));

        System.out.println("After update");
        FindIterable<Document> allDocumentsAfter = collection.find();
        for (Document doc : allDocumentsAfter) {
            System.out.println(doc.toJson());
        }
    }
}
