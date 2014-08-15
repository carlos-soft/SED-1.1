package jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Preguntas;

public class ImpReportes extends HibernateDaoSupport implements IFaceReportes {

    public List<Preguntas> getPreguntas(int idDocente) {
        List data = null;
        List<Preguntas> l = new ArrayList<>();
        try {
            Session session = getHibernateTemplate().getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            String sql = "select idPregunta, descripcion from reporte where idDocente ='" + idDocente + "' group by descripcion";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            data = query.list();
            Preguntas p = null;
            for (Object object : data) {
                Map row = (Map) object;
                p = new Preguntas();
                p.setIdPregunta(Integer.parseInt(row.get("idPregunta").toString()));
                p.setDescripcion(row.get("descripcion").toString());
                l.add(p);
            }
            tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return l;
    }

    public List<List<Integer>> getColumnas(int idDocente) {
        List data = null;
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        try {
            Session session = getHibernateTemplate().getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            int idEvaluacion = ((Integer) session.createQuery("select idEvaluacion from Evaluaciones where estado = 'activada'").iterate().next());
            int salto = ((Integer) session.createQuery(
                    "select count(pe.idPregunta) as total from PreguntasJoinEvaluacion pe join Preguntas p " +
                    "where p.idPregunta = pe.idPregunta and pe.idEvaluacion = '"+idEvaluacion+"'").iterate().next());
            for (int i = 0; i < salto; i++) {
                l.add(new ArrayList<Integer>());
            }            
            String sql = "select answer from reporte where idDocente = '"+idDocente+"'";
            data = session.createSQLQuery(sql).list();
            int c = 0;
            for (int i = 0; i < l.size(); i++) {
                List<Integer> list = l.get(i);
                for (int j = c; j < data.size(); c++) {
                    list.add((Integer) data.get(j));
                    
                }
            }
            tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return l;
    }

}
