import java.util.Date;
import java.util.List;

class CampeonatoFutbol{
    //relacion de composicion
    private List<Partido> partidos;

    // atributos
    private Date fechaInicio;
    private Date fechaFin;

    public CampeonatoFutbol(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    // otros métodos

        //  métodos
    public void iniciarCampeonato(Date fechaInicio){
        System.out.println("Se inicia el campeonato");
    }

    public void finalizarCampeonato(Date fechaInicio){
        System.out.println("Se finaliza el campeonato");
    }
}
