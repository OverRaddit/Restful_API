package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("mvc")
public class MVCController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("str", "Hello World!");
        return "example";
    }

    @GetMapping("/parameter")
    public String parameter(@RequestParam(value = "str", required = false) String str, Model model) {
        model.addAttribute("str", str);
        return "example";
    }
}


