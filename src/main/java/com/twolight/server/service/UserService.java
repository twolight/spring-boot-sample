package com.twolight.server.service;

import com.twolight.server.entity.Token;
import com.twolight.server.entity.User;
import com.twolight.server.repository.UserRepository;
import com.twolight.server.response.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public void register(String phone, String password) {
        User user = new User();
        user.setName(phone);
        user.setPhone(phone);
        user.setPassword(password);
        userRepository.save(user);
    }

    public LoginResult login(String username, String password) {
        User user = userService.getUserByName(username);
        if (user == null ||
                !user.getPassword().equals(password)) {
            return null;
        }

        Token token = tokenService.createToken(user.getId());

        LoginResult loginResult = new LoginResult();
        loginResult.setId(user.getId());
        loginResult.setUserName(user.getName());
        loginResult.setToken(token.toString());

        return loginResult;
    }

    public boolean logout(User user) {
        try {
            tokenService.deleteToken(user.getId());
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
