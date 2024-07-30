import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Crear un árbitro
        System.out.println("Ingrese el nombre del árbitro:");
        String nombreArbitro = scanner.nextLine();
        Arbitro arbitro = new Arbitro(nombreArbitro);

        // Crear una liga
        Liga liga = new Liga();

        // Crear un partido y asociarlo con la liga y el árbitro
        Partido partido = new Partido();
        partido.setArbitro(arbitro);
        partido.setLiga(liga);

        // Ingresar el número de jugadores de cada equipo
        System.out.println("Ingrese el número de jugadores del equipo A:");
        int numJugadoresEquipoA = scanner.nextInt();
        partido.setNumJugadoresEquipoA(numJugadoresEquipoA);

        System.out.println("Ingrese el número de jugadores del equipo B:");
        int numJugadoresEquipoB = scanner.nextInt();
        partido.setNumJugadoresEquipoB(numJugadoresEquipoB);

        // Ingresar el resultado del partido
        System.out.println("Ingrese el resultado del partido:");
        scanner.nextLine(); // consume the newline left-over
        String resultado = scanner.nextLine();
        partido.setResultado(resultado);

        // Crear una lista de partidos
        List<Partido> partidos = new ArrayList<>();
        partidos.add(partido);

        // Crear un campeonato de fútbol y asociarlo con los partidos
        CampeonatoFutbol campeonato = new CampeonatoFutbol(partidos);

        // Ingresar la fecha de inicio del campeonato
        System.out.println("Ingrese la fecha de inicio del campeonato (dd/MM/yyyy):");
        String fechaInicioStr = scanner.nextLine();


        // Ingresar la fecha de fin del campeonato
        System.out.println("Ingrese la fecha de fin del campeonato (dd/MM/yyyy):");
        String fechaFinStr = scanner.nextLine();


        // Crear una tabla de posiciones y asociarla con el campeonato
        TablaPosicion tablaPosicion = new TablaPosicion();
        tablaPosicion.setCampeonato(campeonato);

        // Crear estadísticas y asociarlas con la tabla de posiciones y un jugador
        Estadisticas estadisticas = new Estadisticas();
        estadisticas.setTablaPosicion(tablaPosicion);
        estadisticas.setJugador(new Jugador());

        // Actualizar las estadísticas
        estadisticas.actualizarEstadisticas("Información de las estadísticas");

        // Imprimir la información del partido
        System.out.println("Nombre del árbitro: " + partido.getNombreArbitro());
        System.out.println("Número de jugadores del equipo A: " + partido.getNumJugadoresEquipoA());
        System.out.println("Número de jugadores del equipo B: " + partido.getNumJugadoresEquipoB());
        System.out.println("Resultado del partido: " + partido.getResultado());

        // Imprimir si el resultado del partido es un empate
        if (partido.esEmpate()) {
            System.out.println("El partido terminó en empate.");
        } else {
            System.out.println("El partido no terminó en empate.");
        }

    }
}
