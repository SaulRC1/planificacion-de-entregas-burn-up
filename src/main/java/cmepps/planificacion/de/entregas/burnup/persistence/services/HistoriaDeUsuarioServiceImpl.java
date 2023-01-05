/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cmepps.planificacion.de.entregas.burnup.persistence.services;

import cmepps.planificacion.de.entregas.burnup.models.HistoriaDeUsuario;
import cmepps.planificacion.de.entregas.burnup.persistence.HistoriaDeUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saúl Rodríguez Naranjo e Ismael Da Palma Fernández
 */
@Service
public class HistoriaDeUsuarioServiceImpl implements HistoriaDeUsuarioService {

    @Autowired
    private HistoriaDeUsuarioRepository historiaRepository;
    
    @Override
    public Optional<HistoriaDeUsuario> getHistoriaById(long id) {
        return historiaRepository.findById(id);
    }

    @Override
    public void saveHistoriaDeUsuario(HistoriaDeUsuario historia) {
        historiaRepository.save(historia);
    }

    @Override
    public void updateHistoriaDeUsuario(HistoriaDeUsuario historia) {
        historiaRepository.save(historia);
    }

    @Override
    public void deleteHistoriaDeUsuario(HistoriaDeUsuario historia) {
        historiaRepository.delete(historia);
    }

    @Override
    public HistoriaDeUsuario getHistoriaByName(String nombreHistoria) {
        return historiaRepository.findByNombreDeHistoria(nombreHistoria);
    }

}
