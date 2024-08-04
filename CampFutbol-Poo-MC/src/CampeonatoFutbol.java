import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampeonatoFutbol {
    //atributos
    private String nombre;
    private String jugador;


    //metodos
    public static String seleccionarTipoCampeonato() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona el tipo de campeonato:");
        System.out.println("1. Liga");
        System.out.println("2. Torneo");
        System.out.println("3. Grupo");
        System.out.print("Opción (1/2/3): ");
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

    public static List<int[]> registrarResultados(List<Partido> partidos) {
        List<int[]> resultados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (Partido partido : partidos) {
            System.out.println("Partido: " + partido.getEquipoA().getNombre() + " vs " + partido.getEquipoB().getNombre());
            System.out.print("Goles de " + partido.getEquipoA().getNombre() + ": ");
            int golesA = scanner.nextInt();
            System.out.print("Goles de " + partido.getEquipoB().getNombre() + ": ");
            int golesB = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer de entrada
            resultados.add(new int[]{partidos.indexOf(partido), golesA, golesB});
        }
        return resultados;
    }
}
