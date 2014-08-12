package jsf.beans;

import bo.DocentesImpBO;
import javax.annotation.PostConstruct;
import persistencia.Docentes;

public class ReportesDocentesBean {
    
    private DocentesDataModel dataModel;
    private Docentes selectedDocente;
    private DocentesImpBO docentesBO;
    
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
    
    @PostConstruct
    public void getAll(){
        dataModel = new DocentesDataModel(docentesBO.getAllFromEvaluacion());
    }
}
