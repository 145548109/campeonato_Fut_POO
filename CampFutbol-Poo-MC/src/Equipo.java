import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Equipo {
    // Atributos
    private String nombre;
    private List<Jugador> jugadores;

    // Constructor
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    // Métodos
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public static Equipo crearEquipo(Scanner scanner) {
        System.out.println("\n\t\tCOMPLETE LOS DATOS DEL EQUIPO!");
        System.out.print("Nombre: ");
        String nombreEquipo = scanner.nextLine();
        Equipo equipo = new Equipo(nombreEquipo);
        System.out.print("Número de jugadores en " + nombreEquipo + ": ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer de entrada
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = Jugador.crearJugador(scanner);
            equipo.agregarJugador(jugador);
        }
        return equipo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
