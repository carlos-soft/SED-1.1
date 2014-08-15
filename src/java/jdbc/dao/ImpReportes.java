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
        List<Integer> data2 = null;
        List<Integer> data3 = null;
        List<List<Integer>> l = new ArrayList<>();
        try {
            Session session = getHibernateTemplate().getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            int idEvaluacion = ((Integer) session.createQuery("select idEvaluacion from Evaluaciones where estado = 'activada'").iterate().next());
            String sql = "select count(distinct alumno) as total "
                    + "from reporte "
                    + "where idDocente = '" + idDocente + "'";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            data = query.list();
            int salto = 0;
            for (Object object : data) {
                Map row = (Map) object;
                salto = Integer.parseInt(row.get("total").toString());
            }
            for (int i = 0; i < salto; i++) {
                l.add(new ArrayList<Integer>());
            }
            System.out.println("alumnos = "+salto);
            System.out.println(idEvaluacion);
            String sql2 = "select count(pe.idPregunta) as pregun "
                    + "from PreguntasJoinEvaluacion pe join Preguntas p "
                    + "where p.idPregunta = pe.idPregunta and pe.idEvaluacion = '"+idEvaluacion+"'";
            
            SQLQuery query2 = session.createSQLQuery(sql2);
            query2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            data2 = query2.list();
            int preguntas = 0;
            for (Object object : data2) {
                Map row = (Map) object;
                preguntas = Integer.parseInt(row.get("pregun").toString());
            }
            String sql3 = "select answer from reporte where idDocente = '" + idDocente + "'";
            data3 = session.createSQLQuery(sql3).list();
            System.out.println(data3);
            int c = 0;
            for (List<Integer> l1 : l) {
                for (int j = 0; j < preguntas ; j++, c++) {
                    l1.add(data3.get(c));
                }
            }
            System.out.println(l);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return l;
    }

}
