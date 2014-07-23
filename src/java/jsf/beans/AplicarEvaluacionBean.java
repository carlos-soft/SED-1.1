package jsf.beans;

import bo.PreguntasImpBO;
import java.util.List;
import javax.annotation.PostConstruct;
import persistencia.Preguntas;

public class AplicarEvaluacionBean {

    private PreguntasImpBO preguntasBO;
    private List<Preguntas> preguntas;
    
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
    
    @PostConstruct
    public void obtenerPreguntasAEvaluar(){
        preguntas = preguntasBO.getAllFromPreguntaEvaluacion();
    }
}
