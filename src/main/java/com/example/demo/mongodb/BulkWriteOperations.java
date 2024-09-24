package com.example.demo.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.UpdateOneModel;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class BulkWriteOperations {
    private MongoCollection<Document> collection;

    public BulkWriteOperations(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void BulkWriteCRUDs() {
        // Pizza collection
        collection.bulkWrite(Arrays.asList(
                new InsertOneModel<>(new Document("_id", 0).append("type", "pepperoni").append("size", "small").append("price", 4)),
                new InsertOneModel<>(new Document("_id", 1).append("type", "cheese").append("size", "medium").append("price", 7)),
                new InsertOneModel<>(new Document("_id", 2).append("type", "vegan").append("size", "large").append("price", 8))
        ));

        try {
            collection.bulkWrite(Arrays.asList(
                    // Insert new documents
                    new InsertOneModel<>(new Document("_id", 3).append("type", "beef").append("size", "medium").append("price", 6)),
                    new InsertOneModel<>(new Document("_id", 4).append("type", "sausage").append("size", "large").append("price", 10)),

                    // Update an existing document
                    new UpdateOneModel<>(eq("type", "cheese"), set("price", 8)),

                    // Delete a document
                    new DeleteOneModel<>(eq("type", "pepperoni")),

                    // Replace an existing document
                    new ReplaceOneModel<>(eq("type", "vegan"), new Document("type", "tofu").append("size", "small").append("price", 4))
            ));

            System.out.println("Bulk-Write operations complete");
            for(Document doc : collection.find()) {
                System.out.println(doc.toJson());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
