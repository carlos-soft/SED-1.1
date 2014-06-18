package bo;

import java.util.List;
import jsf.beans.SubirArchivoBean;
import persistencia.Docentes;

public interface DocentesBO {
    void insert(SubirArchivoBean obj);
    List<Docentes> getAll();
}
