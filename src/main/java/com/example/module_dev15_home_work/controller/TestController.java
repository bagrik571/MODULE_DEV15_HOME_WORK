package com.example.module_dev15_home_work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class TestController {
    @RequestMapping(value = "/testNote", method = {RequestMethod.GET})
    public ModelAndView test(){
        ModelAndView result = new ModelAndView("note/testNote");
        result.addObject("now", LocalDateTime.now());
        return result;
    }
}
