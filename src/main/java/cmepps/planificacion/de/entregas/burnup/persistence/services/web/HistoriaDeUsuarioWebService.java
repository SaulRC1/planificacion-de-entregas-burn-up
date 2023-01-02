
package cmepps.planificacion.de.entregas.burnup.persistence.services.web;

import cmepps.planificacion.de.entregas.burnup.models.HistoriaDeUsuario;
import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import cmepps.planificacion.de.entregas.burnup.persistence.services.HistoriaDeUsuarioService;
import cmepps.planificacion.de.entregas.burnup.persistence.services.ProyectoService;
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
@RequestMapping(path = "/historia-service")
public class HistoriaDeUsuarioWebService {
    
    @Autowired
    private HistoriaDeUsuarioService historiaService;
    
    @GetMapping(path = "/{idHistoria}")
    @ResponseBody
    public HistoriaDeUsuario getHistoriaDeUsuario(@PathVariable long idHistoria) {
        
        Optional<HistoriaDeUsuario> historia = historiaService.getHistoriaById(idHistoria);
                
        return historia.get();
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
    
    /*@DeleteMapping(path = "/delete")
    public  RedirectView deleteHistoria(HttpServletRequest request){
        
    }*/

}
