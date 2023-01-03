
package cmepps.planificacion.de.entregas.burnup.persistence.services.web;

import cmepps.planificacion.de.entregas.burnup.models.HistoriaDeUsuario;
import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import cmepps.planificacion.de.entregas.burnup.models.Tarea;
import cmepps.planificacion.de.entregas.burnup.persistence.services.HistoriaDeUsuarioService;
import cmepps.planificacion.de.entregas.burnup.persistence.services.ProyectoService;
import cmepps.planificacion.de.entregas.burnup.persistence.services.TareaService;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Ismael Da Palma Fernández
 */
@Controller
@RequestMapping(path = "/tarea-service")
public class TareaWebService {
    
    @Autowired
    private TareaService tareaService;
    
    @GetMapping(path = "/{idTarea}")
    @ResponseBody
    public Tarea getTarea(@PathVariable long idTarea) {
        
        Optional<Tarea> tarea = tareaService.getTareaById(idTarea);
                
        return tarea.get();
    }
    
    @PostMapping(path = "/update")
    public RedirectView updateTarea(HttpServletRequest request) {
        
        long idTarea = Long.parseLong(request.getParameter("select-tarea-edit"));
        
        Optional<Tarea> tarea = tareaService.getTareaById(idTarea);
        
        String nombreTarea = request.getParameter("nombre-tarea-edit");        
        int prioridadTarea = Integer.parseInt(request.getParameter("prioridad-tarea-edit"));        
        int esfuerzoTarea = Integer.parseInt(request.getParameter("esfuerzo-tarea-edit"));        
        String descripcionTarea = request.getParameter("descripcion-tarea-edit");
        
        tarea.get().setNombreDeTarea(nombreTarea);
        tarea.get().setPrioridad(prioridadTarea);
        tarea.get().setEsfuerzo(esfuerzoTarea);
        tarea.get().setDescripcion(descripcionTarea);
        
        tareaService.updateTarea(tarea.get());
        
        return new RedirectView(request.getContextPath() + "/ventana-de-proyecto/" + tarea.get().getHistoria().getProyecto().getNombreDeProyecto());
    }
    
    /*@DeleteMapping(path = "/delete")
    public  RedirectView deleteTarea(HttpServletRequest request){
        long idTarea = Long.parseLong(request.getParameter("select-tarea-delete"));
        
        Optional<Tarea> tarea = tareaService.getTareaById(idTarea);
       
        tareaService.deleteTarea(tarea.get());
        
        return new RedirectView(request.getContextPath() + "/ventana-de-proyecto/" + tarea.get().getHistoria().getProyecto().getNombreDeProyecto());
    }*/

}
