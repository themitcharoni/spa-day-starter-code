package org.launchcode.spaday.controllers;


import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private static List<User> users = new ArrayList<>();

    @RequestMapping("add")
    public String displayAddUserForm() {
        return"user/add";
    }
    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if(!verify.equals(user.getPassword())){
            return "redirect:user/add";
        }else {
            users.add(user);
            model.addAttribute("user", user);
            model.addAttribute("username", username);
            return "user/index";
        }
    }

}
