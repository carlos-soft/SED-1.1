package jsf.beans;

import bo.PreguntasImpBO;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import persistencia.Preguntas;

public class PreguntasBean {

    private String descricion;
    private String respuestas;
    private static String newDescricion;
    private static String newRespuestas;
    private static int newIdPregunta;
    private static Preguntas selectedPregunta;
    private PreguntasImpBO preguntasBO;
    private PreguntasDataModel dataModel;

    public PreguntasBean() {
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public String getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String respuestas) {
        this.respuestas = respuestas;
    }

    public PreguntasImpBO getPreguntasBO() {
        return preguntasBO;
    }

    public void setPreguntasBO(PreguntasImpBO preguntasBO) {
        this.preguntasBO = preguntasBO;
    }

    public Preguntas getSelectedPregunta() {
        return selectedPregunta;
    }

    public void setSelectedPregunta(Preguntas selectedPregunta) {
        this.selectedPregunta = selectedPregunta;
    }

    public PreguntasDataModel getDataModel() {
        return dataModel;
    }

    public String getNewDescricion() {
        return newDescricion;
    }

    public void setNewDescricion(String newDescricion) {
        this.newDescricion = newDescricion;
    }

    public String getNewRespuestas() {
        return newRespuestas;
    }

    public void setNewRespuestas(String newRespuestas) {
        this.newRespuestas = newRespuestas;
    }

    public int getNewIdPregunta() {
        return newIdPregunta;
    }

    public void setNewIdPregunta(int newIdPregunta) {
        this.newIdPregunta = newIdPregunta;
    }

    public void insert() {
        try {
            preguntasBO.insert(this);
            getAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardada !!", "La pregunta fue guardada correctamente."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error !!", "Ocurrio un error a la hora de insertar la pregunta."));
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            preguntasBO.delete(selectedPregunta);
            getAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminada !!", "La pregunta fue eliminada correctamente."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error !!", "No selecciono una pregunta."));
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            Preguntas p = new Preguntas();
            p.setIdPregunta(getNewIdPregunta());
            p.setDescripcion(getNewDescricion());
            p.setRespuestas(getNewRespuestas());
            preguntasBO.update(p);
            getAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Modificada !!", "La pregunta fue modificada correctamente."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error !!", "Ocurrio un error a la hora de modificar la pregunta."));
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void getAll() {
        dataModel = new PreguntasDataModel(preguntasBO.getAll());
    }

    public void nuevosValores() {
        setNewDescricion(selectedPregunta.getDescripcion());
        setNewRespuestas(selectedPregunta.getRespuestas());
        setNewIdPregunta(selectedPregunta.getIdPregunta());
    }
}
