package bo;

import java.util.List;
import jsf.beans.SubirArchivoBean;
import persistencia.Alumnos;
import persistencia.GruposJoinDocentes;

public interface AlumnosBO {
    void insert(SubirArchivoBean obj);
    List<Alumnos> getAll();
    List<Alumnos> getAlumnosFromGroupId(GruposJoinDocentes obj);
    List<Object> validarAlumno(String control);
}
