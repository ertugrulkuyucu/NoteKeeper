package com.ertugrulBackend.noteKeeper.controller;

import com.ertugrulBackend.noteKeeper.configrations.RedisConfiguration;
import com.ertugrulBackend.noteKeeper.model.User;
import com.ertugrulBackend.noteKeeper.service.NoteService;
import com.ertugrulBackend.noteKeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;

    private long lastClear = 0;


    @GetMapping("/")
    public String viewHomePage(Model model) throws InterruptedException {

        var time = System.currentTimeMillis();
        if (time - lastClear > 10000) {
            lastClear = time;
            userService.clearCache();
        }

        model.addAttribute("listUsers", userService.getAllUsers());
        return "index";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }


    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {

        User user = userService.getUserById(id);

        model.addAttribute("user", user);
        return "update_user";

    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") long id) {

        this.userService.deleteUserById(id);
        return "redirect:/";

    }


}
