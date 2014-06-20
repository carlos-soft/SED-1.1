package bo;

import java.util.List;
import jsf.beans.SubirArchivoBean;
import persistencia.Grupos;
import persistencia.GruposJoinDocentes;

public interface GruposBO {
    void insert(SubirArchivoBean obj);
    List<GruposJoinDocentes> getAll();
    void delete(Grupos obj);
}
