package com.jt.demo.controller;

import com.jt.demo.entity.BookMark;
import com.jt.demo.repository.BookMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BookMarkController {
    @Autowired
    private BookMarkRepository bookMarkRepository;

    @RequestMapping("bookmark")
    public List<BookMark> getAllBookMark() {
        return bookMarkRepository.findAll();
    }

    @RequestMapping("saveBookmark")
    public void saveBookMark() {
        BookMark bookmark = new BookMark();

        bookmark.setId(2);
        bookmark.setUrl("test url 2");
        bookmark.setNote("test note 2");
        bookMarkRepository.save(bookmark);
    }

    @RequestMapping("getBookmark")
    public Optional<BookMark> getBookMarkBy() {
        BookMark bookmark = new BookMark();

//        bookmark.setId(2);
//        bookmark.setUrl("test url 2");
//        bookmark.setNote("test note 2");
        return bookMarkRepository.findById(1);
    }
}
