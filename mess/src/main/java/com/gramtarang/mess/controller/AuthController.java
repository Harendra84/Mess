package com.gramtarang.mess.controller;

import com.gramtarang.mess.common.MessException;
import com.gramtarang.mess.common.UserLoginDto;
import com.gramtarang.mess.entity.User;
import com.gramtarang.mess.facade.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;


@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final String ERP_SESSION_COOKIE = "ERPSessionId";


    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public @ResponseBody
    UserLoginDto login(@RequestParam("loginId") String email, @RequestParam("password") String password,
                       HttpServletRequest request) throws MessException {
        User user = userService.authenticateLogin(email, password);
        UserLoginDto dto = new UserLoginDto();
        if (user.getRole() != null) {
            dto.setRoleName(user.getRole().getRoleName());
        } else {
            dto.setRoleName(null);
        }
        dto.setSessionId(String.valueOf(user.getUserId()));
        request.getSession().setAttribute("USERID", user.getUserId());
        request.getSession().setAttribute("ROLE-NAME", user.getRole().getRoleName());
        return dto;
    }

    @PostMapping("/logout")
    public @ResponseBody
    UserLoginDto logout(HttpServletRequest request) throws MessException {
        request.getSession().invalidate();
        request.getSession().removeAttribute("USERID");
        request.getSession().removeAttribute("ROLE-TYPE");
        return new UserLoginDto();
    }


}
