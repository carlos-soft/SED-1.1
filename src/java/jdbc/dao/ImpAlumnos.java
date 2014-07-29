package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Alumnos;
import persistencia.Grupos;

public class ImpAlumnos extends HibernateDaoSupport implements IFaceAlumnos{

    
    public void insert(Alumnos obj, String grupo) {
        getHibernateTemplate().save(obj);
    }

    
    public List<Alumnos> getAll() {
        return null;
    }

    
    public List<Alumnos> getAlumnosFromGroupId(Grupos g) {
        return getHibernateTemplate().find("from Alumnos where idEvaluacion='"+g.getIdEvaluacion()+
                "' and idGrupo='"+g.getIdGrupo()+"'");
    }

    @Override
    public boolean isEvaluado(String control) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
