/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmepps.planificacion.de.entregas.burnup.models.comparator;

import cmepps.planificacion.de.entregas.burnup.models.Tarea;
import java.util.Comparator;

/**
 *
 * @author Saúl Rodríguez Naranjo
 */
public class TareaComparator implements Comparator<Tarea> {

    @Override
    public int compare(Tarea tarea1, Tarea tarea2) {

        int metricaViabilidad1 = tarea1.getHistoria().getValorAportado() * tarea1.getPrioridad();

        int metricaViabilidad2 = tarea2.getHistoria().getValorAportado() * tarea2.getPrioridad();

        int returnedComparison = 0;
        
        if (metricaViabilidad1 > metricaViabilidad2) {
            returnedComparison = 1;
        }

        if (metricaViabilidad1 == metricaViabilidad2) {
            returnedComparison = 0;
        }

        if (metricaViabilidad1 < metricaViabilidad2) {
            returnedComparison = -1;
        }
        
        return (returnedComparison * (-1));
    }

}
