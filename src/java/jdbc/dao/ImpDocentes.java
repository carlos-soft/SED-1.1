package jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Docentes;
import persistencia.GruposJoinDocentes;

public class ImpDocentes extends HibernateDaoSupport implements IFaceDocentes {

    public void insert(Docentes obj) {
        getHibernateTemplate().save(obj);
    }

    public List<Docentes> getAll() {
        return null;
    }

    public Docentes getFromAlumno(int idGrupo) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        List data = null;
        Docentes d = new Docentes();
        try {
            Transaction tx = session.beginTransaction();
            String sql = "select d.* "
                    + "from docentes d "
                    + "join grupos g "
                    + "where g.idDocente = d.idDocente and g.idGrupo = '" + idGrupo + "'";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            data = query.list();
            for (Object object : data) {
                Map row = (Map) object;
                d.setIdDocente(Integer.parseInt(row.get("idDocente").toString()));
                d.setNombre(row.get("nombre").toString());
            }
            tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return d;
    }

}
