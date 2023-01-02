/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cmepps.planificacion.de.entregas.burnup.persistence.services.web;

import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import cmepps.planificacion.de.entregas.burnup.persistence.services.ProyectoService;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Saúl Rodríguez Naranjo
 */
@Controller
@RequestMapping(path = "/proyecto-service")
public class ProyectoWebService {
    
    @Autowired
    private ProyectoService proyectoService;
    
    @GetMapping(path = "/{nombreDeProyecto}")
    @ResponseBody
    public Proyecto getProyecto(@PathVariable String nombreDeProyecto) {
        
        Proyecto proyecto = proyectoService.getProyectoByName(nombreDeProyecto);
        
        /*if(proyecto == null) {
            
        }*/
                
        return proyecto;
    }
    
    @PostMapping(path = "/update")
    public RedirectView updateProyecto(HttpServletRequest request) {
        
        long idProyecto = Long.parseLong(request.getParameter("ajustes-id-proyecto-input"));
        
        Optional<Proyecto> proyecto = proyectoService.getProyectoById(idProyecto);
        
        String nombreDeProyecto = request.getParameter("ajustes-nombre-proyecto-input");
        int duracionSprint = Integer.parseInt(request.getParameter("ajustes-duracion-sprint-proyecto-input"));
        int velocidadEquipo = Integer.parseInt(request.getParameter("ajustes-velocidad-proyecto-input"));
        
        proyecto.get().setNombreDeProyecto(nombreDeProyecto);
        proyecto.get().setDuracionDelSprint(duracionSprint);
        proyecto.get().setVelocidadDelEquipo(velocidadEquipo);
        
        proyectoService.updateProyecto(proyecto.get());
        
        return new RedirectView(request.getContextPath() + "/ventana-de-proyecto/" + proyecto.get().getNombreDeProyecto());
    }

}
