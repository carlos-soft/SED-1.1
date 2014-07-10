package jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Preguntas;
import persistencia.PreguntasJoinEvaluacion;

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

    
    public void insertPreguntasEvaluaciones() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        PreguntasJoinEvaluacion pe = new PreguntasJoinEvaluacion();
        int idPregunta  = ((Integer) session.createQuery("select max(idPregunta) from Preguntas").iterate().next()); 
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
                    + "where pe.idPregunta = p.idPregunta and pe.idEvaluacion = e.idEvaluacion and pe.idEvaluacion = '"+idEvaluacion+"'";
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
        getHibernateTemplate().delete(obj);
        PreguntasJoinEvaluacion pe = new PreguntasJoinEvaluacion();
        pe.setIdPregunta(obj.getIdPregunta());
        getHibernateTemplate().delete(pe);
    }

}