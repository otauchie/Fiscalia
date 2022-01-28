package ar.edu.unnoba.poo2021.Fiscalia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String Index(){
        return "redirect:causas/listaCausas";
    }
}
