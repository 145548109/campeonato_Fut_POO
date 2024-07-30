public class Grupo {
    //relaciones
    public Partido partidoGrupo;

    //atributos
    private String grupo;
    private String estadoDePartido;

    //metodos
    public String mostrarrClasificacion(String escoger){
        System.out.println("Se muestra el ganador.");
        return escoger;
    }

    public int calcularAvance(int sumar){
        System.out.println("Se calcula el avance.");
        return 0;
    }
}
