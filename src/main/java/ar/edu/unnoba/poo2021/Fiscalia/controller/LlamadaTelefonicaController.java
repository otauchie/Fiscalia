package ar.edu.unnoba.poo2021.Fiscalia.controller;

import ar.edu.unnoba.poo2021.Fiscalia.model.LlamadaTelefonica;
import ar.edu.unnoba.poo2021.Fiscalia.service.LlamadaTelefonicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/llamadas")
public class LlamadaTelefonicaController {
    @Autowired
    private LlamadaTelefonicaService llamadaTelefonicaService;

    @GetMapping("/newLlamada")
    public String LlamadaTelefonicaNew(Model model){
        model.addAttribute("llamadaTelefonica",new LlamadaTelefonica());
        return "llamadas/newLlamada";
    }

    @PostMapping
    public String create(@ModelAttribute LlamadaTelefonica llamadaTelefonica){
      llamadaTelefonicaService.create(llamadaTelefonica);
        return "redirect:/llamadas/newLlamada";
    }

}
