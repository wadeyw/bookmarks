package com.jt.demo.service;

import com.jt.demo.entity.BookMark;
import com.jt.demo.repository.BookMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateBookMark implements CommandLineRunner {

    @Autowired
    private BookMarkRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        BookMark bookmark = new BookMark();

        bookmark.setId(1);
        bookmark.setUrl("test url");
        bookmark.setNote("test note");


        // save a couple of colleagues
        repository.save(bookmark);

        // fetch all colleagues
        System.out.println("Colleagues found with findAll():");
        System.out.println("-------------------------------");
        for (BookMark colleague : repository.findAll()) {
            System.out.println(colleague.id);
        }
        System.out.println();

    }
}
