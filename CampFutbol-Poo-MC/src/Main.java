import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static Jugador crearJugador() {
        System.out.println("\n\t\tCOMPLETE LOS DATOS DEL JUGADOR!");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI: ");
        String DNI = scanner.nextLine();
        System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Número de camisa: ");
        int numeroCamisa = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer de entrada
        return new Jugador(nombre, DNI, fechaNacimiento, numeroCamisa);
    }

    private static Equipo crearEquipo() {
        System.out.println("\n\t\tCOMPLETE LOS DATOS DEL EQUIPO!");
        System.out.print("Nombre: ");
        String nombreEquipo = scanner.nextLine();
        Equipo equipo = new Equipo(nombreEquipo);
        System.out.print("Número de jugadores en " + nombreEquipo + ": ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer de entrada
        for (int i = 0; i < numJugadores; i++) {
            Jugador jugador = crearJugador();
            equipo.agregarJugador(jugador);
        }
        return equipo;
    }

    private static String seleccionarTipoCampeonato() {
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

    private static List<int[]> registrarResultados(List<Partido> partidos) {
        List<int[]> resultados = new ArrayList<>();
        for (Partido partido : partidos) {
            System.out.println("INFORMACIÓN DEL PARTIDO!");
            System.out.println("Enfrentamiento:");
            System.out.println(partido.getEquipoA().getNombre() + " contra " + partido.getEquipoB().getNombre());
            System.out.println("Ingrese los goles de cada equipo:");
            System.out.print(partido.getEquipoA().getNombre() + ": ");
            int golesA = scanner.nextInt();
            System.out.print(partido.getEquipoB().getNombre() + ": ");
            int golesB = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer de entrada
            resultados.add(new int[]{partidos.indexOf(partido), golesA, golesB});
        }
        return resultados;
    }

//    private static void imprimirClasificacion(List<Estadisticas> clasificacion) {
//        System.out.println("\nClasificación final:");
//        System.out.printf("%-20s %-6s %-15s %-15s %-15s%n", "Equipo", "Puntos", "Goles a Favor", "Goles en Contra", "Diferencia de Goles");
//        for (Estadisticas estadisticas : clasificacion) {
//            System.out.printf("%-20s %-6d %-15d %-15d %-15d%n",
//                    estadisticas.getEquipo().getNombre(),
//                    estadisticas.getPuntos(),
//                    estadisticas.getGolesAFavor(),
//                    estadisticas.getGolesEnContra(),
//                    estadisticas.getDiferenciaGoles());
//        }
//    }

    private static void imprimirClasificacion(List<Estadisticas> clasificacion, List<Partido> partidos) {
        System.out.println("\nClasificación final:");
        System.out.printf("%-20s %-6s %-15s %-15s %-15s%n", "Equipo", "Puntos", "Goles a Favor", "Goles en Contra", "Diferencia de Goles");
        for (Estadisticas estadisticas : clasificacion) {
            System.out.printf("%-20s %-6d %-15d %-15d %-15d%n",
                    estadisticas.getEquipo().getNombre(),
                    estadisticas.getPuntos(),
                    estadisticas.getGolesAFavor(),
                    estadisticas.getGolesEnContra(),
                    estadisticas.getDiferenciaGoles());
        }

        System.out.println("\nResultados de los partidos:");
        for (Partido partido : partidos) {
            String ganador = partido.determinarGanador();
            if (ganador.equals("Empate")) {
                System.out.println(partido.getEquipoA().getNombre() + " vs " + partido.getEquipoB().getNombre() + ": Empate");
            } else {
                System.out.println(partido.getEquipoA().getNombre() + " vs " + partido.getEquipoB().getNombre() + ": Ganador - " + ganador);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("\n\t\t\tBienvenido al sistema de gestión de campeonatos!\n");
        System.out.println("Podrás: Gestionar equipos, partidos y resultados de campeonatos.\n");

        // Solicitar el nombre del campeonato
        System.out.print("Ingrese el nombre del campeonato: ");
        String nombreCampeonato = scanner.nextLine();

        // Seleccionar el tipo de campeonato
        String tipoCampeonato = seleccionarTipoCampeonato();
        Object campeonato = null;
        if (tipoCampeonato.equals("liga")) {
            campeonato = new Liga(nombreCampeonato);
        } else if (tipoCampeonato.equals("torneo")) {
            campeonato = new Torneo(nombreCampeonato);
        } else if (tipoCampeonato.equals("grupo")) {
            campeonato = new Grupo(nombreCampeonato);
        }

        // Solicitar el número de equipos
        System.out.print("Ingrese el número de equipos: ");
        int numEquipos = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer de entrada
        List<Equipo> equipos = new ArrayList<>();
        for (int i = 0; i < numEquipos; i++) {
            Equipo equipo = crearEquipo();
            equipos.add(equipo);
        }

        if (campeonato instanceof Liga) {
            Liga liga = (Liga) campeonato;
            for (Equipo equipo : equipos) {
                liga.agregarEquipo(equipo);
            }
            liga.programarPartidos();
            List<int[]> resultados = registrarResultados(liga.getPartidos());
            liga.registrarResultados(resultados);
            imprimirClasificacion(liga.calcularClasificacion(), liga.getPartidos());
//            imprimirClasificacion(liga.calcularClasificacion());
        } else if (campeonato instanceof Torneo) {
            Torneo torneo = (Torneo) campeonato;
            for (Equipo equipo : equipos) {
                torneo.agregarEquipo(equipo);
            }
            torneo.programarPartidos();
            List<int[]> resultados = registrarResultados(torneo.getPartidos());
            torneo.registrarResultados(resultados);
            imprimirClasificacion(torneo.calcularClasificacion(), torneo.getPartidos());
//            imprimirClasificacion(torneo.calcularClasificacion());
        } else if (campeonato instanceof Grupo) {
            Grupo grupo = (Grupo) campeonato;
            for (Equipo equipo : equipos) {
                grupo.agregarEquipo(equipo);
            }
            grupo.programarPartidos();
            List<int[]> resultados = registrarResultados(grupo.getPartidos());
            grupo.registrarResultados(resultados);
            imprimirClasificacion(grupo.calcularClasificacion(), grupo.getPartidos());
//            imprimirClasificacion(grupo.calcularClasificacion());
        }
    }
}
