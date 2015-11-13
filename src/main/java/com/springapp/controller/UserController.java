package com.springapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Cuong on 2015/11/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/listuser", method = RequestMethod.GET)
    public String showListUser() {
        return "/user/listuser";
    }
}
