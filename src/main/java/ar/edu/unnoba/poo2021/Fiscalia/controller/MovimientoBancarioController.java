package ar.edu.unnoba.poo2021.Fiscalia.controller;

import ar.edu.unnoba.poo2021.Fiscalia.model.Causa;
import ar.edu.unnoba.poo2021.Fiscalia.model.MovimientoBancario;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import ar.edu.unnoba.poo2021.Fiscalia.service.CausaService;
import ar.edu.unnoba.poo2021.Fiscalia.service.MovimientoBancarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movimientosBancarios")
public class MovimientoBancarioController {
    @Autowired
    private MovimientoBancarioService movimientoBancarioService;
    @Autowired
    private CausaService causaService;



    @GetMapping("/newMovimientoBancario/{id}")
    public String newMovimiento(@PathVariable("id")Long id, Model model){
        Causa causa=causaService.getCausa(id);
        MovimientoBancario movimientoBancario= new MovimientoBancario();
        movimientoBancario.setCausa(causa);
        model.addAttribute("movimiento",movimientoBancario);
        return "movimientosBancarios/newMovimientoBancario";
    }

    @PostMapping
    public String create(@ModelAttribute MovimientoBancario movimientoBancario){
        movimientoBancarioService.create(movimientoBancario);
        return "redirect:/causas/view/"+movimientoBancario.getCausa().getId();
    }

    @GetMapping("/delete/{id}")
    public String movimientoDelete(@PathVariable("id") Long id){
        Long idMovimiento=movimientoBancarioService.getMovimientoBancario(id).getCausa().getId();
        movimientoBancarioService.delete(id);
        return "redirect:/causas/view/"+idMovimiento;
    }
}
