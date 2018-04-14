package com.jt.demo.repository;

import com.jt.demo.entity.BookMark;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookMarkRepository extends MongoRepository<com.jt.demo.entity.BookMark, Integer>{
    public Optional<BookMark> findById(Integer id);
}
