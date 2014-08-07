package bo;

import java.util.List;
import jdbc.dao.ImpDocentes;
import jsf.beans.SubirArchivoBean;
import persistencia.Docentes;

public class DocentesImpBO implements DocentesBO{
    
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
    
}
