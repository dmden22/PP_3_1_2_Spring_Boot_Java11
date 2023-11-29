package ru.maslovd.pp_3_1_2_Spring_Boot_Java11.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maslovd.pp_3_1_2_Spring_Boot_Java11.model.User;
import ru.maslovd.pp_3_1_2_Spring_Boot_Java11.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printUsers(ModelMap model) {
        model.addAttribute("allUsers", userService.getUsersList());
        return "index";
    }

    @GetMapping(value = "/add-user")
    public String addUser() {
        return "add-user";
    }

    @PostMapping("add-user-success-page")
    public String addUser(@RequestParam(name = "name") String name,
                          @RequestParam(name = "lastName") String lastName,
                          @RequestParam(name = "email") String email) {
        userService.addUser(new User(name, lastName, email));
        return "redirect:/";
    }

    @GetMapping("delete-user-by-ID")
    public String removeUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/update-user")
    public String userById(@RequestParam(name = "id") long id,
                           @RequestParam(name = "name") String name,
                           @RequestParam(name = "lastName") String lastName,
                           @RequestParam(name = "email") String email,
                           ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", email);
        return "update-user";
    }

    @PostMapping("update-user-by-id")
    public String updateUser(@RequestParam(name = "id") long id,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "lastName") String lastName,
                             @RequestParam(name = "email") String email) {
        userService.updateUser(id, name, lastName, email);
        return "redirect:/";
    }
}
