import java.util.Date;

public class Partido {
    // relaciones
    public Arbitro arbitro;

    // atributos
    public Date fecha;
    public String equipoA;
    public String equipoB;
    public String resultado;
    public int numJugadoresEquipoA;
    public int numJugadoresEquipoB;

    // métodos
    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public void setNumJugadoresEquipoA(int numJugadores) {
        this.numJugadoresEquipoA = numJugadores;
    }

    public void setNumJugadoresEquipoB(int numJugadores) {
        this.numJugadoresEquipoB = numJugadores;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return this.resultado;
    }

    public String getNombreArbitro() {
        return this.arbitro.getNombre();
    }

    public int getNumJugadoresEquipoA() {
        return this.numJugadoresEquipoA;
    }

    public int getNumJugadoresEquipoB() {
        return this.numJugadoresEquipoB;
    }

    public void setLiga(Liga liga) {
    }


    public boolean esEmpate() {
        String[] goles = this.resultado.split("-");
        return goles[0].equals(goles[1]);
    }
}
