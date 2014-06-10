package jsf.beans;

import bo.EvaluacionImpBO;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.event.SelectEvent;
import persistencia.Evaluaciones;

public class EvaluacionBean {

    private String idEvaluacion;
    private String fechaInicio;
    private String fechaFin;
    private int year;
    private String lenguaje;
    private String estado;
    private EvaluacionImpBO evaluacionBO;
    private List<Evaluaciones> lista;
    private Evaluaciones selectedEvaluacion;
    private EvaluacionesDataModel dataModel;

    public String getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(String idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Evaluaciones> getLista() {
        return lista;
    }

    public void setLista(List<Evaluaciones> lista) {
        this.lista = lista;
    }

    public EvaluacionesDataModel getDataModel() {
        return dataModel;
    }
    
    public EvaluacionImpBO getEvaluacionBO() {
        return evaluacionBO;
    }

    public void setEvaluacionBO(EvaluacionImpBO evaluacionBO) {
        this.evaluacionBO = evaluacionBO;
    }

    public Evaluaciones getSelectedEvaluacion() {
        return selectedEvaluacion;
    }

    public void setSelectedEvaluacion(Evaluaciones selectedEvaluacion) {
        this.selectedEvaluacion = selectedEvaluacion;
    }
    
    public void onRowSelect(SelectEvent event) {
        /*FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);*/
        System.out.println("Hola Mundo...");
    }
    
    public String insert(){
        evaluacionBO.insert(this);
        return "";
    }
    
    @PostConstruct
    public void getAll(){
        System.out.println("Entro al getAll() ");
        setLista(evaluacionBO.getAll());
        dataModel = new EvaluacionesDataModel(getLista());
    }
    
}
