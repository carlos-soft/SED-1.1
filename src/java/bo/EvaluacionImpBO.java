package bo;

import java.util.List;
import jdbc.dao.ImpEvaluacion;
import jsf.beans.EvaluacionBean;
import persistencia.Evaluaciones;

public class EvaluacionImpBO implements EvaluacionBO{
    
    private ImpEvaluacion evaluacionDAO;

    public ImpEvaluacion getEvaluacionDAO() {
        return evaluacionDAO;
    }

    public void setEvaluacionDAO(ImpEvaluacion evaluacionDAO) {
        this.evaluacionDAO = evaluacionDAO;
    }
    
    public void insert(EvaluacionBean obj) {
        Evaluaciones evaluacion = new Evaluaciones();
        evaluacion.setFechaInicio(obj.getFechaInicio());
        evaluacion.setFechaFin(obj.getFechaFin());
        evaluacion.setYear(obj.getYear());
        evaluacion.setLenguaje(obj.getLenguaje());
        evaluacion.setEstado("activada");
        evaluacionDAO.insert(evaluacion);
    }
    
    public void delete(Evaluaciones obj) {
        evaluacionDAO.delete(obj);
    }
    
    public void update(Evaluaciones obj) {
        evaluacionDAO.update(obj);
    }
  
    public List<Evaluaciones> getAll() {
        return evaluacionDAO.getAll();
    }

    public List<Evaluaciones> getEvaluacionActiva() {
        return evaluacionDAO.getEvaluacionActiva();
    }
    

}
