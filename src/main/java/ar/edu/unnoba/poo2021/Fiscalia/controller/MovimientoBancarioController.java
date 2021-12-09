package ar.edu.unnoba.poo2021.Fiscalia.controller;

import ar.edu.unnoba.poo2021.Fiscalia.model.MovimientoBancario;
import ar.edu.unnoba.poo2021.Fiscalia.model.User;
import ar.edu.unnoba.poo2021.Fiscalia.service.MovimientoBancarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movimientosBancarios")
public class MovimientoBancarioController {
    @Autowired
    private MovimientoBancarioService movimientoBancarioService;

    @GetMapping("/newMovimientoBancario")
    public String newMovimiento(Model model){
        model.addAttribute("movimiento",new MovimientoBancario());
        return "movimientosBancarios/newMovimientoBancario";
    }

    @PostMapping
    public String create(@ModelAttribute MovimientoBancario movimientoBancario){
        movimientoBancarioService.create(movimientoBancario);
        return "redirect:/movimientosBancarios/newMovimientoBancario";
    }
}
