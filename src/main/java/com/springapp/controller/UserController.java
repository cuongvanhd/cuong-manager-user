package com.springapp.controller;

import com.springapp.command.UserInforCommand;
import com.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Cuong on 2015/11/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listuser", method = RequestMethod.GET)
    public String showListUser(ModelMap model) {
        List<UserInforCommand> users = userService.getAllUserInfor();
        model.addAttribute("users", users);
        return "/user/listuser";
    }
}
