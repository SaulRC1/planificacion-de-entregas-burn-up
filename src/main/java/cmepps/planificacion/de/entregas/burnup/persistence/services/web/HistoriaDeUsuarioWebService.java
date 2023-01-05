
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
@RequestMapping(path = "/historia-service")
public class HistoriaDeUsuarioWebService {
    
    @Autowired
    private HistoriaDeUsuarioService historiaService;
    
    @Autowired
    private ProyectoService proyectoService;
    
    @Autowired
    private TareaService tareaService;
    
    @GetMapping(path = "/{idHistoria}")
    @ResponseBody
    public HistoriaDeUsuario getHistoriaDeUsuario(@PathVariable long idHistoria) {
        
        Optional<HistoriaDeUsuario> historia = historiaService.getHistoriaById(idHistoria);
                
        return historia.get();
    }
    
    @GetMapping(path = "/name/{nombreHistoria}")
    @ResponseBody
    public HistoriaDeUsuario getHistoriaDeUsuarioByName(@PathVariable String nombreHistoria) {
        
        HistoriaDeUsuario historia = historiaService.getHistoriaByName(nombreHistoria);
                
        return historia;
    }
    
    @PostMapping(path = "/update")
    public RedirectView updateHistoria(HttpServletRequest request) {
        
        long idHistoria = Long.parseLong(request.getParameter("select-edit"));
        
        Optional<HistoriaDeUsuario> historia = historiaService.getHistoriaById(idHistoria);
        
        String usuarioHistoria = request.getParameter("usuario-historia-edit");        
        String nombreHistoria = request.getParameter("nombre-historia-edit");        
        int valorHistoria = Integer.parseInt(request.getParameter("valor-historia-edit"));        
        String descripcionHistoria = request.getParameter("descripcion-edit");
        
        historia.get().setUsuario(usuarioHistoria);
        historia.get().setNombreDeHistoria(nombreHistoria);
        historia.get().setValorAportado(valorHistoria);
        historia.get().setDescripcion(descripcionHistoria);
        
        historiaService.updateHistoriaDeUsuario(historia.get());
        
        return new RedirectView(request.getContextPath() + "/ventana-de-proyecto/" + historia.get().getProyecto().getNombreDeProyecto());
    }
    
    @PostMapping(path = "/save")
    public RedirectView saveHistoria(@RequestParam(name = "usuario-historia") String usuarioHistoria,
                                     @RequestParam(name = "nombre-historia") String nombreHistoria,
                                     @RequestParam(name = "valor-historia") int valorAportado,
                                     @RequestParam(name = "descripcion") String descripcion,
                                     @RequestParam(name = "id-proyecto") int idProyecto,
                                     HttpServletRequest request) {
        
        Proyecto proyecto = proyectoService.getProyectoById(idProyecto).get();
        
        HistoriaDeUsuario historia = new HistoriaDeUsuario();
        
        historia.setUsuario(usuarioHistoria);
        historia.setNombreDeHistoria(nombreHistoria);
        historia.setValorAportado(valorAportado);
        historia.setDescripcion(descripcion);
        
        historia.setProyecto(proyecto);
        
        historiaService.saveHistoriaDeUsuario(historia);
        
        return new RedirectView(request.getContextPath() + "/ventana-de-proyecto/" + historia.getProyecto().getNombreDeProyecto());
    }
    
    @PostMapping(path = "/delete")
    public RedirectView deleteHistoria(HttpServletRequest request, @RequestParam(name = "select-historia-delete") long idHistoria){
        
        HistoriaDeUsuario historia = historiaService.getHistoriaById(idHistoria).get();
        
        if(historia != null) {
            
            String nombreDeProyecto = historia.getProyecto().getNombreDeProyecto();
            
            //Antes de eliminar una historia, se eliminan todas sus tareas
            List<Tarea> listaDeTareas = historia.getListaDeTareas();
            
            if(listaDeTareas.size() > 0) {
                
                for (Tarea tarea : listaDeTareas) {
                    
                    tareaService.deleteTarea(tarea);
                }
            }
            
            historiaService.deleteHistoriaDeUsuario(historia);
            
            return new RedirectView(request.getContextPath() + "/ventana-de-proyecto/" + nombreDeProyecto);
        }
        
        return null;
    }

}
