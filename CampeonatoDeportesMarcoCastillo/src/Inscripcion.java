public class Inscripcion {
    //relaciones
    public Jugador participante;

    //atributos
    public String equipo;
    public String jugador;

    //metodos
    public String inscribirParticipante(String jugador){
        System.out.println("El equipo inscribe un jugador");
        return jugador;
    }

    public String incribirEquipo(String equipo){
        System.out.println("Se inscribe un equipo");
        return equipo;
    }
}