package com.springapp.controller;

import com.springapp.command.LoginCommand;
import com.springapp.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Cuong on 2015/11/13.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView setUpForm() {
        return new ModelAndView("login", "command", new LoginCommand());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm() {

        return "redirect:/user/listuser";
    }
}
