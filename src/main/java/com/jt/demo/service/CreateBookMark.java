//package com.jt.demo.service;
//
//import com.jt.demo.entity.movieDetails;
//import com.jt.demo.repository.BookMarkRepository;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoDatabase;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class CreateBookMark implements CommandLineRunner {
//
//    @Autowired
//    private BookMarkRepository repository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
////        repository.deleteAll();
////
////        movieDetails bookmark = new movieDetails();
////
////        bookmark.setId(1);
////        bookmark.setUrl("test url");
////        bookmark.setNote("test note");
////
////
////        // save a couple of colleagues
////        repository.save(bookmark);
////
////        // fetch all colleagues
////        System.out.println("Colleagues found with findAll():");
////        System.out.println("-------------------------------");
////        for (movieDetails colleague : repository.findAll()) {
////            System.out.println(colleague.id);
////        }
//        MongoClientURI uri = new MongoClientURI(
//                "mongodb+srv://mongoGold:900907@holimongo-3eti5.mongodb.net/");
//
//        MongoClient mongoClient = new MongoClient(uri);
//        MongoDatabase database = mongoClient.getDatabase("video");
//
//        System.out.println(database.listCollectionNames());
//
//    }
//}
