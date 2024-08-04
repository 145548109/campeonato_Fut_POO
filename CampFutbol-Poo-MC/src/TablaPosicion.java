import java.util.List;

public class TablaPosicion {
    // Atributos
    private String posicion;
    private boolean empate;

    // Constructor
    public TablaPosicion(String posicion, boolean empate) {
        this.posicion = posicion;
        this.empate = empate;
    }

    // Métodos
    public boolean existeEmpate() {
        return empate;
    }

    public static void imprimirClasificacion(List<Estadisticas> clasificacion, List<Partido> partidos) {
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
                System.out.println("Finaliza el campeonato!");
            }
        }
    }
}
