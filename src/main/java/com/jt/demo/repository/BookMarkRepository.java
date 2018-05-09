package com.jt.demo.repository;

import com.jt.demo.entity.movieDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

@Repository
public interface BookMarkRepository extends MongoRepository<movieDetails, String>{
//    public Optional<movieDetails> findById(Integer id);
}
