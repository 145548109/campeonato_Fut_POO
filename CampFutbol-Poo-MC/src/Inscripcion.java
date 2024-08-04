import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
    // Atributos
    private List<Equipo> equipos;
    private String jugador;

    // Constructor
    public Inscripcion() {
        this.equipos = new ArrayList<>();
    }

    // Métodos
    public void inscribirEquipo(Equipo equipo) {

        equipos.add(equipo);
    }

    public void inscribirJugador(String jugador) {

        this.jugador = jugador;
    }

    public List<Equipo> listarEquipos() {

        return equipos;
    }

    // Getters y Setters
}
