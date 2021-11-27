package com.spark.lms.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spark.lms.common.Constants;
import com.spark.lms.model.User;

@Controller
public class DefaultController {
	@RequestMapping("/default")
    public String defaultAfterLogin() {
		Collection<? extends GrantedAuthority> authorities;
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        authorities = auth.getAuthorities();
        String myRole = authorities.toArray()[0].toString();
        String admin = Constants.MEMBER_STUDENT;
        if (myRole.equals(admin) || myRole.equals(Constants.MEMBER_PARENT)) {
            return "redirect:/StudentHome/";
        }
        return "redirect:/home/";
    }

}
