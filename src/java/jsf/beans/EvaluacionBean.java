package jsf.beans;

import bo.EvaluacionImpBO;
import java.io.File;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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

    public String insert() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ServletContext context = ((HttpServletRequest) ctx.getExternalContext().getRequest()).getSession().getServletContext();
        String path = context.getRealPath("grupos");
        path = path.replace("\\", "\\\\");
        path += "\\\\";
        try {
            evaluacionBO.insert(this);
            getAll();
            File f = new File(path+lenguaje+fechaInicio+fechaFin);
            f.mkdir();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito !!", "La evaluacion fue registrada satisfactoriamente."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !!", "Ocurrio un error con el registro."));
            e.printStackTrace();
        }
        return "";
    }

    public String delete() {
        try {
            evaluacionBO.delete(selectedEvaluacion);
            getAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exito !!", "La evaluacion fue eliminada satisfactoriamente."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error !!", "Ocurrio un error con a la hora de eliminar el registro."));
        }
        return "";
    }

    public String update() {
        evaluacionBO.update(selectedEvaluacion);
        getAll();
        return "";
    }

    @PostConstruct
    public void getAll() {
        setLista(evaluacionBO.getAll());
        dataModel = new EvaluacionesDataModel(getLista());
    }

}
