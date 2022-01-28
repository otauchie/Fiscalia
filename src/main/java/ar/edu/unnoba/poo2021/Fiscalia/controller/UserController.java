package ar.edu.unnoba.poo2021.Fiscalia.controller;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import ar.edu.unnoba.poo2021.Fiscalia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "redirect:/users/listaUsuarios";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute User user){
        userService.update(user);
        return "redirect:/users/listaUsuarios";
    }

    @GetMapping("/delete/{id}")
    public String userDelete(@PathVariable("id") Long userId,
                             Authentication authentication,
                             RedirectAttributes redirectAttributes){
        User userSession = (User)authentication.getPrincipal();
        try{
            userService.delete(userSession,userId);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }

        return "redirect:/users/listaUsuarios";
    }

    @GetMapping("/listaUsuarios")
    public String getUsers(Model model,
                           @ModelAttribute("error") String errorMessage){
        if(errorMessage!=null){
            model.addAttribute("error",errorMessage);
        }
        model.addAttribute("users",userService.getUsers());
        return "users/listaUsuarios";
    }

    @GetMapping("/edit/{id}")
    public String userEdit(@PathVariable("id") Long userId, Model model){
        User user = userService.getUser(userId);
        model.addAttribute("user",user);
        return "users/edit";
    }

    @GetMapping("/view/{id}")
    public String userView(@PathVariable("id") Long userId, Model model){
        User user = userService.getUser(userId);
        model.addAttribute("user",user);
        return "users/view";
    }
}