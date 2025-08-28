package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/get")
    public String getUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping("/add")
    public String saveUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/get";
    }

    @RequestMapping("/update")
    public String updateUser(Model model, @RequestParam("userId") long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("userId") long id) {
        userService.deleteUser(id);
        return "redirect:/get";
    }

}
