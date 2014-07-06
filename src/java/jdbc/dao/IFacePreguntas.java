package jdbc.dao;

import java.util.List;
import persistencia.Preguntas;

public interface IFacePreguntas {

    public void insert(Preguntas obj);

    public void delete(Preguntas obj);

    public void update(Preguntas obj);

    public List<Preguntas> getAll();
}
