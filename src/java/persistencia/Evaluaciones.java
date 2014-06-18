package persistencia;
// Generated 18/06/2014 01:33:23 PM by Hibernate Tools 3.6.0



/**
 * Evaluaciones generated by hbm2java
 */
public class Evaluaciones  implements java.io.Serializable {


     private Integer idEvaluacion;
     private String fechaInicio;
     private String fechaFin;
     private int year;
     private String lenguaje;
     private String estado;

    public Evaluaciones() {
    }

	
    public Evaluaciones(String fechaInicio, String fechaFin, int year, String estado) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.year = year;
        this.estado = estado;
    }
    public Evaluaciones(String fechaInicio, String fechaFin, int year, String lenguaje, String estado) {
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.year = year;
       this.lenguaje = lenguaje;
       this.estado = estado;
    }
   
    public Integer getIdEvaluacion() {
        return this.idEvaluacion;
    }
    
    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    public String getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    public String getLenguaje() {
        return this.lenguaje;
    }
    
    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


