package cmepps.planificacion.de.entregas.burnup.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Saúl Rodríguez Naranjo e Ismael Da Palma Fernández
 */
@Entity
@Table(name = "tarea")
public class Tarea {
    
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 100, name = "tarea_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarea_sequence")
    private long idTarea;
    
    private String nombreDeTarea;
    
    private int prioridad;
    
    private int esfuerzo;
    
    private String descripcion;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "historia")
    private HistoriaDeUsuario historia;

    public Tarea() {
    }

    public String getNombreDeTarea() {
        return nombreDeTarea;
    }

    public void setNombreDeTarea(String nombreDeTarea) {
        this.nombreDeTarea = nombreDeTarea;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getEsfuerzo() {
        return esfuerzo;
    }

    public void setEsfuerzo(int esfuerzo) {
        this.esfuerzo = esfuerzo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public HistoriaDeUsuario getHistoria() {
        return historia;
    }

    public void setHistoria(HistoriaDeUsuario historia) {
        this.historia = historia;
    }

    public long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(long idTarea) {
        this.idTarea = idTarea;
    }
    
}
