package jdbc.dao;

import java.util.List;
import persistencia.Grupos;
import persistencia.GruposJoinDocentes;

public interface IFaceGrupos {
    void insert(Grupos obj, String docente);
    List<GruposJoinDocentes> getAll();
    public void delete(Grupos obj);
}
