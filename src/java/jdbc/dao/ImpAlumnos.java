package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Alumnos;

public class ImpAlumnos extends HibernateDaoSupport implements IFaceAlumnos{

    
    public void insert(Alumnos obj, String grupo) {
        getHibernateTemplate().save(obj);
    }

    
    public List<Alumnos> getAll() {
        return null;
    }
    
}
