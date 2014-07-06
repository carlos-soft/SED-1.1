package jsf.beans;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import persistencia.Preguntas;

public class PreguntasDataModel extends ListDataModel<Preguntas>
        implements SelectableDataModel<Preguntas> {

    public PreguntasDataModel() {
    }

    public PreguntasDataModel(List<Preguntas> lista) {
        super(lista);
    }

    public Preguntas getRowData(String rowKey) {
        List<Preguntas> pregunta = (List<Preguntas>) getWrappedData();

        for (Preguntas obj : pregunta) {
            if (obj.getIdPregunta().equals(rowKey)) {
                return obj;
            }
        }
        return null;
    }

    public Object getRowKey(Preguntas p) {
        return p.getIdPregunta();
    }
    
}
