package ar.edu.unnoba.poo2021.Fiscalia.controller;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.service.CausaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/causas")
public class CausaController {
    @Autowired
    private CausaService causaService;

    @GetMapping("/newCausa")
    public String causaNew(Model model){
        model.addAttribute("causa",new Causa());
        return "causas/newCausa";
    }
    @PostMapping
    public String create(@ModelAttribute Causa causa){
        causaService.create(causa);
        return "redirect:/causas/newCausa";
    }
}
