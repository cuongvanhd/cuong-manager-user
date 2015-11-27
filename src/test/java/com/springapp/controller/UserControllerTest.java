package com.springapp.controller;

import com.springapp.command.UserInforCommand;
import com.springapp.entities.User;
import com.springapp.services.UserService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Cuong on 2015/11/24.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest extends TestCase {

    private MockMvc mockMvc;

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Mock
    ModelMap model;

    @Mock
    Pageable pageable;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(userController).setViewResolvers(viewResolver).build();
    }

    @Test
    public void testShowListUser() throws Exception {

        when(userService.getAllUserInfor(pageable)).thenReturn(new ArrayList<UserInforCommand>());
        when(userService.getSizeTotalUserInfor()).thenReturn(anyInt());

        mockMvc.perform(get("/user/listuser"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attributeExists("pageable"))
                .andExpect(model().attributeExists("pagination"))
                .andExpect(view().name("/user/listuser"));

        verify(userService).getAllUserInfor(pageable);
        verify(userService).getSizeTotalUserInfor();
    }
}