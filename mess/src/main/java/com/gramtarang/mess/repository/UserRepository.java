package com.gramtarang.mess.repository;

import com.gramtarang.mess.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("from User where email = :email and password = :password")
    User findUserByEmailAddressAndPassword(String email, String password);
}
