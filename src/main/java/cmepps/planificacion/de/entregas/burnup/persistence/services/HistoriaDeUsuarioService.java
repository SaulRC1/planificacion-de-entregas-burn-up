/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cmepps.planificacion.de.entregas.burnup.persistence.services;

import cmepps.planificacion.de.entregas.burnup.models.HistoriaDeUsuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author SaulWorkStation
 */
public interface HistoriaDeUsuarioService {
    public Optional<HistoriaDeUsuario> getHistoriaById(long id);
    
    public HistoriaDeUsuario getHistoriaByName(String nombreHistoria);
    
    public void saveHistoriaDeUsuario(HistoriaDeUsuario historia);
    
    public void updateHistoriaDeUsuario(HistoriaDeUsuario historia);
    
    public void deleteHistoriaDeUsuario(HistoriaDeUsuario historia);
}
