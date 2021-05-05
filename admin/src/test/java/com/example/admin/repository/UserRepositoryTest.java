package com.example.admin.repository;

import com.example.admin.AdminApplicationTest;
import com.example.admin.model.entity.Item;
import com.example.admin.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
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
        String accout = "Test01";

        String password = "Test01";

        String status = "REGISTERED";

        String email = "Test01@gmail.com";

        String phoneNumber = "010-1111-2222";

        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();

        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(accout);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
    }



    @Test
    @Transactional
    public void read() {

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        // 연관관계 설정후 orderGroup가져오기
        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("-------- 장바구니 주문 묶음 --------");
            System.out.println("수령인 : " + orderGroup.getRevName());
            System.out.println("총 금액  : " + orderGroup.getTotalPrice());
            System.out.println("총 수량 : " + orderGroup.getTotalQuantity());
            System.out.println("수령지 : " + orderGroup.getRevAddress());

            System.out.println("-------- 주문 상세 --------");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문의 상태 : " + orderDetail.getStatus());
                System.out.println("도착 예정일자 : " + orderDetail.getArrival_date());

                System.out.println("주문상품 : " + orderDetail.getItem().getName());
                System.out.println("제조 : " + orderDetail.getItem().getBrandName());
                System.out.println("전화번호 : " + orderDetail.getItem().getPartner().getCallCenter());

            });
        });

        Assert.assertNotNull(user);
    }

//    @Test
//    public void create() {
//        // DI는 싱글톤
//        User user = new User();
//        user.setAccount("TestUser03");
//        user.setEmail("TestUser03@gmail.com");
//        user.setPhoneNumber("010-1111-3333");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setCreatedBy("admin");
//
//        User newUser = userRepository.save(user);
//        System.out.println("newUser : " + newUser.getId());
//        System.out.println("newUser : " + newUser.getAccount());
//        System.out.println("newUser : " + newUser.getEmail());
//        System.out.println("newUser : " + newUser);
//    }

//    @Test
//    @Transactional
//    public void read() {
//
//        /*
//            findById 는 Optional로 반환해준다.
//            (있을수도 있고 없을수도 있다.)
//         */
//
//        // select * from user where id = ?
//        Optional<User> user = userRepository.findById(7L);
//        user.ifPresent(selectUser -> {
//            System.out.println("user : " + selectUser.getAccount());
//            System.out.println("email : " + selectUser.getEmail());
//
//            selectUser.getOrderDetailList().stream().forEach(orderDetail -> {
//                Item item = orderDetail.getItem();
//
//                System.out.println("item : " + item);
//            });
//        });
//    }

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
