package com.twolight.server.contoller;

import com.twolight.server.common.annotation.Authorization;
import com.twolight.server.common.annotation.Login;
import com.twolight.server.common.utils.ResponseUtil;
import com.twolight.server.response.LoginResult;
import com.twolight.server.response.Response;
import com.twolight.server.entity.User;
import com.twolight.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Response getUser(@PathVariable("id") Long id) throws Exception {
        return ResponseUtil.success(userService.getUser(id));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestParam String username, @RequestParam String password) {
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");

        LoginResult loginResult = userService.login(username, password);
        if (loginResult != null) {
            return ResponseUtil.success(loginResult);
        } else {
            return ResponseUtil.error();
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    @Authorization
    public Response logout(@Login User user) {
        Assert.notNull(user, "user can not be empty");
        if (userService.logout(user)) {
            return ResponseUtil.success();
        } else {
            return ResponseUtil.error();
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response regsiter(String phone, String password) {
        Assert.notNull(phone, "phone can not be empty");
        Assert.notNull(password, "password can not be empty");
        userService.register(phone, password);
        return ResponseUtil.success();
    }
}
