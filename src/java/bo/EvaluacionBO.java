package bo;

import java.util.List;
import jsf.beans.EvaluacionBean;
import persistencia.Evaluaciones;

public interface EvaluacionBO {
    void insert(EvaluacionBean obj);
    List<Evaluaciones> getAll();
    
}
