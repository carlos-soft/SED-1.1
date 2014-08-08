package jdbc.dao;

import java.util.List;
import persistencia.Preguntas;
import persistencia.Registros;

public interface IFaceRegistros {
    void insert(Registros obj);
    void insertResultados(int idAlumno, List<Preguntas> preguntas);
}
