package jsf.beans;

import bo.DocentesImpBO;
import bo.PreguntasImpBO;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import persistencia.Alumnos;
import persistencia.Preguntas;

public class AplicarEvaluacionBean {

    private PreguntasImpBO preguntasBO;
    private List<Preguntas> preguntas;
    private String comentario;
    private String alumno;
    private String docente;
    private DocentesImpBO docentesBO;

    public AplicarEvaluacionBean() {
    }

    public PreguntasImpBO getPreguntasBO() {
        return preguntasBO;
    }

    public void setPreguntasBO(PreguntasImpBO preguntasBO) {
        this.preguntasBO = preguntasBO;
    }

    public List<Preguntas> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Preguntas> preguntas) {
        this.preguntas = preguntas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public DocentesImpBO getDocentesBO() {
        return docentesBO;
    }

    public void setDocentesBO(DocentesImpBO docentesBO) {
        this.docentesBO = docentesBO;
    }

    @PostConstruct
    public void obtenerPreguntasAEvaluar() {
        preguntas = preguntasBO.getAllFromPreguntaEvaluacion();
        informacion();
    }

    public void informacion() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = ec.getSessionMap();
        this.alumno = (String) ((Alumnos) sessionMap.get("alumno")).getNombre();
        this.docente = (String) docentesBO.getFromAlumno(((Alumnos) sessionMap.get("alumno")).getIdGrupo()).getNombre();
    }

    public void guardarEvaluacion() {
        boolean error = false;
        for (int i = 0; i < preguntas.size(); i++) {
            Preguntas p1 = preguntas.get(i);
            if (p1.getAnswer().equals("")) {
                error = true;
                preguntas.get(i).setAnswer("no");
            }
        }
        if (!error) {
            if (comentario.equals("")) {
                comentario = "Ninguno";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !!", "Falta contestar la(s) preguntas."));
        }
    }
}
