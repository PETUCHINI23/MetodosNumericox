/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.CJMRA.MetodosNumericos.web;

import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.CJMRA.MetodosNumericos.service.UnidadIIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Administrador
 */
@Slf4j
@Controller
public class Unit2Controller {
    @Autowired
    private UnidadIIService bisectionservice;
   @GetMapping("unit2/formbisection")
    public String formBisecccion(Model model){
        Biseccion bisection =new Biseccion();
        
        model.addAttribute("bisection",bisection);
    return"unit2/bisection/formbisection";
    }
    
    
    @PostMapping("/unit2/solvebisection")
    public String solvebisection(Biseccion bisection,Model model){
      //  double valorFX=Funciones.Ecuacion(bisection.getFx(), bisection.getXl());
       //  log.info("Valor de Fx:"+valorFX);
var solveBisection=bisectionservice.AlgoritmoBiseccion(bisection);

log.info("Arreglo"+solveBisection);
       model.addAttribute("solveBisection",solveBisection);
       
    return "/unit2/bisection/solvebisection";
    }
}
