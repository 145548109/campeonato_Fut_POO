import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Equipo> equipos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\n\t\t\tBienvenido al sistema de gestión de campeonatos!\n");
        System.out.println("Podrás: Gestionar equipos, partidos y resultados de campeonatos.\n");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("IMPORTANTE: Para un correcto funcionamiento deberas completar adecuadamente los campos solicitados:");
        System.out.println("-EL nombre del campeonato debe contener unicamente letras.");
        System.out.println("-El nombre del equipo NO debe contener: espacios, numeros.");
        System.out.println("-Ingresar unicamente numeros en: número de equipos, goles, DNI");
        System.out.println("-Completar el nombre del jugador con el formato: nombre apellido.");
        System.out.println("-Completar fecha de nacimiento con el formato aaaa-mm-dd (Ejemplo: 2001-01-01).");
        System.out.println("-----------------------------------------------------------------------------\n");

        // Solicitar el nombre del campeonato
        System.out.print("Ingrese el nombre del campeonato: ");
        String nombreCampeonato = scanner.nextLine();

        // Solicitar la fecha de inicio y fin del campeonato
        System.out.print("Ingrese la fecha de inicio del campeonato (AAAA-MM-DD): ");
        String fechaInicio = scanner.nextLine();

        System.out.print("Ingrese la fecha de fin del campeonato (AAAA-MM-DD): ");
        String fechaFin = scanner.nextLine();

        // Seleccionar el tipo de campeonato
        String tipoCampeonato = CampeonatoFutbol.seleccionarTipoCampeonato(scanner);
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
        for (int i = 0; i < numEquipos; i++) {
            Equipo equipo = Equipo.crearEquipo(scanner);
            equipos.add(equipo);

            // Añadir equipo al campeonato
            if (campeonato instanceof Liga) {
                ((Liga) campeonato).agregarEquipo(equipo);
            } else if (campeonato instanceof Torneo) {
                ((Torneo) campeonato).agregarEquipo(equipo);
            } else if (campeonato instanceof Grupo) {
                ((Grupo) campeonato).agregarEquipo(equipo);
            }
        }

        // Resto del código para manejar partidos y resultados
        if (campeonato instanceof Liga) {
            Liga liga = (Liga) campeonato;
            liga.programarPartidos();
            List<int[]> resultados = Resultado.registrarResultados(liga.getPartidos(), scanner);
            liga.registrarResultados(resultados);
            TablaPosicion.imprimirClasificacion(liga.calcularClasificacion(), liga.getPartidos());
        } else if (campeonato instanceof Torneo) {
            Torneo torneo = (Torneo) campeonato;
            torneo.programarPartidos();
            List<int[]> resultados = Resultado.registrarResultados(torneo.getPartidos(), scanner);
            torneo.registrarResultados(resultados);
            TablaPosicion.imprimirClasificacion(torneo.calcularClasificacion(), torneo.getPartidos());
        } else if (campeonato instanceof Grupo) {
            Grupo grupo = (Grupo) campeonato;
            grupo.programarPartidos();
            List<int[]> resultados = Resultado.registrarResultados(grupo.getPartidos(), scanner);
            grupo.registrarResultados(resultados);
            TablaPosicion.imprimirClasificacion(grupo.calcularClasificacion(), grupo.getPartidos());
        }

        // Imprimir estadísticas de los jugadores de cada equipo
        for (Equipo equipo : equipos) {
            equipo.imprimirEstadisticasJugadores();
        }
    }
}