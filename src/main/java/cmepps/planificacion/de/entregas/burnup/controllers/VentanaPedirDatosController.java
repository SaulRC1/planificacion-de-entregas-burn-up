package cmepps.planificacion.de.entregas.burnup.controllers;

import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import cmepps.planificacion.de.entregas.burnup.persistence.services.ProyectoService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gonzalo Casquete Rodríguez
 */
@Controller
@RequestMapping("/ventana-pedir-datos")
public class VentanaPedirDatosController {

	@Autowired
	private ProyectoService proyectoServicio;
	
	
    @GetMapping
    public String doGet(ModelMap model) {
        
        return "historia-1/tarea-1/ventana-introducir-datos";
    } 
    
    @PostMapping
    public String doPost(HttpServletRequest request) {
    	String nombre=request.getParameter("nombre");
    	int duracionSprint=Integer.parseInt(request.getParameter("duracion"));
    	int velocidad=Integer.parseInt(request.getParameter("velocidad"));
    	
    	System.out.println("Nombre: "+nombre);
    	System.out.println("Duracion Sprint: "+duracionSprint);
    	System.out.println("Velocidad del equipo: "+velocidad);
    	
    	Proyecto proyecto=new Proyecto();
    	proyecto.setNombreDeProyecto(nombre);
    	proyecto.setDuracionDelSprint(duracionSprint);
    	proyecto.setVelocidadDelEquipo(velocidad);
    	
    	proyectoServicio.saveProyecto(proyecto);
    	return "redirect:/"+request.getContextPath()+"ventana-de-proyecto/"+nombre;
    }
}
