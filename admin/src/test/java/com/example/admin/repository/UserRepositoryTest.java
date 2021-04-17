package com.example.admin.repository;

import com.example.admin.AdminApplicationTest;
import com.example.admin.UserRepository;
import com.example.admin.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends AdminApplicationTest {

    /*
        spring의 장점, design patter, DI(의존성주입) 직접 객체를 만들지 않고 스프링이 직접 관리를 하겠다.
        어플리케이션이 실행될때 Autowired를 찾아서 주입을 시켜준다.
     */
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        // DI는 싱글톤
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser.getId());
        System.out.println("newUser : " + newUser.getAccount());
        System.out.println("newUser : " + newUser.getEmail());
        System.out.println("newUser : " + newUser);
    }

    @Test
    public void read() {

        /*
            findById 는 Optional로 반환해준다.
            (있을수도 있고 없을수도 있다.)
         */
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(selectUser -> {
            System.out.println("user : " + selectUser);
            System.out.println("email : " + selectUser.getEmail());
        });
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser -> {
            selectUser.setAccount("TestUser02_update");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("admin2");

            userRepository.save(selectUser);
        });

    }

    @Test
    @Transactional  // database의 실행시킨후 다시 롤백 시켜준다
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

        Assert.assertTrue(user.isPresent());    // true

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);
        Assert.assertFalse(deleteUser.isPresent()); // false

//        if(deleteUser.isPresent()) {
//            System.out.println("data : " + deleteUser.get());
//        } else {
//            System.out.println("no data");
//        }

    }
}
