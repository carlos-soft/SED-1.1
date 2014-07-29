package jsf.beans;

import bo.EvaluacionImpBO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.Evaluaciones;

public class AlumnoLoginBean {
    
    private Evaluaciones activa;
    private EvaluacionImpBO evaluacionBO;
    private String mensage;
    private String control;
    
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
    
    @PostConstruct
    public void printLink(){
        activa = evaluacionBO.getEvaluacionActiva().get(0);
        mensage =  activa.getLenguaje() + ": " + activa.getFechaInicio() + "-" + activa.getFechaFin()+".";
    }
    
    public void validar(){
        try {
            HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            res.sendRedirect(req.getContextPath()+"/alumnos/aplicarEvaluacion.xhtml");
            System.out.println("Munco");
        } catch (Exception ex) {
            System.out.println(" -- validar -- ");
            ex.printStackTrace();
        } 
    }
}
