package jsf.beans;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import persistencia.Evaluaciones;

public class EvaluacionesDataModel extends ListDataModel<Evaluaciones>
        implements SelectableDataModel<Evaluaciones> {

    public EvaluacionesDataModel() {
    }

    public EvaluacionesDataModel(List<Evaluaciones> lista) {
        super(lista);
    }

    public Evaluaciones getRowData(String rowKey) {
        List<Evaluaciones> evaluacion = (List<Evaluaciones>) getWrappedData();

        for (Evaluaciones obj : evaluacion) {
            if (obj.getIdEvaluacion().equals(rowKey)) {
                return obj;
            }
        }
        return null;
    }

    public Object getRowKey(Evaluaciones e) {
        return e.getIdEvaluacion();
    }

}
