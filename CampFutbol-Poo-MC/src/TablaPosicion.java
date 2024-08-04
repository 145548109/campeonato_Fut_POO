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
    public void presentarTabla() {

    }

    public boolean existeEmpate(){
        return empate;
    }
}
