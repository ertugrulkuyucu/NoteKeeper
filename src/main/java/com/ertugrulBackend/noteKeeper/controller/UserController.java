package com.ertugrulBackend.noteKeeper.controller;

import com.ertugrulBackend.noteKeeper.model.User;
import com.ertugrulBackend.noteKeeper.service.NoteService;
import com.ertugrulBackend.noteKeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;


    //displat list of users
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listUsers", userService.getAllUsers());
        return "index";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        //save user to database
        userService.saveUser(user);
        return "redirect:/";
    }


    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model){
        //create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }


}
