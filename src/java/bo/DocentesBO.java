package bo;

import java.util.List;
import jsf.beans.SubirArchivoBean;
import persistencia.Docentes;

public interface DocentesBO {
    void insert(SubirArchivoBean obj);
    List<Docentes> getAll();
    List<Docentes> getAllFromEvaluacion();
    Docentes getFromAlumno(int idGrupo);
    String getGroupName(int idDocente);
    String getEvaluacionActiva();
}
