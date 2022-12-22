/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
    
    public List<Proyecto> findAll();
    
    public void saveProyecto(Proyecto proyecto);
    
    public void updateProyecto(Proyecto proyecto);
    
    public void deleteProyecto(Proyecto proyecto);
    
}
