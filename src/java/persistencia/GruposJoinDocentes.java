package persistencia;

public class GruposJoinDocentes {

    private Integer idGrupo;
    private String nombre;
    private String docente;
    private int idDocente;
    private int nivel;
    private int idEvaluacion;

    public GruposJoinDocentes() {
    }

    public GruposJoinDocentes(Integer idGrupo, String nombre, String docente, int idDocente, int nivel, int idEvaluacion) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.docente = docente;
        this.idDocente = idDocente;
        this.nivel = nivel;
        this.idEvaluacion = idEvaluacion;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    
}
