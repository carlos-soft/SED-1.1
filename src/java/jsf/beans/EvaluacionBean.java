package jsf.beans;

import bo.EvaluacionImpBO;

public class EvaluacionBean {

    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private int year;
    private String lenguaje;
    private EvaluacionImpBO evaluacionBO;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public EvaluacionImpBO getEvaluacionBO() {
        return evaluacionBO;
    }

    public void setEvaluacionBO(EvaluacionImpBO evaluacionBO) {
        this.evaluacionBO = evaluacionBO;
    }
    
    public String insert(){
        evaluacionBO.insert(this);
        return "";
    }
    
}
