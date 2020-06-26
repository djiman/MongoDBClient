package com.djiman.projects.mongod.mongoDBClient.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.djiman.projects.mongod.model.User;
import com.djiman.projects.mongod.mongoDBClient.MongoDbClientApplication;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


@SpringBootTest(classes = {MongoDbClientApplication.class})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {

        userRepository.deleteAll();

        User user1 = new User();
        user1.setId(1);
        user1.setNom("Ndong");
        user1.setPrenom("Gorgui Djiré");
        userRepository.insert(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setNom("Diouf");
        user2.setPrenom("Ndeye Fatou");
        userRepository.insert(user2);
    }

    @Test
    public void testFindAll() {
        List<User> allUsers = userRepository.findAll();
        assertFalse(allUsers.isEmpty());
        assertTrue(allUsers.size() == 2);
    }

    @Test
    public void findOneUser() {
      Optional<User> user = userRepository.findById(1);
      assertEquals("Ndong", user.get().getNom());
    }

    @Test
    public void testFindUserByNom() {
        Optional<User> user = userRepository.findUserByNom("Diouf");
        assertEquals(2, user.get().getId());
        assertEquals("Ndeye Fatou", user.get().getPrenom());
    }

}