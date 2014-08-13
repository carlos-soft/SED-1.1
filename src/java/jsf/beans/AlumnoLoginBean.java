package jsf.beans;

import bo.AlumnosImpBO;
import bo.EvaluacionImpBO;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import persistencia.Evaluaciones;

public class AlumnoLoginBean {

    private Evaluaciones activa;
    private EvaluacionImpBO evaluacionBO;
    private String mensage;
    private String control;
    private AlumnosImpBO alumnosBO;

    public AlumnoLoginBean() {
    }

    public Evaluaciones getActiva() {
        return activa;
    }

    public void setActiva(Evaluaciones activa) {
        this.activa = activa;
    }

    public EvaluacionImpBO getEvaluacionBO() {
        return evaluacionBO;
    }

    public void setEvaluacionBO(EvaluacionImpBO evaluacionBO) {
        this.evaluacionBO = evaluacionBO;
    }

    public String getMensage() {
        return mensage;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public AlumnosImpBO getAlumnosBO() {
        return alumnosBO;
    }

    public void setAlumnosBO(AlumnosImpBO alumnosBO) {
        this.alumnosBO = alumnosBO;
    }
    
    @PostConstruct
    public void printLink() {
        activa = evaluacionBO.getEvaluacionActiva().get(0);
        mensage = activa.getLenguaje() + ": " + activa.getFechaInicio() + "-" + activa.getFechaFin() + ".";
    }

    public void aplicar(){
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/evaluacion.xhtml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void validar() {
        List<Object> l = alumnosBO.validarAlumno(control);
        String dir = "";
        try {
            switch(l.get(0).toString()){
                case "no existe":
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
                    (FacesMessage.SEVERITY_FATAL, "No existe !!", "El numero de control es invalido."));
                    break;
                case "ya evaluado":
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
                    (FacesMessage.SEVERITY_FATAL, "Ya evaluo !!", "El alumno ya realizo la evaluacion."));
                    break;
                case "valido":
                    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                    Map<String, Object> sessionMap = ec.getSessionMap();
                    sessionMap.put("mensage", "valido");
                    sessionMap.put("alumno", l.get(1));
                    ec.redirect(ec.getRequestContextPath() + "/evaluacion.xhtml");
                    break;
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
