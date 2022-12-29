package cmepps.planificacion.de.entregas.burnup.controllers;

import cmepps.planificacion.de.entregas.burnup.models.HistoriaDeUsuario;
import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import cmepps.planificacion.de.entregas.burnup.persistence.services.HistoriaDeUsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ismael Da Palma Fernández
 */
@Controller
@RequestMapping("/ventana-de-historia")
public class VentanaDeHistoria {
    
    @Autowired
    private HistoriaDeUsuarioService historiaService;

    @GetMapping
    @ResponseBody
    public HistoriaDeUsuario doGet(HttpServletRequest request, HttpServletResponse response) {
        String nombreHistoria = request.getParameter("nombre_historia");
        
        return historiaService.getHistoriaByName(nombreHistoria);
    }
    
    @PostMapping
    public void doPost(HttpServletRequest request, HttpSession session) {
        
        String usuarioHistoria = request.getParameter("usuario-historia");
        
        String nombreHistoria = request.getParameter("nombre-historia");
        
        int valorAportado = Integer.parseInt(request.getParameter("valor-historia"));
        
        String descripcion = request.getParameter("descripcion");
        
        Proyecto proyecto = (Proyecto) session.getAttribute("proyecto");
        
        HistoriaDeUsuario historia = new HistoriaDeUsuario();
        
        historia.setDescripcion(descripcion);
        
        historia.setNombreDeHistoria(nombreHistoria);
        
        historia.setValorAportado(valorAportado);
        
        historia.setUsuario(usuarioHistoria);
        
        historia.setProyecto(proyecto);
        
        historiaService.saveHistoriaDeUsuario(historia);
        
    }
    
    
    
}
