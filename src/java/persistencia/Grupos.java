package persistencia;
// Generated 27/06/2014 02:04:02 PM by Hibernate Tools 3.6.0



/**
 * Grupos generated by hbm2java
 */
public class Grupos  implements java.io.Serializable {


     private Integer idGrupo;
     private String nombre;
     private int idDocente;
     private int nivel;
     private int idEvaluacion;

    public Grupos() {
    }

    public Grupos(String nombre, int idDocente, int nivel, int idEvaluacion) {
       this.nombre = nombre;
       this.idDocente = idDocente;
       this.nivel = nivel;
       this.idEvaluacion = idEvaluacion;
    }
   
    public Integer getIdGrupo() {
        return this.idGrupo;
    }
    
    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIdDocente() {
        return this.idDocente;
    }
    
    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }
    public int getNivel() {
        return this.nivel;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getIdEvaluacion() {
        return this.idEvaluacion;
    }
    
    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }




}


