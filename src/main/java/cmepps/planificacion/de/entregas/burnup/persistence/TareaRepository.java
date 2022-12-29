/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cmepps.planificacion.de.entregas.burnup.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import cmepps.planificacion.de.entregas.burnup.models.Tarea;

/**
 *
 * @author SaulWorkStation
 */
public interface TareaRepository extends JpaRepository<Tarea, Long>{
    
}
