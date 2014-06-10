package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Evaluaciones;

public class ImpEvaluacion extends HibernateDaoSupport implements IFaceEvaluacion{

    
    public void insert(Evaluaciones obj) {
        getHibernateTemplate().save(obj);
    }

    
    public List<Evaluaciones> getAll() {
        return getHibernateTemplate().find("from Evaluaciones");
    }
    
}
