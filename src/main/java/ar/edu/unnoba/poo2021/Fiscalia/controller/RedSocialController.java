package ar.edu.unnoba.poo2021.Fiscalia.controller;

import ar.edu.unnoba.poo2021.Fiscalia.model.RedSocial;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import ar.edu.unnoba.poo2021.Fiscalia.service.CausaService;
import ar.edu.unnoba.poo2021.Fiscalia.service.RedSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("redesSociales")
public class RedSocialController {
    @Autowired
    private RedSocialService redSocialService;
    @Autowired
    private CausaService causaService;

    private Long causaID;

    public Long getCausaID() {
        return causaID;
    }

    public void setCausaID(Long causaID) {
        this.causaID = causaID;
    }

    @GetMapping("/newRedSocial/{id}")
    public String newRedSocial(@PathVariable("id") Long id, Model model){
        setCausaID(id);
        model.addAttribute("redSocial",new RedSocial());
        return "redesSociales/newRedSocial";
    }

    @PostMapping
    public String create(@ModelAttribute RedSocial redSocial){
        redSocial.setCausa(causaService.getCausa(causaID));
        redSocialService.create(redSocial);
        return "redirect:/causas/view/"+redSocial.getCausa().getId();
    }
    @GetMapping("/delete/{id}")
    public String redSocialDelete(@PathVariable("id") Long id){
        Long idDireccion=redSocialService.getRedSocial(id).getCausa().getId();
        redSocialService.delete(id);
        return "redirect:/causas/view/"+idDireccion;
    }
}
