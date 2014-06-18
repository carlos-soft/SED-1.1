package jdbc.dao;

import java.util.List;
import persistencia.Grupos;

public interface IFaceGrupos {
    void insert(Grupos obj, String docente);
    List<Grupos> getAll();
}
