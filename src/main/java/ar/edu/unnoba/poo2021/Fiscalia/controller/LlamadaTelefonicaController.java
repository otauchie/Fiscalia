package ar.edu.unnoba.poo2021.Fiscalia.controller;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.model.LlamadaTelefonica;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import ar.edu.unnoba.poo2021.Fiscalia.service.CausaService;
import ar.edu.unnoba.poo2021.Fiscalia.service.LlamadaTelefonicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/llamadas")
public class LlamadaTelefonicaController {
    @Autowired
    private LlamadaTelefonicaService llamadaTelefonicaService;
    @Autowired
    private CausaService causaService;



    @GetMapping("/newLlamada/{id}")
    public String LlamadaTelefonicaNew( @PathVariable("id") Long id, Model model){
        Causa causa=causaService.getCausa(id);
        LlamadaTelefonica llamadaTelefonica= new LlamadaTelefonica();
        llamadaTelefonica.setCausa(causa);
        model.addAttribute("llamadaTelefonica",llamadaTelefonica);
        model.addAttribute("causa",causa);

        return "llamadas/newLlamada";
    }

    @PostMapping
    public String create(@ModelAttribute("llamadaTelefonica") LlamadaTelefonica llamadaTelefonica){

      llamadaTelefonicaService.create(llamadaTelefonica);
        return "redirect:/causas/view/"+llamadaTelefonica.getCausa().getId();
    }


    @GetMapping("/delete/{id}")
    public String llamadaDelete(@PathVariable("id") Long id){
            Long idDireccion=llamadaTelefonicaService.getLlamadaTelefonica(id).getCausa().getId();
            llamadaTelefonicaService.delete(id);
        return "redirect:/causas/view/"+idDireccion;
    }


}
