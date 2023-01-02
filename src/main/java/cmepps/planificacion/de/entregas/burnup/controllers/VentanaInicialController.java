package cmepps.planificacion.de.entregas.burnup.controllers;

import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import cmepps.planificacion.de.entregas.burnup.persistence.services.ProyectoService;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gonzalo Casquete Rodríguez
 */
@Controller
@RequestMapping("/")
public class VentanaInicialController {
	
	@Autowired
    private ProyectoService proyectoService;
	
    @GetMapping
    public String doGet(ModelMap model) {
        List<Proyecto> listaProyectos=proyectoService.findAll(); 
    	model.addAttribute("listaDeProyectos", listaProyectos);
    	
    	for(int i=0;i<listaProyectos.size();i++){
    		System.out.println("Nombre "+i+1+":"+listaProyectos.get(i).getNombreDeProyecto());
    	}
 
        return "historia-1/tarea-1/ventana-inicial";
    }
    
}
