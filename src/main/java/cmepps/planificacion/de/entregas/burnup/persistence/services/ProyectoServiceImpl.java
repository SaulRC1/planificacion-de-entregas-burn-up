package cmepps.planificacion.de.entregas.burnup.persistence.services;

import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import cmepps.planificacion.de.entregas.burnup.persistence.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saúl Rodríguez Naranjo
 */
@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;
    
    @Override
    public Optional<Proyecto> getProyectoById(long id) {
        return proyectoRepository.findById(id);
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public void updateProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public void deleteProyecto(Proyecto proyecto) {
        proyectoRepository.delete(proyecto);
    }

    @Override
    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    @Override
    public Proyecto getProyectoByName(String nombreDeProyecto) {
        return proyectoRepository.findByNombreDeProyecto(nombreDeProyecto);
    }

}
