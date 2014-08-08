package bo;

import jdbc.dao.ImpRegistros;
import jsf.beans.AplicarEvaluacionBean;
import persistencia.Registros;

public class RegistrosImpBO implements RegistrosBO {

    private ImpRegistros registrosDAO;

    public ImpRegistros getRegistrosDAO() {
        return registrosDAO;
    }

    public void setRegistrosDAO(ImpRegistros registrosDAO) {
        this.registrosDAO = registrosDAO;
    }
    
    public void insert(AplicarEvaluacionBean obj) {
        Registros r = new Registros();
        r.setComentario(obj.getComentario());
        r.setIdAlumno(obj.getA().getIdAlumno());
        registrosDAO.insert(r);
        registrosDAO.insertResultados(obj.getA().getIdAlumno(), obj.getPreguntas());
    }

}
