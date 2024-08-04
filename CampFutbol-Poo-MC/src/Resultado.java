import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Resultado {
    // Atributos
    private int golesEquipoA;
    private int golesEquipoB;
    private String ganador;

    // Métodos
    public static List<int[]> registrarResultados(List<Partido> partidos, Scanner scanner) {
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

    public String elegirGanador(){
        return ganador;
    }
    // Getters y Setters
}
