package persistencia;

public class Evaluaciones  implements java.io.Serializable {


     private Integer idEvaluacion;
     private String nombre;
     private String fechaInicio;
     private String fechaFin;
     private int year;
     private String lenguaje;

    public Evaluaciones() {
    }

	
    public Evaluaciones(String nombre, String fechaInicio, String fechaFin, int year) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.year = year;
    }
    public Evaluaciones(String nombre, String fechaInicio, String fechaFin, int year, String lenguaje) {
       this.nombre = nombre;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.year = year;
       this.lenguaje = lenguaje;
    }
   
    public Integer getIdEvaluacion() {
        return this.idEvaluacion;
    }
    
    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
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




}


