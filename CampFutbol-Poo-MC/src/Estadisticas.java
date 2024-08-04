public class Estadisticas {

    // Atributos
    private Equipo equipo;
    private int puntos;
    private int golesAFavor;
    private int golesEnContra;
    private int partidoEmpatado;
    private int partidoPerdido;

    // Constructor
    public Estadisticas(Equipo equipo) {
        this.equipo = equipo;
        this.puntos = 0;
        this.golesAFavor = 0;
        this.golesEnContra = 0;
    }

    // Métodos
    public void actualizarEstadisticas(int golesAFavor, int golesEnContra) {
        this.golesAFavor += golesAFavor;
        this.golesEnContra += golesEnContra;
        if (golesAFavor > golesEnContra) {
            this.puntos += 3;
        } else if (golesAFavor == golesEnContra) {
            this.puntos += 1;
        }
    }

    // Getters y Setters
    public int getPuntos() {
        return puntos;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public int getDiferenciaGoles() {
        return golesAFavor - golesEnContra;
    }

    public Equipo getEquipo() {
        return equipo;
    }
}
