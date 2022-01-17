package ar.edu.unnoba.poo2021.Fiscalia.controller;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import ar.edu.unnoba.poo2021.Fiscalia.service.CausaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "redirect:/causas/view/"+causa.getId();
    }
    @GetMapping("/listaCausas")
    public String getCausas(Model model,
                           @ModelAttribute("error") String errorMessage){
        if(errorMessage!=null){
            model.addAttribute("error",errorMessage);
        }
        model.addAttribute("causas",causaService.causasPorFecha());

        return "causas/listaCausas";
    }
    @GetMapping("/view/{id}")
    public String causaView(@PathVariable("id") Long causaId, Model model){
        Causa causa = causaService.getCausa(causaId);
        model.addAttribute("causa",causa);
        return "causas/view";
    }
    @GetMapping("/edit/{id}")
    public String causaEdit(@PathVariable("id") Long causaId, Model model){
        Causa causa = causaService.getCausa(causaId);
        model.addAttribute("causa",causa);
        return "causas/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Causa causa){
        causaService.update(causa);

        return "redirect:/causas/cleanView/"+causa.getId();
    }

    @GetMapping("/cleanView/{id}")
    public String causaCleanView(@PathVariable("id") Long causaId, Model model){
        Causa causa = causaService.getCausa(causaId);
        model.addAttribute("causa",causa);
        return "causas/cleanView";
    }
}
