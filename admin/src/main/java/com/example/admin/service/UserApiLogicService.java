package com.example.admin.service;

import com.example.admin.ifs.CrudInterface;
import com.example.admin.model.entity.User;
import com.example.admin.model.network.Header;
import com.example.admin.model.network.request.UserApiRequest;
import com.example.admin.model.network.response.UserApiResponse;
import com.example.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    // 1. request data
    // 2. user 생성
    // 3. 생성된 데이터 -> UserApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. request data
        UserApiRequest userApiRequest = request.getData();

        // 2. user 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);

        // 3. 생성된 데이터 -> UserApiResponse return

        return response(user);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        return userRepository.findById(id).map(user -> response(user)).orElseGet(() -> Header.ERROR("데이터 없음"));
//        // id -> repository getOne, getById
//        Optional<User> optionalUser = userRepository.findById(id);
//
//        // user -> userApiResponse return
//        return optionalUser.map(user -> response(user)).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        // 1. data
        UserApiRequest userApiRequest = request.getData();

        // 2. id -> user 데이터를 찾고
        Optional<User> optionalUser = userRepository.findById(userApiRequest.getId());

        // 3. data 0> update
        return optionalUser.map(user -> {
            // chain이 걸려있기 때문에 가능
            user.setAccount(userApiRequest.getAccount())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());

            return user;

        })
        .map(user -> userRepository.save(user))       // update
        .map(updateUser -> response(updateUser))                  // userApiResponse
        .orElseGet(() -> Header.ERROR("데이터 없음"));

        // 4. userApiResponse
    }

    @Override
    public Header delete(Long id) {

        // 1. id -> repository -> user
        Optional<User> optionalUser = userRepository.findById(id);

        // 2. repository -> delete
        return optionalUser.map(user -> {
            userRepository.delete(user);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
        // 3. response return
    }

    private Header<UserApiResponse> response(User user) {
        // user -> userAPIResponse

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())   //todo 암호화, 길
                .eamil(user.getAccount())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

         // Header + data return
        return Header.OK(userApiResponse);
    }
}
