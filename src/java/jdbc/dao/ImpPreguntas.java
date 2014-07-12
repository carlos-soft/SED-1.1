package jdbc.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Preguntas;
import persistencia.PreguntasJoinEvaluacion;

public class ImpPreguntas extends HibernateDaoSupport implements IFacePreguntas {

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

    public void insertPreguntasEvaluaciones() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        PreguntasJoinEvaluacion pe = new PreguntasJoinEvaluacion();
        int idPregunta = ((Integer) session.createQuery("select max(idPregunta) from Preguntas").iterate().next());
        int idEvaluacion = ((Integer) session.createQuery("select idEvaluacion from Evaluaciones where estado = 'activada'").iterate().next());
        pe.setIdPregunta(idPregunta);
        pe.setIdEvaluacion(idEvaluacion);
        getHibernateTemplate().save(pe);
        tx.commit();
        session.close();
    }

    public List<Preguntas> getAllFromPreguntaEvaluacion() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        List data = null;
        List<Preguntas> l = new ArrayList<>();
        try {
            Transaction tx = session.beginTransaction();
            int idEvaluacion = ((Integer) session.createQuery("select idEvaluacion from Evaluaciones where estado = 'activada'").iterate().next());
            String sql = "select p.* "
                    + "from preguntasJoinEvaluacion pe "
                    + "join preguntas p "
                    + "join evaluaciones e "
                    + "where pe.idPregunta = p.idPregunta and pe.idEvaluacion = e.idEvaluacion and pe.idEvaluacion = '" + idEvaluacion + "'";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            data = query.list();
            Preguntas p = null;
            for (Object object : data) {
                Map row = (Map) object;
                p = new Preguntas();
                p.setIdPregunta(Integer.parseInt(row.get("idPregunta").toString()));
                p.setDescripcion(row.get("descripcion").toString());
                p.setRespuestas(row.get("respuestas").toString());
                p.setBanco(row.get("banco").toString());
                l.add(p);
            }
            tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return l;
    }

    public void deleteOfPreguntaEvaluacion(Preguntas obj) {
        PreguntasJoinEvaluacion pe = new PreguntasJoinEvaluacion();
        pe.setIdPregunta(obj.getIdPregunta());
        getHibernateTemplate().delete(pe);
        if (!obj.getBanco().equals("s")) {
            getHibernateTemplate().delete(obj);
        }
    }

    public List<Preguntas> getAllFromBanco() {
        return getHibernateTemplate().find("from Preguntas where banco = 's'");
    }

    public void asignarFromBanc(List<Preguntas> p) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        int idEvaluacion = ((Integer) session.createQuery("select idEvaluacion from Evaluaciones where estado = 'activada'").iterate().next());
        tx.commit();
        session.close();
        for (Iterator<Preguntas> it = p.iterator(); it.hasNext();) {
            getHibernateTemplate().save(new PreguntasJoinEvaluacion(it.next().getIdPregunta(), idEvaluacion));
        }
    }

    public PreguntasJoinEvaluacion getFromPreguntasEvaluacion(List<Preguntas> p) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        int idEvaluacion = ((Integer) session.createQuery("select idEvaluacion from Evaluaciones where estado = 'activada'").iterate().next());
        try {
            PreguntasJoinEvaluacion pe = null;
            for (int i = 0; i < p.size(); i++) {
                pe = (PreguntasJoinEvaluacion) session.createQuery("from PreguntasJoinEvaluacion where idEvaluacion='" + idEvaluacion + "' and "
                        + "idPregunta='" + p.get(i).getIdPregunta() + "'").uniqueResult();
                if (pe == null) {
                    continue;
                } else {
                    return pe;
                }

            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
