package cmepps.planificacion.de.entregas.burnup.controllers;

import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gonzalo Casquete Rodríguez
 */
@Controller
@RequestMapping("/ventana-pedir-datos")
public class VentanaPedirDatosController {

    @GetMapping
    public String doGet(ModelMap model) {
        
        Proyecto proyecto = new Proyecto();
        
        proyecto.setNombreDeProyecto("Mi Primer Proyecto");
        
        model.addAttribute("proyecto", proyecto);
        
        return "historia-1/tarea-2/ventana-introducir-datos";
    }
    
}
