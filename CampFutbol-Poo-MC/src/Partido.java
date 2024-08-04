public class Partido {
    // Atributos
    private Equipo equipoA;
    private Equipo equipoB;
    private String fecha;
    private int[] resultado;
    private Equipo ganador;

    // Constructor
    public Partido(Equipo equipoA, Equipo equipoB, String fecha, String hora, String ubicacion) {
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.fecha = fecha;
        this.resultado = new int[2];
        this.ganador = null;
    }

    // getters y setters
    public Equipo getEquipoA() {
        return equipoA;
    }

    public Equipo getEquipoB() {
        return equipoB;
    }

    public int[] getResultado() {
        return resultado;
    }

    // Métodos
    public void registrarResultado(int golesA, int golesB) {
        this.resultado[0] = golesA;
        this.resultado[1] = golesB;
        if (golesA > golesB) {
            this.ganador = equipoA;
        } else if (golesB > golesA) {
            this.ganador = equipoB;
        } else {
            this.ganador = null;
        }
    }

    public String determinarGanador() {
        if (this.resultado[0] > this.resultado[1]) {
            return this.equipoA.getNombre();
        } else if (this.resultado[0] < this.resultado[1]) {
            return this.equipoB.getNombre();
        } else {
            return "Empate";
        }
    }

    // Getters y Setters

}
