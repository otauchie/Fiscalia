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

    private Long causaID;

    @GetMapping("/newLlamada/{id}")
    public String LlamadaTelefonicaNew( @PathVariable("id") Long id, Model model, Model modelCausa){
        setCausaID(id);
        Causa causa=causaService.getCausa(id);
        model.addAttribute("llamadaTelefonica",new LlamadaTelefonica());
        modelCausa.addAttribute("causa",causa);
        return "llamadas/newLlamada";
    }

    @PostMapping
    public String create(@ModelAttribute LlamadaTelefonica llamadaTelefonica){
        llamadaTelefonica.setCausa(causaService.getCausa(causaID));
      llamadaTelefonicaService.create(llamadaTelefonica);
        return "redirect:/causas/view/"+llamadaTelefonica.getCausa().getId();
    }
/*
    @PostMapping("/update")
    public String update(@ModelAttribute LlamadaTelefonica llamadaTelefonica){
        llamadaTelefonicaService.update(llamadaTelefonica);
        return "redirect:/causas/view/"+llamadaTelefonica.getCausa().getId();
    }
    @GetMapping("/edit/{id}")
    public String llamadaEdit(@PathVariable("id") Long llamadaId, Model model){
        LlamadaTelefonica llamadaTelefonica = llamadaTelefonicaService.getLlamadaTelefonica(llamadaId);
        model.addAttribute("llamada",llamadaTelefonica);
        return "llamadas/edit";
    }
    */

    @GetMapping("/delete/{id}")
    public String llamadaDelete(@PathVariable("id") Long id){
            Long idDireccion=llamadaTelefonicaService.getLlamadaTelefonica(id).getCausa().getId();
            llamadaTelefonicaService.delete(id);
        return "redirect:/causas/view/"+idDireccion;
    }

    public Long getCausaID() {
        return causaID;
    }

    public void setCausaID(Long causaID) {
        this.causaID = causaID;
    }
}
