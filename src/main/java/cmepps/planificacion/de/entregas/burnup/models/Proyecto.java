package cmepps.planificacion.de.entregas.burnup.models;

import cmepps.planificacion.de.entregas.burnup.models.comparator.TareaComparator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Saúl Rodríguez Naranjo
 */
@Entity
@Table(name = "proyecto")
public class Proyecto {
    
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 10, name = "proyecto_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proyecto_sequence")
    private long idProyecto;
    
    private String nombreDeProyecto;
    
    //Se especifica en semanas
    private int duracionDelSprint;
    
    private int velocidadDelEquipo;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "proyecto")
    private List<HistoriaDeUsuario> historiasDeUsuario;

    public Proyecto() {
    }

    public Proyecto(String nombreDeProyecto, int duracionDelSprint, int velocidadDelEquipo) {
        this.nombreDeProyecto = nombreDeProyecto;
        this.duracionDelSprint = duracionDelSprint;
        this.velocidadDelEquipo = velocidadDelEquipo;
    }

    public String getNombreDeProyecto() {
        return nombreDeProyecto;
    }

    public void setNombreDeProyecto(String nombreDeProyecto) {
        this.nombreDeProyecto = nombreDeProyecto;
    }

    public int getDuracionDelSprint() {
        return duracionDelSprint;
    }

    public void setDuracionDelSprint(int duracionDelSprint) {
        this.duracionDelSprint = duracionDelSprint;
    }

    public int getVelocidadDelEquipo() {
        return velocidadDelEquipo;
    }

    public void setVelocidadDelEquipo(int velocidadDelEquipo) {
        this.velocidadDelEquipo = velocidadDelEquipo;
    }

    public List<HistoriaDeUsuario> getHistoriasDeUsuario() {
        return historiasDeUsuario;
    }

    public void setHistoriasDeUsuario(List<HistoriaDeUsuario> historiasDeUsuario) {
        this.historiasDeUsuario = historiasDeUsuario;
    }

    public long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }
    
    public Proyecto planificarProyecto() {
        
        List<HistoriaDeUsuario> historiasPlanificadas = new ArrayList<>();
        
        List<Tarea> tareasOrdenadas = new ArrayList<>();
                
        for (HistoriaDeUsuario historia : this.historiasDeUsuario) {
            
            List<Tarea> tareasHistoria = historia.getListaDeTareas();
            
            for (Tarea tarea : tareasHistoria) {
                
                tareasOrdenadas.add(tarea);
            }
        }
        
        Collections.sort(tareasOrdenadas, new TareaComparator());
        
        for (Tarea tarea : tareasOrdenadas) {
            System.out.println("Tarea: " + tarea.getNombreDeTarea());
            System.out.println("V*P Tarea: " + (tarea.getHistoria().getValorAportado() * tarea.getPrioridad()));
        }
        
        return null;
    }
    
}
