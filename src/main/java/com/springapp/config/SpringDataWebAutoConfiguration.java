package com.springapp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * Created by Cuong on 2015/11/25.
 */
@Configuration
@EnableSpringDataWebSupport
@ConditionalOnWebApplication
@ConditionalOnClass(PageableHandlerMethodArgumentResolver.class)
@ConditionalOnMissingBean(PageableHandlerMethodArgumentResolver.class)
public class SpringDataWebAutoConfiguration {
}
