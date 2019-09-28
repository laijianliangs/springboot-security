package com.atljl.springbootsecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AllController {




    @RequestMapping("/manager")
    public String first()
    {
        return "manager";
    }

    @RequestMapping("/emp")
    public String emp()
    {
        return "emp";
    }

    @RequestMapping("monitor")
    public String monitor()
    {
        return "monitor";
    }

    @RequestMapping("/boss")
    public String boss()
    {
        return "boss";
    }

}
