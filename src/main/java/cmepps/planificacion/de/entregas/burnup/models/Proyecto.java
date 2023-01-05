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

    // Se especifica en semanas
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

    public Planificacion planificarProyecto() {

        List<Tarea> tareasOrdenadas = new ArrayList<>();

        for (HistoriaDeUsuario historia : this.historiasDeUsuario) {

            List<Tarea> tareasHistoria = historia.getListaDeTareas();

            for (Tarea tarea : tareasHistoria) {

                tareasOrdenadas.add(tarea);
            }
        }

        Collections.sort(tareasOrdenadas, new TareaComparator());//Ordena las tareas segun v*p

        List<Tarea> tareasPlanificadas = new ArrayList<>();//Lista de tareas planificadas

        int puntosSprintRestantes = this.velocidadDelEquipo;//Esfuerzo disponible por sprint

        List<Integer> puntosRestantes = new ArrayList();//Lista de esfuerzos restantes segun la tarea realziada en ese momento
        List<Integer> nSprintRealizado = new ArrayList();//Numero de Sprint en el que se realiza la tarea
        int sprint = 1;

        while (!tareasOrdenadas.isEmpty()) {//Hasta que no esten todas las tareas realizadas, no se acaba

            List<Tarea> tareasIteracion = new ArrayList<>();
            
            tareasIteracion.addAll(tareasOrdenadas);
            
            for (int i = 0; i < tareasIteracion.size(); i++) {//Recorremos todas las tareas con los puntos de 1 sprint, hasta que se agoten
                if (puntosSprintRestantes - tareasIteracion.get(i).getEsfuerzo() >= 0) {
                    tareasPlanificadas.add(tareasIteracion.get(i));	//Añadimos a la planificacion la tarea tratada
                    puntosSprintRestantes = puntosSprintRestantes - tareasIteracion.get(i).getEsfuerzo();//Actualizamos los puntos restantes

                    puntosRestantes.add(puntosSprintRestantes);//Guardamos cuantos puntos restan al realizar la tarea
                    nSprintRealizado.add(sprint);//Guardamos en que sprint se ha hecho la tarea

                    tareasOrdenadas.remove(tareasIteracion.get(i));//Eliminamos la tarea de la lista de tareas a tratar
                }

            }
            sprint++;//Incrementamos el sprint
            puntosSprintRestantes = this.velocidadDelEquipo;//Reiniciamos los puntos por sprint

        }

        //Nos quedariamos con: tareasPlanificadas, puntosRestantes y nSprintRealizado
        System.out.println("Mostrando la informacion:");
        for (int i = 0; i < tareasPlanificadas.size(); i++) {

            System.out.println("Tarea: " + tareasPlanificadas.get(i).getNombreDeTarea()
                    + "-esfuerzo:" + tareasPlanificadas.get(i).getEsfuerzo()
                    + "-sprint:" + nSprintRealizado.get(i) + "-puntosRestantes:" + puntosRestantes.get(i));

        }

        return new Planificacion(tareasPlanificadas, puntosRestantes, nSprintRealizado);
    }

}
