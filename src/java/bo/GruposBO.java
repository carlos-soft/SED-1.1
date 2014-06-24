package bo;

import java.util.List;
import jsf.beans.SubirArchivoBean;
import persistencia.Evaluaciones;
import persistencia.GruposJoinDocentes;

public interface GruposBO {
    void insert(SubirArchivoBean obj);
    List<GruposJoinDocentes> getAllGroupsFromEvaluacion(Evaluaciones e);
    void delete(GruposJoinDocentes obj);
}
