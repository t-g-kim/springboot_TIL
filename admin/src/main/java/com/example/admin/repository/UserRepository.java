package com.example.admin.repository;

import com.example.admin.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    // Optional 있을수도 있고 없을수도 있다.
//    // select * from user where account = ?
//    Optional<User> findByAccount(String account);
//
//    Optional<User> findByEmail(String email);
//
//    // select * from user where account = ? and email = ?
//    Optional<User> findByAccountAndEmail(String account, String email);

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
}

