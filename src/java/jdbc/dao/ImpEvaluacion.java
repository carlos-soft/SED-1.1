package jdbc.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Evaluaciones;

public class ImpEvaluacion extends HibernateDaoSupport implements IFaceEvaluacion {

    public void insert(Evaluaciones obj) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hqlUpdate = "update Evaluaciones set estado = :newEstado where estado = :oldEstado";
        int updated = session.createQuery(hqlUpdate)
                .setString("newEstado", "desactivada")
                .setString("oldEstado", "activada")
                .executeUpdate();
        tx.commit();
        session.close();
        getHibernateTemplate().save(obj);
    }

    public void delete(Evaluaciones obj) {
        getHibernateTemplate().delete(obj);
    }

    public void update(Evaluaciones obj) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hqlUpdate = "update Evaluaciones set estado = :newEstado where estado = :oldEstado";
        int updated = session.createQuery(hqlUpdate)
                .setString("newEstado", "desactivada")
                .setString("oldEstado", "activada")
                .executeUpdate();
        String hqlUpdate2 = "update Evaluaciones set estado = :newEstado where idEvaluacion = :idObj";
        int updated2 = session.createQuery(hqlUpdate2)
                .setString("newEstado", "activada")
                .setInteger("idObj", obj.getIdEvaluacion())
                .executeUpdate();
        tx.commit();
        session.close();
    }

    public List<Evaluaciones> getAll() {
        return getHibernateTemplate().find("from Evaluaciones");
    }

    public List<Evaluaciones> getEvaluacionActiva() {
        return getHibernateTemplate().find("from Evaluaciones where estado='activada'");
    }

    public Map<String, Integer> getAllForAList() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        List data = null;
        Map<String, Integer> m = new LinkedHashMap<String, Integer>();
        try {
            Transaction tx = session.beginTransaction();
            String sql = "SELECT idEvaluacion, concat(e.lenguaje,': ',fechaInicio,'/',fechaFin,' - ',year) as nombre from Evaluaciones e";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            data = query.list();
            for (Object object : data) {
                Map row = (Map) object;
                m.put(row.get("nombre").toString(), ((Integer) row.get("idEvaluacion")).intValue());                
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

}
