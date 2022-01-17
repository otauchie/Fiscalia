package ar.edu.unnoba.poo2021.Fiscalia.controller;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.model.LlamadaTelefonica;
import ar.edu.unnoba.poo2021.Fiscalia.service.CausaService;
import ar.edu.unnoba.poo2021.Fiscalia.service.LlamadaTelefonicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/llamadas")
public class LlamadaTelefonicaController {
    @Autowired
    private LlamadaTelefonicaService llamadaTelefonicaService;
    @Autowired
    private CausaService causaService;

    @GetMapping("/newLlamada/{id}")
    public String LlamadaTelefonicaNew( Model model){
        model.addAttribute("llamadaTelefonica",new LlamadaTelefonica());
        return "llamadas/newLlamada";
    }

    @PostMapping
    public String create(@ModelAttribute LlamadaTelefonica llamadaTelefonica){
      llamadaTelefonicaService.create(llamadaTelefonica);
        return "redirect:/causas/view/"+llamadaTelefonica.getCausa().getId();
    }

}
