package jdbc.dao;

import java.util.List;
import persistencia.Preguntas;
import persistencia.PreguntasJoinEvaluacion;

public interface IFacePreguntas {

    public void insert(Preguntas obj);
    
    public void insertPreguntasEvaluaciones();

    public void delete(Preguntas obj);
    
    public void deleteOfPreguntaEvaluacion(Preguntas obj);

    public void update(Preguntas obj);

    public List<Preguntas> getAll();
    
    public List<Preguntas> getAllFromPreguntaEvaluacion();
    
    public List<Preguntas> getAllFromBanco();
    
    public PreguntasJoinEvaluacion getFromPreguntasEvaluacion(List<Preguntas> p);
    
    public void asignarFromBanc(List<Preguntas> p);
    
    public void cambiarBanco(int idPregunta);
}
