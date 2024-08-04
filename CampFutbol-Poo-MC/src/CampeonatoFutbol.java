import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampeonatoFutbol {
    //atributos
   private String nombre;
   private String jugador;

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
}
