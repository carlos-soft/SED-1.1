package bo;

import java.util.List;
import jdbc.dao.ImpGrupos;
import jsf.beans.SubirArchivoBean;
import persistencia.Grupos;
import persistencia.GruposJoinDocentes;

public class GruposImpBO implements GruposBO{

    private ImpGrupos gruposDAO;
    
    public ImpGrupos getGruposDAO() {
        return gruposDAO;
    }

    public void setGruposDAO(ImpGrupos gruposDAO) {
        this.gruposDAO = gruposDAO;
    }
    
    public void insert(SubirArchivoBean obj) {
        Grupos g = new Grupos();
        g.setNivel(Integer.parseInt(obj.getNivel()));
        g.setNombre(obj.getMateria());
        gruposDAO.insert(g, obj.getProfesor()); 
    }
    
    public List<GruposJoinDocentes> getAll() {
        return gruposDAO.getAll();
    }

    
    public void delete(GruposJoinDocentes obj) {
        gruposDAO.delete(obj);
    }

}
