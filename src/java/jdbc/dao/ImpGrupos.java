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
import persistencia.Evaluaciones;
import persistencia.Grupos;
import persistencia.GruposJoinDocentes;

public class ImpGrupos extends HibernateDaoSupport implements IFaceGrupos {

    public void insert(Grupos obj, String docente) {
        Evaluaciones e = (Evaluaciones) getHibernateTemplate().find("from Evaluaciones where estado='activada'").get(0);
        obj.setIdEvaluacion(e.getIdEvaluacion());
        Docentes d = (Docentes) getHibernateTemplate().find("from Docentes where nombre='" + docente + "'").get(0);
        obj.setIdDocente(d.getIdDocente());
        getHibernateTemplate().save(obj);
    }

    public List<GruposJoinDocentes> getAllGroupsFromEvaluacion(Evaluaciones ev) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        List data = null;
        List<GruposJoinDocentes> l = new ArrayList<GruposJoinDocentes>();
        try {
            Transaction tx = session.beginTransaction();
            String sql = "SELECT g.idGrupo, g.nombre as grupo, d.idDocente, d.nombre as docente, g.nivel, g.idEvaluacion, "
                    + "(select count(*) from Alumnos where idGrupo = g.idGrupo) as totalAlumnos,  "
                    + "(select count(*) from Alumnos where idGrupo = g.idGrupo and evaluado=1) as totalEvaluados "
                    + "FROM Evaluaciones e JOIN Grupos g JOIN Docentes d Join Alumnos a "
                    + "where g.idDocente = d.idDocente and a.idGrupo = g.idGrupo and g.idEvaluacion = '"+ev.getIdEvaluacion()+"' "
                    + "group by g.idDocente";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            data = query.list();
            GruposJoinDocentes g = null;
            for (Object object : data) {
                Map row = (Map) object;
                g = new GruposJoinDocentes();
                g.setIdGrupo(Integer.parseInt(row.get("idGrupo").toString()));
                g.setNombre(row.get("grupo").toString());
                g.setDocente(row.get("docente").toString());
                g.setIdDocente(Integer.parseInt(row.get("idDocente").toString()));
                g.setNivel(Integer.parseInt(row.get("nivel").toString()));
                g.setIdEvaluacion(Integer.parseInt(row.get("idEvaluacion").toString()));
                g.setTotalAlumnos(Integer.parseInt(row.get("totalAlumnos").toString()));  
                g.setTotalEvaluados(Integer.parseInt(row.get("totalEvaluados").toString())); 
                l.add(g);
            }
            tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return l;
    }

    public void delete(GruposJoinDocentes obj) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hqlUpdate = "delete Grupos where idGrupo = :idGrupo";
        int updated = session.createQuery(hqlUpdate)
                .setInteger("idGrupo", obj.getIdGrupo())
                .executeUpdate();
        tx.commit();
        session.close();
    }

}
