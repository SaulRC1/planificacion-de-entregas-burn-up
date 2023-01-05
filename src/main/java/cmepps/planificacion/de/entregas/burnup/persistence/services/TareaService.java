/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cmepps.planificacion.de.entregas.burnup.persistence.services;

import cmepps.planificacion.de.entregas.burnup.models.Tarea;
import java.util.Optional;

/**
 *
 * @author SaulWorkStation, IsmaelWorkStation
 */
public interface TareaService {
    public Optional<Tarea> getTareaById(long id);
    
    public Tarea getTareaByName(String nombreTarea);
    
    public void saveTarea(Tarea tarea);
    
    public void updateTarea(Tarea tarea);
    
    public void deleteTarea(Tarea tarea);
}
