package com.example.demo.controller;

import com.example.demo.dto.TesterUser;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    public String login(@RequestParam(name = "name") String name,
                        @RequestParam(name = "id") Long id,
                        @RequestParam(name = "pwd") String pwd,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        Model model) {

        if(name!=null&&id!=null&&pwd!=null)
        {
            //登录成功
            TesterUser testerUser=new TesterUser();
            testerUser.setName(name);
            testerUser.setId(id);
            testerUser.setPwd(pwd);

            User user = new User();
            String token = UUID.randomUUID().toString();//一个3000年内不会重复的唯一标识符
            user.setToken(token);
            user.setName(testerUser.getName());
            user.setAccountId(String.valueOf(testerUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl("");
            userMapper.insert(user);
            //登录成功，写入session和cookie
            request.getSession().setAttribute("user",testerUser);

            response.addCookie(new Cookie("token",token));
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
