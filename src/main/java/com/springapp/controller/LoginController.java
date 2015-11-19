package com.springapp.controller;

import com.springapp.command.LoginCommand;
import com.springapp.entities.UserDetailJapanese;
import com.springapp.services.UserDetailJapaneseService;
import com.springapp.services.UserService;
import com.springapp.utils.ValidateProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Cuong on 2015/11/13.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailJapaneseService userDetailJapaneseService;

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(Model model) {
        LoginCommand command = new LoginCommand();
        model.addAttribute("command", command);
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(
            @ModelAttribute("command") LoginCommand command,
            BindingResult result,
            ModelMap model
    )
            throws Exception {

        if (result.hasErrors()) {
            return "login";
        }

        if (!userService.login(command.getLoginName(), command.getPassword())) {
            model.addAttribute("error", ValidateProperties.LOGIN_ERROR);
            return "login";
        }

        List<UserDetailJapanese> users = userService.getAllUserInfor();
        System.out.println(users.size());
        for (UserDetailJapanese user : users) {
            System.out.println(user.getUser().getFullName());
            System.out.println(user.getUser().getMainGroup().getGroupName());
            System.out.println();
        }

//        List<UserDetailJapanese> userDetailJapaneses = userDetailJapaneseService.getAllDetailUser();
//        for (UserDetailJapanese userDetailJapanese: userDetailJapaneses) {
//            System.out.println(userDetailJapanese.getJapanese().getNameLevel());
////            System.out.println(userDetailJapanese.getUser().getMainGroup().getGroupName());
//        }

        return "redirect:/user/listuser";
    }
}
