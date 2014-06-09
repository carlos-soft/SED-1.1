package bo;

import java.util.List;
import jsf.beans.EvaluacionBean;

public interface EvaluacionBO {
    void insert(EvaluacionBean obj);
    List<EvaluacionBean> getAll();
    
}
