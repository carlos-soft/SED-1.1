package bo;

import java.util.List;
import jdbc.dao.ImpAlumnos;
import jsf.beans.SubirArchivoBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import persistencia.Alumnos;
import persistencia.Evaluaciones;
import persistencia.Grupos;
import persistencia.GruposJoinDocentes;

public class AlumnosImpBO implements AlumnosBO {

    private ImpAlumnos alumnosDAO;

    public ImpAlumnos getAlumnosDAO() {
        return alumnosDAO;
    }

    public void setAlumnosDAO(ImpAlumnos alumnosDAO) {
        this.alumnosDAO = alumnosDAO;
    }

    public void insert(SubirArchivoBean obj) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Evaluaciones evaluacion = (Evaluaciones) session.createQuery("from Evaluaciones where estado='activada'").list().get(0);
        Grupos grupo = (Grupos) session.createQuery("from Grupos where nombre='" + obj.getMateria() + "' and idEvaluacion='" + evaluacion.getIdEvaluacion() + "'").list().get(0);
        tx.commit();
        session.close();
        Alumnos a = null;
        for (int i = 0; i < obj.getNombres().size(); i++) {
            a = new Alumnos();
            a.setControl(obj.getClaves().get(i));
            a.setNombre(obj.getNombres().get(i));
            a.setIdEvaluacion(evaluacion.getIdEvaluacion()); 
            a.setIdGrupo(grupo.getIdGrupo()); 
            a.setEvaluado(false); 
            alumnosDAO.insert(a, obj.getMateria());
        }
    }

    public List<Alumnos> getAll() {
        return null;
    }

    public List<Alumnos> getAlumnosFromGroupId(GruposJoinDocentes obj) {
        Grupos g = new Grupos();
        g.setIdGrupo(obj.getIdGrupo());
        g.setIdEvaluacion(obj.getIdEvaluacion());
        return alumnosDAO.getAlumnosFromGroupId(g);
    }

    public String validarAlumno(String control) {
        return alumnosDAO.validarAlumno(control);
    }

}
