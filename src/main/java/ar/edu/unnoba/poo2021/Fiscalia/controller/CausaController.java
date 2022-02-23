package ar.edu.unnoba.poo2021.Fiscalia.controller;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import ar.edu.unnoba.poo2021.Fiscalia.service.CausaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public String create(@Valid @ModelAttribute("causa") Causa causa, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("causa",causa);
            return "causas/newCausa";
        }
        try {
            causaService.create(causa);
        }catch(Exception e){
            System.out.println(e.getMessage());
            model.addAttribute("formError", e.getMessage());
            model.addAttribute("causa", causa);
            return "causas/newCausa";
        }

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

        return "redirect:/causas/view/"+causa.getId();
    }

    @GetMapping("/buscarCausas")
    public String buscarCausas (Causa causa,Model model, String keyword,@ModelAttribute("error") String errorMessage) {
        if (keyword != null ) {
            List<Causa> causas = causaService.buscarEnCausas(keyword);

            model.addAttribute("causas", causas);
        }
        if(errorMessage!=null){
            model.addAttribute("error",errorMessage);
        }

        return "causas/listaCausas";
    }

}
