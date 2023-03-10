package cmepps.planificacion.de.entregas.burnup.controllers;

import cmepps.planificacion.de.entregas.burnup.models.Planificacion;
import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import cmepps.planificacion.de.entregas.burnup.persistence.services.ProyectoService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gonzalo Casquete Rodríguez
 */
@Controller
@RequestMapping("/planificacion")
public class VentanaPlanificacionController {
    
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/{nombreDeProyecto}")
    public String doGet(ModelMap model, @PathVariable String nombreDeProyecto, HttpSession session) {
        
        Proyecto proyecto = proyectoService.getProyectoByName(nombreDeProyecto);
        
        Planificacion proyectoPlanificado = proyecto.planificarProyecto();
        
        model.addAttribute("proyectoPlanificado", proyectoPlanificado);
        
        return "historia-5/tarea-1/ventana-planificacion-burn-up";
    }
    
}
