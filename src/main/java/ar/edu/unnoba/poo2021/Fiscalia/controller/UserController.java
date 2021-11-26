package ar.edu.unnoba.poo2021.Fiscalia.controller;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import ar.edu.unnoba.poo2021.Fiscalia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/newUser")
    public String userNew(Model model){
        model.addAttribute("user",new User());
        return "users/newUser";
    }

    @PostMapping
    public String create(@ModelAttribute User user){
        userService.create(user);
        return "redirect:/users/newUser";
    }
}