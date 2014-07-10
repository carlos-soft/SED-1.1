package bo;

import java.util.List;
import jsf.beans.AsignarPreguntasBean;
import jsf.beans.PreguntasBean;
import persistencia.Preguntas;

public interface PreguntasBO {

    public void insert(PreguntasBean obj);
    
    public void insert(AsignarPreguntasBean obj);
    
    public void delete(Preguntas obj);
    
    public void deleteOfPreguntaEvaluacion(Preguntas obj);

    public void update(Preguntas obj);

    public List<Preguntas> getAll();
    
    public List<Preguntas> getAllFromPreguntaEvaluacion();

}
