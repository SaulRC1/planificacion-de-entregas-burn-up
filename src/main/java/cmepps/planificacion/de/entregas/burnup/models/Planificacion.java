/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cmepps.planificacion.de.entregas.burnup.models;

import java.util.List;

/**
 * Esta clase encapsula los valores necesarios para la planificacion burn-up
 * de un proyecto.
 * 
 * @author Saúl Rodríguez Naranjo, Ismael Da Palma Fernández y Gonzalo Casquete Rodríguez
 */
public class Planificacion {

    private List<Tarea> tareasPlanificadas;
    
    private List<Integer> puntosRestantes;
    
    private List<Integer> numeroDeSprintsRealizados;

    public Planificacion(List<Tarea> tareasPlanificadas, List<Integer> puntosRestantes, List<Integer> numeroDeSprintsRealizados) {
        this.tareasPlanificadas = tareasPlanificadas;
        this.puntosRestantes = puntosRestantes;
        this.numeroDeSprintsRealizados = numeroDeSprintsRealizados;
    }

    public List<Tarea> getTareasPlanificadas() {
        return tareasPlanificadas;
    }

    public void setTareasPlanificadas(List<Tarea> tareasPlanificadas) {
        this.tareasPlanificadas = tareasPlanificadas;
    }

    public List<Integer> getPuntosRestantes() {
        return puntosRestantes;
    }

    public void setPuntosRestantes(List<Integer> puntosRestantes) {
        this.puntosRestantes = puntosRestantes;
    }

    public List<Integer> getNumeroDeSprintsRealizados() {
        return numeroDeSprintsRealizados;
    }

    public void setNumeroDeSprintsRealizados(List<Integer> numeroDeSprintsRealizados) {
        this.numeroDeSprintsRealizados = numeroDeSprintsRealizados;
    }
    
    
}
