package cmepps.planificacion.de.entregas.burnup.persistence.services;

import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author SaulWorkStation
 */
public interface ProyectoService {
    
    public Optional<Proyecto> getProyectoById(long id);
    
    public Proyecto getProyectoByName(String nombreDeProyecto);
    
    public List<Proyecto> findAll();
    
    public void saveProyecto(Proyecto proyecto);
    
    public void updateProyecto(Proyecto proyecto);
    
    public void deleteProyecto(Proyecto proyecto);
    
}
