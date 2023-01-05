
package cmepps.planificacion.de.entregas.burnup.persistence.services.web;

import cmepps.planificacion.de.entregas.burnup.models.HistoriaDeUsuario;
import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import cmepps.planificacion.de.entregas.burnup.models.Tarea;
import cmepps.planificacion.de.entregas.burnup.persistence.services.HistoriaDeUsuarioService;
import cmepps.planificacion.de.entregas.burnup.persistence.services.ProyectoService;
import cmepps.planificacion.de.entregas.burnup.persistence.services.TareaService;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Ismael Da Palma Fernández y Saúl Rodríguez Naranjo
 */
@Controller
@RequestMapping(path = "/tarea-service")
public class TareaWebService {
    
    @Autowired
    private TareaService tareaService;
    
    @Autowired
    private HistoriaDeUsuarioService historiaService;
    
    @GetMapping(path = "/{idTarea}")
    @ResponseBody
    public Tarea getTarea(@PathVariable long idTarea) {
        
        Optional<Tarea> tarea = tareaService.getTareaById(idTarea);
                
        return tarea.get();
    }
    
    @GetMapping(path = "/name/{nombreTarea}")
    @ResponseBody
    public Tarea getTareaByName(@PathVariable String nombreTarea) {
        
        Tarea tarea = tareaService.getTareaByName(nombreTarea);
                
        return tarea;
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
    
    @PostMapping(path = "/save")
    public RedirectView saveTarea(@RequestParam(name = "select-add-tarea") String nombreHistoria,
                                     @RequestParam(name = "nombre-add-tarea") String nombreTarea,
                                     @RequestParam(name = "prioridad-add-tarea") int prioridadTarea,
                                     @RequestParam(name = "esfuerzo-add-tarea") int esfuerzoTarea,
                                     @RequestParam(name = "descripcion-add-tarea") String descripcionTarea,
                                     @RequestParam(name = "id-historia-add-tarea") long id,
                                     HttpServletRequest request) {
        
        Optional<HistoriaDeUsuario> historia = historiaService.getHistoriaById(id);
        
        Tarea tarea = new Tarea();
        
        tarea.setHistoria(historia.get());
        
        tarea.setNombreDeTarea(nombreTarea);
        tarea.setPrioridad(prioridadTarea);
        tarea.setEsfuerzo(esfuerzoTarea);
        tarea.setDescripcion(descripcionTarea);
        
        tareaService.saveTarea(tarea);
        
        return new RedirectView(request.getContextPath() + "/ventana-de-proyecto/" + tarea.getHistoria().getProyecto().getNombreDeProyecto());
    }
    
    @PostMapping(path = "/delete")
    public RedirectView deleteTarea(HttpServletRequest request, @RequestParam(name = "select-tarea-delete") long idTarea){
        
        Tarea tarea = tareaService.getTareaById(idTarea).get();
        
        if(tarea != null) {
            
            String nombreDeProyecto = tarea.getHistoria().getProyecto().getNombreDeProyecto();
            
            tareaService.deleteTarea(tarea);
            
            return new RedirectView(request.getContextPath() + "/ventana-de-proyecto/" + nombreDeProyecto);
        }
        return null;
    }

}
