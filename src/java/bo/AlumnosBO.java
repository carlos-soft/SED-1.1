package bo;

import java.util.List;
import jsf.beans.SubirArchivoBean;
import persistencia.Alumnos;

public interface AlumnosBO {
    void insert(SubirArchivoBean obj);
    List<Alumnos> getAll();
}
