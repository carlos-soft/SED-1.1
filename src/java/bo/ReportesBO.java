package bo;

import java.util.List;
import persistencia.Preguntas;

public interface ReportesBO {
    public List<Preguntas> getPreguntas(int idDocente); 
    public List<List<Integer>> getColumnas(int idDocente); 
    public List<List<Integer>> getFilas(int idDocente); 
}
