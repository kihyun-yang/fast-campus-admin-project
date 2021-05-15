package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    @Transactional
    @Test
    public void read() {
//        Optional<User> user = userRepository.findByAccount("TestUser01");
//
//        user.ifPresent(selectUser -> {
//
//            selectUser.getOrderDetailList().forEach(detail -> {
//                Item item = detail.getItem();
//                System.out.println(item);
//            });
//
//        });
    }

    @Transactional
    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Transactional
    @Test
    public void delete() {
        Optional<User> user = userRepository.findById(1L);

        assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

        if (deleteUser.isPresent()) {
            System.out.println("데이터 존재: " + deleteUser.get());
        } else {
            System.out.println("데이터 삭제 데이터 없음");
        }

        assertFalse(deleteUser.isPresent());
    }


}
