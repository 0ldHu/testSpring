package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestFormController {
    @GetMapping("/testFrom")
    public String testFrom()
    {
        return "test_form";
    }
}
