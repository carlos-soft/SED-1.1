package jdbc.dao;

import java.util.List;
import persistencia.Docentes;

public interface IFaceDocentes {

    void insert(Docentes obj);
    List<Docentes> getAll();
    List<Docentes> getAllFromEvaluacion();
    Docentes getFromAlumno(int idGrupo);
}
