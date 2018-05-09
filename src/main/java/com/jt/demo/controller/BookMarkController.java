package com.jt.demo.controller;

import com.jt.demo.DemoApplication;
import com.jt.demo.entity.movieDetails;
import com.jt.demo.repository.BookMarkRepository;
import com.jt.demo.service.Amqp;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BookMarkController {
    @Autowired
    private BookMarkRepository bookMarkRepository;

    @Autowired
    private Amqp amqp;

    @RequestMapping("bookmark")
    public List<movieDetails> getAllBookMark() {
        return bookMarkRepository.findAll();
    }

    @RequestMapping("saveBookmark")
    public void saveBookMark() {
        movieDetails bookmark = new movieDetails();

//        bookmark.setId(2);
//        bookmark.setUrl("test url 2");
//        bookmark.setNote("test note 2");
        bookMarkRepository.save(bookmark);
    }

    @RequestMapping("getBookmark")
    public Optional<movieDetails> getBookMarkBy() {
        movieDetails bookmark = new movieDetails();

//        bookmark.setId(2);
//        bookmark.setUrl("test url 2");
//        bookmark.setNote("test note 2");
        return bookMarkRepository.findById("1");
    }

    @RequestMapping("sendMsg")
    public void sendMessage() {

        amqp.sendMessage("hello world send");
    }
}
