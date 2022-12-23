package cmepps.planificacion.de.entregas.burnup.controllers;

import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ismael Da Palma Fernández
 */
@Controller
@RequestMapping("/ventana-de-tarea")
public class VentanaDeTarea {

    @GetMapping
    public String doGet(ModelMap model) {
        
        return "historia-4/tarea-1-3/ventana-tarea";
    }
    
}
