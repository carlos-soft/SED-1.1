package jdbc.dao;

import java.util.List;
import persistencia.Preguntas;

public interface IFacePreguntas {

    public void insert(Preguntas obj);
    
    public void insertPreguntasEvaluaciones();

    public void delete(Preguntas obj);
    
    public void deleteOfPreguntaEvaluacion(Preguntas obj);

    public void update(Preguntas obj);

    public List<Preguntas> getAll();
    
    public List<Preguntas> getAllFromPreguntaEvaluacion();
    
    public List<Preguntas> getAllFromBanco();
    
    public void asignarFromBanc(List<Preguntas> p);
}
