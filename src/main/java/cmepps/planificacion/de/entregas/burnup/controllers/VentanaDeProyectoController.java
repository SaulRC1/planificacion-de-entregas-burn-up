package cmepps.planificacion.de.entregas.burnup.controllers;

import cmepps.planificacion.de.entregas.burnup.models.HistoriaDeUsuario;
import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import cmepps.planificacion.de.entregas.burnup.persistence.services.HistoriaDeUsuarioService;
import cmepps.planificacion.de.entregas.burnup.persistence.services.ProyectoService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.jboss.logging.Logger;
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
@RequestMapping("/ventana-de-proyecto")
public class VentanaDeProyectoController {

    @Autowired
    private ProyectoService proyectoService;
    
    @Autowired
    private HistoriaDeUsuarioService historiaService;
    
    @GetMapping(path = "/{nombreDeProyecto}")
    public String doGet(ModelMap model, @PathVariable String nombreDeProyecto, HttpSession session) {
        
        Proyecto proyecto = proyectoService.getProyectoByName(nombreDeProyecto);
        
        if(proyecto != null) {
            
            session.setAttribute("proyecto", proyecto);
            
            //Añadimos proyecto al JSP
            model.addAttribute("proyecto", proyecto);
            
            //Añadimos historias de usuario al JSP
            model.addAttribute("historiasDeUsuario", proyecto.getHistoriasDeUsuario());
        
            return "historia-2/tarea-1/ventana-de-proyecto";
            
        } else {
            
            model.addAttribute("errorNombre", nombreDeProyecto);
            
            return "historia-2/tarea-1/error-proyecto-inexistente";
            
        }
        
        
    }
    
}
