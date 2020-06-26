package com.djiman.projects.mongod.mongoDBClient.repository;

import com.djiman.projects.mongod.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    public Optional<User> findUserByNom(String pNom);

}
