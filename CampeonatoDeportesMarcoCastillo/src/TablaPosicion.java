public class TablaPosicion {
    //relacion
    public CampeonatoFutbol campeonato;

    //atributos
    private String posicion;
    private boolean empate;

    //metodos
    public void obtenerTabla(){
        System.out.println("Se obtiene tabla de posiciones");
    }

    public void actualizarPosicion(){
        System.out.println("Se actualiza la posicion");
    }

    public void presentartabla(){
        System.out.println("Se presenta Tabla");
    }

    public void dos_a_dos(boolean empate){
        System.out.println("Existe un empate");
    }

    public void setCampeonato(CampeonatoFutbol campeonato) {

    }
}
