package jsf.beans;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import persistencia.GruposJoinDocentes;

public class GruposDataModel extends ListDataModel<GruposJoinDocentes>
        implements SelectableDataModel<GruposJoinDocentes>{

    public GruposDataModel() {
    }

    public GruposDataModel(List<GruposJoinDocentes> lista){
        super(lista);
    }
    
    public Object getRowKey(GruposJoinDocentes t) {
        return t.getIdGrupo();
    }

    
    public GruposJoinDocentes getRowData(String rowKey) {
        List<GruposJoinDocentes> grupo = (List<GruposJoinDocentes>) getWrappedData();

        for (GruposJoinDocentes obj : grupo) {
            if (obj.getIdGrupo().equals(rowKey)) {
                return obj;
            }
        }
        return null;
    }

}
