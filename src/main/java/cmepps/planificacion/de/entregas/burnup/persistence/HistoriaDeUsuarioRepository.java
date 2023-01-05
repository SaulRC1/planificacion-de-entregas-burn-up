/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cmepps.planificacion.de.entregas.burnup.persistence;

import cmepps.planificacion.de.entregas.burnup.models.HistoriaDeUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author SaulWorkStation, IsmaelWorkStation
 */
public interface HistoriaDeUsuarioRepository extends JpaRepository<HistoriaDeUsuario, Long>{
    
    public HistoriaDeUsuario findByNombreDeHistoria(String nombreHistoria);
    
}
