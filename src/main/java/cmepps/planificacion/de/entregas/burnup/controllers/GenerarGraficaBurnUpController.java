/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cmepps.planificacion.de.entregas.burnup.controllers;

import cmepps.planificacion.de.entregas.burnup.models.HistoriaDeUsuario;
import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import cmepps.planificacion.de.entregas.burnup.models.Tarea;
import cmepps.planificacion.de.entregas.burnup.persistence.services.ProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Saúl Rodríguez Naranjo
 */
@Controller
@RequestMapping("/grafica-burn-up")
public class GenerarGraficaBurnUpController {
    
    @Autowired
    private ProyectoService proyectoService;
    
    @GetMapping("/{nombreDeProyecto}")
    public String doGet(ModelMap model, @PathVariable String nombreDeProyecto) {
        
        Proyecto proyecto = proyectoService.getProyectoByName(nombreDeProyecto);
        
        if(proyecto != null) {
            
            model.addAttribute("proyecto", proyecto);
            model.addAttribute("velocidadEquipo", proyecto.getVelocidadDelEquipo());
            
            int esfuerzoTotalProyecto = calcularEsfuerzoTotalProyecto(proyecto);
            
            
        } else {
            
            model.addAttribute("errorNombre", nombreDeProyecto);
            
            return "historia-2/tarea-1/error-proyecto-inexistente";
            
        }
        
        return "historia-6/ventana-grafica-burn-up";
    }
    

    private int calcularEsfuerzoTotalProyecto(Proyecto proyecto) {
        
        List<HistoriaDeUsuario> historiasDeUsuario = proyecto.getHistoriasDeUsuario();
        
        int esfuerzoTotal = 0;
        
        for (HistoriaDeUsuario historia : historiasDeUsuario) {
            
            List<Tarea> tareas = historia.getListaDeTareas();
            
            for (Tarea tarea : tareas) {
                esfuerzoTotal += tarea.getEsfuerzo();
            }
        }
        
        return esfuerzoTotal;
    }
}
