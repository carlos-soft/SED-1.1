package jsf.beans;

import bo.DocentesImpBO;
import bo.ReportesImpBO;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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
    
    @PostConstruct
    public void getAll() {
        dataModel = new DocentesDataModel(docentesBO.getAllFromEvaluacion());
    }

    public void mostrarReporte() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> reqMap = ec.getSessionMap();
        reqMap.put("preguntas", reportesBO.getPreguntas(selectedDocente.getIdDocente()));
        reqMap.put("calificaciones", reportesBO.getColumnas(selectedDocente.getIdDocente()));
        reqMap.put("comentarios", reportesBO.getComentarios(selectedDocente.getIdDocente()));
        try {
            ec.redirect(ec.getRequestContextPath() + "/admin/reporteFinal.jsp");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
