package cmepps.planificacion.de.entregas.burnup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Este controlador se encarga de administrar la vista para añadir historias de
 * usuario.
 * 
 * @author Saul Rodriguez Naranjo
 */
@Controller
@RequestMapping(path = "/add-historia-usuario")
public class AddHistoriaDeUsuarioController {
    
    @GetMapping
    public String doGet(ModelMap model) {
        
        
        
        return "historia-3/tarea-1/add-historia-de-usuario";
    }
}
