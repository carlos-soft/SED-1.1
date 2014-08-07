package jdbc.dao;

import java.util.ArrayList;
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

    public List<Object> validarAlumno(String control) {
        List<Object> l = new ArrayList<Object>();
        try {
            Alumnos a =  (Alumnos) getHibernateTemplate().find("from Alumnos where control='"+control+"'").get(0);
            if (a.isEvaluado()) {
                l.add("ya evaluado");
            } else {
                l.add("valido");
                l.add(a);
            }
        } catch (Exception e) {
            l.add("no existe");
        }
        return l;
    }
    
}
