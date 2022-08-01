package com.bob.projects.graphql.repository;

import com.bob.projects.graphql.model.Singer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SingerRepository extends MongoRepository<Singer, String> {
    @Query("{ 'name' : ?0 }")
    List<Singer> findByName(String name);

    @Query("{ 'name' : { $regex: ?0 } }")
    List<Singer> findByNameRegex(String regexp);

    @Query("{ 'age' : { $gt: ?0, $lt: ?1 } }")
    List<Singer> findByAgeBetween(int ageGT, int ageLT);
}
