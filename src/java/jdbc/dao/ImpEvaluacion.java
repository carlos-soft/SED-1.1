package jdbc.dao;

import java.util.List;
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

}
