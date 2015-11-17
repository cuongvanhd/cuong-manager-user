package com.springapp.controller;

import com.springapp.command.LoginCommand;
import com.springapp.services.UserService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Cuong on 2015/11/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest extends TestCase {

    @InjectMocks
    LoginController loginController;

    @Mock
    UserService userService;

    @Mock
    BindingResult result;

    @Mock
    ModelMap model;

    private MockMvc mockMvc;

    LoginCommand command;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).setViewResolvers(viewResolver).build();

        command = new LoginCommand();
        command.setLoginName("cuong");
        command.setPassword("cuong");
    }

    @Test
    public void testSetUpForm() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("command"))
                .andExpect(view().name("login"));
    }

    @Test
    public void testProcessFormWhenLoginFalse() throws Exception {

        when(userService.login(command.getLoginName(), command.getPassword())).thenReturn(false);

        mockMvc.perform(post("/login").flashAttr("command", command))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("error"))
                .andExpect(view().name("login"));

        verify(userService).login(command.getLoginName(), command.getPassword());
    }

    @Test
    public void testProcessFormWhenLoginSuccess() throws Exception {

        when(userService.login(command.getLoginName(), command.getPassword())).thenReturn(true);

        mockMvc.perform(post("/login").flashAttr("command", command))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/user/listuser"));

        verify(userService).login(command.getLoginName(), command.getPassword());
    }

    @Test
    public void testProcessFormWhenResutlError() throws Exception {
        when(result.hasErrors()).thenReturn(true);

        String actual = loginController.processForm(command, result, model);

        verify(result).hasErrors();
        assertThat(actual, is("login"));

    }
}