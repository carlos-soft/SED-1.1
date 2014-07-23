package persistencia;
// Generated 23/07/2014 02:04:06 PM by Hibernate Tools 3.6.0



/**
 * Alumnos generated by hbm2java
 */
public class Alumnos  implements java.io.Serializable {


     private Integer idAlumno;
     private int idEvaluacion;
     private int idGrupo;
     private String control;
     private String nombre;
     private boolean evaluado;

    public Alumnos() {
    }

    public Alumnos(int idEvaluacion, int idGrupo, String control, String nombre, boolean evaluado) {
       this.idEvaluacion = idEvaluacion;
       this.idGrupo = idGrupo;
       this.control = control;
       this.nombre = nombre;
       this.evaluado = evaluado;
    }
   
    public Integer getIdAlumno() {
        return this.idAlumno;
    }
    
    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }
    public int getIdEvaluacion() {
        return this.idEvaluacion;
    }
    
    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    public int getIdGrupo() {
        return this.idGrupo;
    }
    
    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
    public String getControl() {
        return this.control;
    }
    
    public void setControl(String control) {
        this.control = control;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isEvaluado() {
        return this.evaluado;
    }
    
    public void setEvaluado(boolean evaluado) {
        this.evaluado = evaluado;
    }




}


