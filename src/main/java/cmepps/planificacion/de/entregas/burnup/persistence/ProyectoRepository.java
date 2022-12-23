/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cmepps.planificacion.de.entregas.burnup.persistence;

import cmepps.planificacion.de.entregas.burnup.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author SaulWorkStation
 */
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
    
}
