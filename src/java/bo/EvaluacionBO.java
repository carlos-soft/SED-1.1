package bo;

import java.util.List;
import java.util.Map;
import jsf.beans.EvaluacionBean;
import persistencia.Evaluaciones;

public interface EvaluacionBO {
    void insert(EvaluacionBean obj);
    List<Evaluaciones> getAll();
    Map<String, Integer> getAllForAList();
    void delete(Evaluaciones obj);
    void update(Evaluaciones obj);
    List<Evaluaciones> getEvaluacionActiva();
}
