package jsf.beans;

import bo.DocentesImpBO;
import bo.ReportesImpBO;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import persistencia.Docentes;
import persistencia.Preguntas;

public class ReportesDocentesBean {

    private DocentesDataModel dataModel;
    private Docentes selectedDocente;
    private DocentesImpBO docentesBO;
    private ReportesImpBO reportesBO;
    private List<Preguntas> preguntas;
    private List<List<Integer>> columnas;
    private List<List<Integer>> filas;

    public ReportesDocentesBean() {
    }

    public Docentes getSelectedDocente() {
        return selectedDocente;
    }

    public void setSelectedDocente(Docentes selectedDocente) {
        this.selectedDocente = selectedDocente;
    }

    public DocentesDataModel getDataModel() {
        return dataModel;
    }

    public DocentesImpBO getDocentesBO() {
        return docentesBO;
    }

    public void setDocentesBO(DocentesImpBO docentesBO) {
        this.docentesBO = docentesBO;
    }

    public ReportesImpBO getReportesBO() {
        return reportesBO;
    }

    public void setReportesBO(ReportesImpBO reportesBO) {
        this.reportesBO = reportesBO;
    }

    public List<Preguntas> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Preguntas> preguntas) {
        this.preguntas = preguntas;
    }

    public List<List<Integer>> getColumnas() {
        return columnas;
    }

    public void setColumnas(List<List<Integer>> columnas) {
        this.columnas = columnas;
    }

    public List<List<Integer>> getFilas() {
        return filas;
    }

    public void setFilas(List<List<Integer>> filas) {
        this.filas = filas;
    }
    
    @PostConstruct
    public void getAll() {
        dataModel = new DocentesDataModel(docentesBO.getAllFromEvaluacion());
    }

    public void mostrarReporte() {
        this.preguntas = reportesBO.getPreguntas(selectedDocente.getIdDocente());
        this.columnas = reportesBO.getColumnas(selectedDocente.getIdDocente());
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> reqMap = ec.getRequestMap();
        reqMap.put("preguntas", preguntas);
        reqMap.put("calificaciones", columnas);
        try {
            ec.redirect(ec.getRequestContextPath() + "/reporteFinal.jps");
            //this.filas = reportesBO.getFilas(selectedDocente.getIdDocente());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
