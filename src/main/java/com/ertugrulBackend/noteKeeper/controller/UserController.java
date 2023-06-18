package com.ertugrulBackend.noteKeeper.controller;

import com.ertugrulBackend.noteKeeper.model.User;
import com.ertugrulBackend.noteKeeper.service.NoteService;
import com.ertugrulBackend.noteKeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {

        //get user from the service
        User user = userService.getUserById(id);

        //set user as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update_user";

    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") long id) {

        //call delete user method
        this.userService.deleteUserById(id);
        return "redirect:/";

    }


}
