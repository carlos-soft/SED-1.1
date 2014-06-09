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
        evaluacion.setNombre(obj.getLenguaje()+" "+obj.getFechaInicio()+"-"+obj.getFechaFin()+" "+obj.getYear());
        evaluacionDAO.insert(evaluacion);
    }

  
    public List<EvaluacionBean> getAll() {
        return null;
    }
    
}
