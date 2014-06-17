package jdbc.dao;

import java.util.List;
import persistencia.Evaluaciones;

public interface IFaceEvaluacion {
    void insert(Evaluaciones obj);
    List<Evaluaciones> getAll();
    void delete(Evaluaciones obj);
    void update(Evaluaciones obj);
    List<Evaluaciones> getEvaluacionActiva();
}
