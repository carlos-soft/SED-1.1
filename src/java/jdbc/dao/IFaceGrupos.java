package jdbc.dao;

import java.util.List;
import persistencia.Evaluaciones;
import persistencia.Grupos;
import persistencia.GruposJoinDocentes;

public interface IFaceGrupos {
    void insert(Grupos obj, String docente);
    List<GruposJoinDocentes> getAllGroupsFromEvaluacion(Evaluaciones e);
    public void delete(GruposJoinDocentes obj);
}
