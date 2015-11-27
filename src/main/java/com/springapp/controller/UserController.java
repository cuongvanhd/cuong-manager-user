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

        int totalRecordUser = userService.getSizeTotalUserInfor();
        List<UserInforCommand> userInforCommands = userService.getAllUserInfor(pageable);
        Page<UserInforCommand> inforCommands = new PageImpl<UserInforCommand>(userInforCommands, pageable, totalRecordUser);
        Pagination<UserInforCommand> pagination = new Pagination<UserInforCommand>(inforCommands);

        model.addAttribute("userInforCommands", userInforCommands);
        model.addAttribute("pageable", pageable);
        model.addAttribute("pagination", pagination);
        return "/user/listuser";
    }
}
