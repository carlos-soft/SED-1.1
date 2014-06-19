package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Docentes;
import persistencia.Evaluaciones;
import persistencia.Grupos;

public class ImpGrupos extends HibernateDaoSupport implements IFaceGrupos{

    
    public void insert(Grupos obj, String docente) {
        Evaluaciones e = (Evaluaciones) getHibernateTemplate().find("from Evaluaciones where estado='activada'").get(0);
        obj.setIdEvaluacion(e.getIdEvaluacion());
        Docentes d = (Docentes) getHibernateTemplate().find("from Docentes where nombre='"+docente+"'").get(0);
        System.out.println(d.getIdDocente());
        obj.setIdDocente(d.getIdDocente());
        getHibernateTemplate().save(obj);
    }

    
    public List<Grupos> getAll() {
        return null;
    }


}
