package com.example.demo.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Arrays;

import static com.example.demo.mongodb.MongoDBMain.database;

public class MapReduceOperation {
    private MongoCollection<Document> collection;

    public MapReduceOperation(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    private void addDocs() {
        collection.insertMany(Arrays.asList(
                Document.parse("{ _id: 1, cust_id: 'Ant O. Knee', ord_date: '2020-03-01', price: 25, " +
                        "items: [ { sku: 'oranges', qty: 5, price: 2.5 }, { sku: 'apples', qty: 5, price: 2.5 } ], status: 'A' }"),
                Document.parse("{ _id: 2, cust_id: 'Ant O. Knee', ord_date: '2020-03-08', price: 70, " +
                        "items: [ { sku: 'oranges', qty: 8, price: 2.5 }, { sku: 'chocolates', qty: 5, price: 10 } ], status: 'A' }"),
                Document.parse("{ _id: 3, cust_id: 'Busby Bee', ord_date: '2020-03-08', price: 50, " +
                        "items: [ { sku: 'oranges', qty: 10, price: 2.5 }, { sku: 'pears', qty: 10, price: 2.5 } ], status: 'A' }"),
                Document.parse("{ _id: 4, cust_id: 'Busby Bee', ord_date: '2020-03-18', price: 25, " +
                        "items: [ { sku: 'oranges', qty: 10, price: 2.5 } ], status: 'A' }"),
                Document.parse("{ _id: 5, cust_id: 'Busby Bee', ord_date: '2020-03-19', price: 50, " +
                        "items: [ { sku: 'chocolates', qty: 5, price: 10 } ], status: 'A' }"),
                Document.parse("{ _id: 6, cust_id: 'Cam Elot', ord_date: '2020-03-19', price: 35, " +
                        "items: [ { sku: 'carrots', qty: 10, price: 1.0 }, { sku: 'apples', qty: 10, price: 2.5 } ], status: 'A' }"),
                Document.parse("{ _id: 7, cust_id: 'Cam Elot', ord_date: '2020-03-20', price: 25, " +
                        "items: [ { sku: 'oranges', qty: 10, price: 2.5 } ], status: 'A' }"),
                Document.parse("{ _id: 8, cust_id: 'Don Quis', ord_date: '2020-03-20', price: 75, " +
                        "items: [ { sku: 'chocolates', qty: 5, price: 10 }, { sku: 'apples', qty: 10, price: 2.5 } ], status: 'A' }"),
                Document.parse("{ _id: 9, cust_id: 'Don Quis', ord_date: '2020-03-20', price: 55, " +
                        "items: [ { sku: 'carrots', qty: 5, price: 1.0 }, { sku: 'apples', qty: 10, price: 2.5 }, { sku: 'oranges', qty: 10, price: 2.5 } ], status: 'A' }"),
                Document.parse("{ _id: 10, cust_id: 'Don Quis', ord_date: '2020-03-23', price: 25, " +
                        "items: [ { sku: 'oranges', qty: 10, price: 2.5 } ], status: 'A' }")
        ));
    }

    public void mapReduceCRUD() {
        addDocs();

        String mapFunction = "function() { emit(this.cust_id, this.price); }";

        String reduceFunction = "function(keyCustId, valuesPrices) { return Array.sum(valuesPrices); }";

        collection.mapReduce(mapFunction, reduceFunction).collectionName("map_reduce_example").toCollection();

        MongoCollection<Document> outputCollection = database.getCollection("map_reduce_example");

        System.out.println("Map-reduce result (sorted by _id):");
        for (Document doc : outputCollection.find().sort(new Document("_id", 1))) {
            System.out.println(doc.toJson());
        }
    }

    // People who creates an order on the same day
    public void mapReduceCustomOperation(String date) {
        addDocs();

        String mapFunction = "function() { if (this.ord_date === '" + date + "') emit(this.ord_date, this.cust_id); }";

        String reduceFunction = "function(orderDate, custIds) { return custIds; }";

        collection.mapReduce(mapFunction, reduceFunction).collectionName("map_reduce_same_order").toCollection();

        MongoCollection<Document> outputCollection = database.getCollection("map_reduce_same_order");

        System.out.println("Map-reduce result (filtered by date " + date + "):");
        for (Document doc : outputCollection.find().sort(new Document("_id", 1))) {
            System.out.println(doc.toJson());
        }
    }
}
