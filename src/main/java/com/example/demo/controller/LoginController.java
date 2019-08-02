package com.example.demo.controller;

import com.example.demo.dto.TesterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(name = "name") String name,
                        @RequestParam(name = "id") Long id,
                        @RequestParam(name = "pwd") String pwd,
                        HttpServletRequest request,
                        Model model) {

        if(name!=null&&id!=null&&pwd!=null)
        {
            //登录成功
            TesterUser testerUser=new TesterUser();
            testerUser.setName(name);
            testerUser.setId(id);
            testerUser.setPwd(pwd);
            request.getSession().setAttribute(name,testerUser);

            model.addAttribute("text", "Login Success");

            return "login";
        }
        else
        {
            //登录失败
        }
        model.addAttribute("text", "Login Fail");

        return "redirect:/greeting";
    }
}
