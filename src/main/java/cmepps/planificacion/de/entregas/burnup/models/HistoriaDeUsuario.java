package cmepps.planificacion.de.entregas.burnup.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Saúl Rodríguez Naranjo e Ismael Da Palma Fernández
 */
@Entity
@Table(name = "historia_de_usuario")
public class HistoriaDeUsuario {
    
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 100, name = "historia_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historia_sequence")
    private long idHistoriaDeUsuario;
    
    private String usuario;
    
    private String nombreDeHistoria;
    
    private String descripcion;
    
    private int valorAportado;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "historia")
    private List<Tarea> listaDeTareas;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "proyecto")
    private Proyecto proyecto;

    public HistoriaDeUsuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombreDeHistoria() {
        return nombreDeHistoria;
    }

    public void setNombreDeHistoria(String nombreDeHistoria) {
        this.nombreDeHistoria = nombreDeHistoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValorAportado() {
        return valorAportado;
    }

    public void setValorAportado(int valorAportado) {
        this.valorAportado = valorAportado;
    }

    public List<Tarea> getListaDeTareas() {
        return listaDeTareas;
    }

    public void setListaDeTareas(List<Tarea> listaDeTareas) {
        this.listaDeTareas = listaDeTareas;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public long getIdHistoriaDeUsuario() {
        return idHistoriaDeUsuario;
    }

    public void setIdHistoriaDeUsuario(long idHistoriaDeUsuario) {
        this.idHistoriaDeUsuario = idHistoriaDeUsuario;
    }

    @Override
    public String toString() {
        return "HistoriaDeUsuario{" + "idHistoriaDeUsuario=" + idHistoriaDeUsuario + ", usuario=" + usuario + ", nombreDeHistoria=" + nombreDeHistoria + ", descripcion=" + descripcion + ", valorAportado=" + valorAportado + ", proyecto=" + proyecto + '}';
    }
    
}
