package com.twolight.server.repository;

import com.twolight.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findById(Long id);

    User findByPhone(String phone);

//    @Query("from User u where u.name=:name")
//    User findUser(@Param("name") String name);
}
