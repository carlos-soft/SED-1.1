package jsf.beans;

import bo.PreguntasImpBO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import persistencia.Preguntas;

public class AplicarEvaluacionBean {

    private PreguntasImpBO preguntasBO;
    private List<Preguntas> preguntas;
    private String comentario;

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

    @PostConstruct
    public void obtenerPreguntasAEvaluar() {
        preguntas = preguntasBO.getAllFromPreguntaEvaluacion();
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
        if (error) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !!", "Falta contestar la(s) preguntas."));
        }
    }
}
