package jdbc.dao;

import java.util.List;
import persistencia.Preguntas;

public interface IFaceReportes {
    public List<Preguntas> getPreguntas(int idDocente);
    public List<List<Integer>> getColumnas(int idDocente);
    public List<String> getComentarios(int idDocente);  
}
