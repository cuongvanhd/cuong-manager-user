package com.springapp.controller;

import com.springapp.command.UserInforCommand;
import com.springapp.services.UserService;
import com.springapp.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
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
    public String showListUser(@PageableDefault(5) Pageable pageable, ModelMap model) {
        List<UserInforCommand> users = userService.getAllUserInfor();
        Page<UserInforCommand> userInforCommands = new PageImpl<UserInforCommand>(users, pageable, users.size());

        model.addAttribute("userInforCommands", userInforCommands);
        model.addAttribute("pageable", pageable);
        model.addAttribute("pagination", new Pagination<UserInforCommand>(userInforCommands));
        return "/user/listuser";
    }
}
