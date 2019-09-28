package com.atljl.springbootsecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class loginController {


    @RequestMapping("/")
    public String login()
    {
        return "login";
    }


    @RequestMapping("/logins")
    public String logins
            (           @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession httpSession
            )
    {
        if(username.equals("root")&&password.equals("123456"))
        {
            httpSession.setAttribute("username",username);
            httpSession.setAttribute("password",password);
            return "manager";
        }

        else
            return "error";

    }
}



