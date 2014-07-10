package bo;

import java.util.List;
import jdbc.dao.ImpPreguntas;
import jsf.beans.AsignarPreguntasBean;
import jsf.beans.PreguntasBean;
import persistencia.Preguntas;

public class PreguntasImpBO implements PreguntasBO{
    
    private ImpPreguntas preguntasDAO;

    public ImpPreguntas getPreguntasDAO() {
        return preguntasDAO;
    }

    public void setPreguntasDAO(ImpPreguntas preguntasDAO) {
        this.preguntasDAO = preguntasDAO;
    }
    
    public void insert(PreguntasBean obj) {
        Preguntas p = new Preguntas();
        p.setDescripcion(obj.getDescricion());
        p.setRespuestas(obj.getRespuestas());
        p.setBanco("s");
        preguntasDAO.insert(p);
    }
    
    public void insert(AsignarPreguntasBean obj) {
        Preguntas p = new Preguntas();
        p.setDescripcion(obj.getDescricion());
        p.setRespuestas(obj.getRespuestas());
        p.setBanco("n");
        preguntasDAO.insert(p);
        preguntasDAO.insertPreguntasEvaluaciones();
    }

    public List<Preguntas> getAll() {
        return preguntasDAO.getAll();
    }

    public void delete(Preguntas obj) {
        preguntasDAO.delete(obj);
    }

    public void update(Preguntas obj) {
        preguntasDAO.update(obj);
    }

    
    public List<Preguntas> getAllFromPreguntaEvaluacion() {
        return preguntasDAO.getAllFromPreguntaEvaluacion();
    }

    public void deleteOfPreguntaEvaluacion(Preguntas obj) {
        preguntasDAO.deleteOfPreguntaEvaluacion(obj);
    }
}
