package com.gramtarang.mess.facade;

import com.gramtarang.mess.common.MessException;
import com.gramtarang.mess.entity.User;
import com.gramtarang.mess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
      public User authenticateLogin(String email, String password) throws MessException {
          User user = this.userRepository.findUserByEmailAddressAndPassword(email, password);
          if (user != null) {
             return user;
          }
          else {
              throw new MessException("Invalid User or Password");
          }
      }


}