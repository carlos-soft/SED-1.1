package jdbc.dao;

import java.util.List;
import persistencia.Docentes;

public interface IFaceDocentes {

    void insert(Docentes obj);
    List<Docentes> getAll();
}
