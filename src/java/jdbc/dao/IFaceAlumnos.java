package jdbc.dao;

import java.util.List;
import persistencia.Alumnos;
import persistencia.Grupos;

public interface IFaceAlumnos {
    void insert(Alumnos obj, String grupo);
    List<Alumnos> getAll();
    List<Alumnos> getAlumnosFromGroupId(Grupos g);
    String validarAlumno(String control);
}
