/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cmepps.planificacion.de.entregas.burnup.persistence.services;

import cmepps.planificacion.de.entregas.burnup.models.Tarea;
import cmepps.planificacion.de.entregas.burnup.persistence.TareaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saúl Rodríguez Naranjo e Ismael Da Palma Fernández
 */
@Service
public class TareaServiceImpl implements TareaService {
    
    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public Optional<Tarea> getTareaById(long id) {
        return tareaRepository.findById(id);
    }

    @Override
    public void saveTarea(Tarea tarea) {
        tareaRepository.save(tarea);
    }

    @Override
    public void updateTarea(Tarea tarea) {
        tareaRepository.save(tarea);
    }

    @Override
    public void deleteTarea(Tarea tarea) {
        tareaRepository.delete(tarea);
    }

    @Override
    public Tarea getTareaByName(String nombreTarea) {
        return tareaRepository.findByNombreDeTarea(nombreTarea);
    }
    
    

}
