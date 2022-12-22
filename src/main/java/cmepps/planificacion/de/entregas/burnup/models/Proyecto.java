package cmepps.planificacion.de.entregas.burnup.models;

/**
 *
 * @author Saúl Rodríguez Naranjo
 */
public class Proyecto {
    
    private String nombreDeProyecto;
    
    //Se especifica en semanas
    private int duracionDelSprint;
    
    private int velocidadDelEquipo;

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
    
    
    
}
