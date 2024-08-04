import java.util.ArrayList;
import java.util.List;

public class Grupo {
    // Atributos
    private String nombre;
    private List<Equipo> equipos;
    private List<Partido> partidos;

    // Constructor
    public Grupo(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    // Métodos
    public void agregarEquipo(Equipo equipo) {

        equipos.add(equipo);
    }

    public void programarPartidos() {
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                Partido partido = new Partido(equipos.get(i), equipos.get(j), null, null, null);
                partidos.add(partido);
            }
        }
    }

    public void registrarResultados(List<int[]> resultados) {
        for (int[] resultado : resultados) {
            Equipo equipoA = equipos.get(resultado[0]);
            Equipo equipoB = equipos.get(resultado[1]);
            int golesA = resultado[2];
            int golesB = resultado[3];
            for (Partido partido : partidos) {
                if (partido.getEquipoA() == equipoA && partido.getEquipoB() == equipoB) {
                    partido.registrarResultado(golesA, golesB);
                    break;
                }
            }
        }
    }

    public List<Estadisticas> calcularClasificacion() {
        List<Estadisticas> tabla = new ArrayList<>();
        for (Equipo equipo : equipos) {
            Estadisticas estadisticas = new Estadisticas(equipo);
            for (Partido partido : partidos) {
                if (partido.getEquipoA() == equipo) {
                    estadisticas.actualizarEstadisticas(partido.getResultado()[0], partido.getResultado()[1]);
                } else if (partido.getEquipoB() == equipo) {
                    estadisticas.actualizarEstadisticas(partido.getResultado()[1], partido.getResultado()[0]);
                }
            }
            tabla.add(estadisticas);
        }
        tabla.sort((e1, e2) -> Integer.compare(e2.getPuntos(), e1.getPuntos()));
        return tabla;
    }

    // Getters y Setters
    public String getNombre() {

        return nombre;
    }

    public List<Partido> getPartidos() {

        return partidos;
    }
}
