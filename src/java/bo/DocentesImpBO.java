package bo;

import java.util.List;
import jdbc.dao.ImpDocentes;
import jsf.beans.SubirArchivoBean;
import persistencia.Docentes;

public class DocentesImpBO implements DocentesBO {

    private ImpDocentes docentesDAO;

    public ImpDocentes getDocentesDAO() {
        return docentesDAO;
    }

    public void setDocentesDAO(ImpDocentes docentesDAO) {
        this.docentesDAO = docentesDAO;
    }

    public void insert(SubirArchivoBean obj) {
        Docentes d = new Docentes();
        d.setNombre(obj.getProfesor());
        docentesDAO.insert(d);
    }

    public List<Docentes> getAll() {
        return null;
    }

    public Docentes getFromAlumno(int idGrupo) {
        return docentesDAO.getFromAlumno(idGrupo);
    }

    public List<Docentes> getAllFromEvaluacion() {
        return docentesDAO.getAllFromEvaluacion();
    }

    public String getGroupName(int idDocente) {
        return docentesDAO.getGroupName(idDocente);
    }

    @Override
    public String getEvaluacionActiva() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
