package com.djiman.projects.mongod.mongoDBClient.repository;

import com.djiman.projects.mongod.model.User;
import com.djiman.projects.mongod.mongoDBClient.MongoDbClientApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = {MongoDbClientApplication.class})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    public void testInsertNewUser() {
        User user = new User();
        user.setId(1);
        user.setNom("Ndong");
        user.setPrenom("Djiré");
        userRepository.insert(user);
    }
}