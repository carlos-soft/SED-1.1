package persistencia;
// Generated 04-jul-2014 23:09:14 by Hibernate Tools 3.6.0



/**
 * Docentes generated by hbm2java
 */
public class Docentes  implements java.io.Serializable {


     private Integer idDocente;
     private String nombre;

    public Docentes() {
    }

    public Docentes(String nombre) {
       this.nombre = nombre;
    }
   
    public Integer getIdDocente() {
        return this.idDocente;
    }
    
    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}


