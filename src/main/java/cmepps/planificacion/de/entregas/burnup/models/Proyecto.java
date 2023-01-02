package cmepps.planificacion.de.entregas.burnup.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Saúl Rodríguez Naranjo
 */
@Entity
@Table(name = "proyecto")
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
    
}
