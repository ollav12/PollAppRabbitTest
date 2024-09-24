package com.example.demo.mongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.UpdateOneModel;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import static java.util.Arrays.asList;

public class MongoDBMain {
    private MongoClient mongoClient;
    public static MongoCollection<Document> collection;
    public static MongoDatabase database;

    public MongoDBMain(String databaseName, String collectionName) {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase(databaseName);
        collection = database.getCollection(collectionName);
    }

    private static void AddDocs() {
        collection.insertMany(asList(
                Document.parse("{ item: 'canvas', qty: 100, size: { h: 28, w: 35.5, uom: 'cm' }, status: 'A' }"),
                Document.parse("{ item: 'journal', qty: 25, size: { h: 14, w: 21, uom: 'cm' }, status: 'A' }"),
                Document.parse("{ item: 'mat', qty: 85, size: { h: 27.9, w: 35.5, uom: 'cm' }, status: 'A' }"),
                Document.parse("{ item: 'mousepad', qty: 25, size: { h: 19, w: 22.85, uom: 'cm' }, status: 'P' }"),
                Document.parse("{ item: 'notebook', qty: 50, size: { h: 8.5, w: 11, uom: 'in' }, status: 'P' }"),
                Document.parse("{ item: 'paper', qty: 100, size: { h: 8.5, w: 11, uom: 'in' }, status: 'D' }"),
                Document.parse("{ item: 'planner', qty: 75, size: { h: 22.85, w: 30, uom: 'cm' }, status: 'D' }"),
                Document.parse("{ item: 'postcard', qty: 45, size: { h: 10, w: 15.25, uom: 'cm' }, status: 'A' }"),
                Document.parse("{ item: 'sketchbook', qty: 80, size: { h: 14, w: 21, uom: 'cm' }, status: 'A' }"),
                Document.parse("{ item: 'sketch pad', qty: 95, size: { h: 22.85, w: 30.5, uom: 'cm' }, status: 'A' }")
        ));
    }

    public static void main(String[] args) {
        MongoDBMain service = new MongoDBMain("testdb", "testCollection");

        InsertOperations insertCRUD = new InsertOperations(collection);
        QueryOperations queryCRUD = new QueryOperations(collection);
        UpdateOperations updateCRUD = new UpdateOperations(collection);
        DeleteOperations deleteCRUD = new DeleteOperations(collection);
        BulkWriteOperations bulkWriteCRUD = new BulkWriteOperations(collection);
        MapReduceOperation mapReduce = new MapReduceOperation(collection);

        //insertCRUD.InsertCRUDs();

        //(Unless running mapReduce) Keep uncommented so operations have documents
        //AddDocs();

        //queryCRUD.QueryCRUDs("D");

        //updateCRUD.UpdateCRUDs();

        //deleteCRUD.DeleteSpecificDocs();
        //deleteCRUD.DeleteOneSpecificDoc();

        //bulkWriteCRUD.BulkWriteCRUDs();

        //mapReduce.mapReduceCRUD();

        mapReduce.mapReduceCustomOperation("2020-03-20");


        // Keep uncommented to clean up the database after operations
        deleteCRUD.DeleteAllDocs();

        service.mongoClient.close();
    }
}
