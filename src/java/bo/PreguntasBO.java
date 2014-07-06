package bo;

import java.util.List;
import jsf.beans.PreguntasBean;
import persistencia.Preguntas;

public interface PreguntasBO {

    public void insert(PreguntasBean obj);

    public void delete(Preguntas obj);

    public void update(Preguntas obj);

    public List<Preguntas> getAll();

}
