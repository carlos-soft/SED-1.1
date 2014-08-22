package bo;

import java.util.List;
import jdbc.dao.ImpReportes;
import persistencia.Preguntas;

public class ReportesImpBO implements ReportesBO{
    
    private ImpReportes reportesDAO;

    public ImpReportes getReportesDAO() {
        return reportesDAO;
    }

    public void setReportesDAO(ImpReportes reportesDAO) {
        this.reportesDAO = reportesDAO;
    }

    public List<Preguntas> getPreguntas(int idDocente) {
        return reportesDAO.getPreguntas(idDocente);
    }

    public List<List<Integer>> getColumnas(int idDocente) {
        return reportesDAO.getColumnas(idDocente);
    }    

    public List<String> getComentarios(int idDocente) {
        return reportesDAO.getComentarios(idDocente);
    }
}
