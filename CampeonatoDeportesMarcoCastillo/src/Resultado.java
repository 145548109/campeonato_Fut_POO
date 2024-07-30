public class Resultado {
    //relaciones
    public Partido partido;

    //atributos

    public int puntosEquipoA;
    public int puntosEequipoB;
    public String ganador;

    //metodos
public String obtenerGanador(){
        System.out.println("Se muestra el resultado");
        return "Equipo ganador: A";
}
}
