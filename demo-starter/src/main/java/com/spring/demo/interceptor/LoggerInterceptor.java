package com.spring.demo.interceptor;

import com.spring.demo.controller.api.ExceptionApiTranslator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Intercept all requests and log time usage.
 *
 * Have also an handler for username
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionApiTranslator.class);

    private static final String START_TIME_REQUEST_ATTR = "startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        LOG.info("Request {} started at {}", request.getRequestURL(), startTime);
        request.setAttribute(START_TIME_REQUEST_ATTR, startTime);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (long) request.getAttribute(START_TIME_REQUEST_ATTR);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        LOG.info("Request {} took ~ {} ms", request.getRequestURL(), duration);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            modelAndView.addObject("userName", authentication.getName());
        }
    }
}
