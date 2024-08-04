public class Jugador extends Persona {

    // Atributos
    private int numeroCamisa;
    private int faltas;
    private int numeroGoles;
    private int partidosJugados;

    // Constructor
    public Jugador(String nombre, String DNI, String fechaNacimiento, int numeroCamisa) {
        super(nombre, DNI, fechaNacimiento);
        this.numeroCamisa = numeroCamisa;
        this.faltas = 0;
        this.numeroGoles = 0;
        this.partidosJugados = 0;
    }

    //metodos
    public void anotarGol() {
        this.numeroGoles++;
    }

    // Getters y Setters

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getNumeroGoles() {
        return numeroGoles;
    }

    public void setNumeroGoles(int numeroGoles) {
        this.numeroGoles = numeroGoles;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }
}
