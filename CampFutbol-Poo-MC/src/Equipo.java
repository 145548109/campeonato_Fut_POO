import java.util.ArrayList;
import java.util.List;

public class Equipo {
    // Atributos
    private String nombre;
    private List<Jugador> miembros;

    // Constructor
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.miembros = new ArrayList<>();
    }

    // Métodos
    public void agregarJugador(Jugador jugador) {
        miembros.add(jugador);
    }

    public void eliminarJugador(Jugador jugador) {
        miembros.remove(jugador);
    }

    public List<Jugador> listarJugadores() {
        return miembros;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
}
