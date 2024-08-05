import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampeonatoFutbol {
    //atributos
    private String nombre;
    private String jugador;
    private String fechaInicio;
    private String fechaFin;
    private List<Equipo> equipo;
    private List<Partido> partidos;

    //constructor
    public CampeonatoFutbol(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    //metodos
    public static String seleccionarTipoCampeonato(Scanner scanner) {
        System.out.println("DIGITE EL TIPO DE CAMPEONATO:");
        System.out.println("1. Liga");
        System.out.println("2. Torneo");
        System.out.println("3. Grupo");
        System.out.print("Digite número: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer de entrada
        switch (opcion) {
            case 1:
                return "liga";
            case 2:
                return "torneo";
            case 3:
                return "grupo";
            default:
                System.out.println("Opción no válida. Seleccionando 'Liga' por defecto.");
                return "liga";
        }
    }

    public void iniciarCampeonato(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void finalizarCampeonato(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Getters y Setters
    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public List<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Equipo> equipo) {
        this.equipo = equipo;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

}
