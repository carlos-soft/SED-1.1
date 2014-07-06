package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Preguntas;

public class ImpPreguntas extends HibernateDaoSupport implements IFacePreguntas{

    public void insert(Preguntas obj) {
        getHibernateTemplate().save(obj);
    }

    public List<Preguntas> getAll() {
        return getHibernateTemplate().find("from Preguntas");
    }

    public void delete(Preguntas obj) {
        getHibernateTemplate().delete(obj);
    }

    
    public void update(Preguntas obj) {
        getHibernateTemplate().merge(obj);
    }
    
}
