package bo;

import java.util.List;
import jsf.beans.SubirArchivoBean;
import persistencia.Docentes;

public interface GruposBO {
    void insert(SubirArchivoBean obj);
    List<Docentes> getAll();
}
