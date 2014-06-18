package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Docentes;

public class ImpDocentes extends HibernateDaoSupport implements IFaceDocentes{

    
    public void insert(Docentes obj) {
        getHibernateTemplate().save(obj);
    }

    
    public List<Docentes> getAll() {
        return null;
    }
    
}
