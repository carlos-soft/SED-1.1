package jsf.beans;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import persistencia.Docentes;

public class DocentesDataModel extends ListDataModel<Docentes>
        implements SelectableDataModel<Docentes> {
    
    public DocentesDataModel() {
    }

    public DocentesDataModel(List<Docentes> lista) {
        super(lista);
    }

    public Object getRowKey(Docentes d) {
        return d.getIdDocente();
    }

    public Docentes getRowData(String rowKey) {
        List<Docentes> pregunta = (List<Docentes>) getWrappedData();

        for (Docentes obj : pregunta) {
            if (obj.getIdDocente().equals(rowKey)) {
                return obj;
            }
        }
        return null;
    }
}
