package jsf.beans;

import bo.DocentesImpBO;
import bo.ReportesImpBO;
import java.util.List;
import javax.annotation.PostConstruct;
import persistencia.Docentes;
import persistencia.Preguntas;

public class ReportesDocentesBean {

    private DocentesDataModel dataModel;
    private Docentes selectedDocente;
    private DocentesImpBO docentesBO;
    private ReportesImpBO reportesBO;
    private List<Preguntas> preguntas;
    private List<List<Integer>> columnas;

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

    @PostConstruct
    public void getAll() {
        dataModel = new DocentesDataModel(docentesBO.getAllFromEvaluacion());
    }

    public void mostrarReporte() {
        this.preguntas = reportesBO.getPreguntas(selectedDocente.getIdDocente());
        this.columnas = reportesBO.getColumnas(selectedDocente.getIdDocente());
    }
}
