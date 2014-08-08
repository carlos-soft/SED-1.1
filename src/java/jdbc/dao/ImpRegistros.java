package jdbc.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import persistencia.Preguntas;
import persistencia.Registros;
import persistencia.Resultados;

public class ImpRegistros extends HibernateDaoSupport implements IFaceRegistros {

    public void insert(Registros obj) {
        getHibernateTemplate().save(obj);
    }

    public void insertResultados(int idAlumno, List<Preguntas> preguntas) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        int idRegistro = ((Integer) session.createQuery("select idRegistro from Registros where idAlumno ='" + idAlumno + "'")
                .iterate().next());
        Resultados r = null;
        for (Preguntas p : preguntas) {
            r = new Resultados();
            r.setIdRegistro(idRegistro);
            r.setIdPregunta(p.getIdPregunta());
            if (p.getRespuestas().equals("desorden")) {
                switch (p.getAnswer()) {
                    case "siempre":
                        r.setAnswer("6");
                        break;
                    case "casi siempre":
                        r.setAnswer("7");
                        break;
                    case "algunas veces":
                        r.setAnswer("8");
                        break;
                    case "rara vez":
                        r.setAnswer("9");
                        break;
                    case "nunca":
                        r.setAnswer("10");
                        break;
                }
            } else {
                switch (p.getAnswer()) {
                    case "siempre":
                        r.setAnswer("10");
                        break;
                    case "casi siempre":
                        r.setAnswer("9");
                        break;
                    case "algunas veces":
                        r.setAnswer("8");
                        break;
                    case "rara vez":
                        r.setAnswer("7");
                        break;
                    case "nunca":
                        r.setAnswer("6");
                        break;
                }
            }
            getHibernateTemplate().save(r);
        }
    }

}
