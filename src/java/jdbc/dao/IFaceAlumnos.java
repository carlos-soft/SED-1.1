package jdbc.dao;

import java.util.List;
import persistencia.Alumnos;

public interface IFaceAlumnos {
    void insert(Alumnos obj, String grupo);
    List<Alumnos> getAll();
}
