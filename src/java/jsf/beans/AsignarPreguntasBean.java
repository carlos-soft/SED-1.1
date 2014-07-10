package jsf.beans;

import bo.PreguntasImpBO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import persistencia.Preguntas;

public class AsignarPreguntasBean {

    private int idPregunta;
    private String descricion;
    private String respuestas;
    private static Preguntas selectedPregunta;
    private PreguntasDataModel dataModel;
    private List<Preguntas> bancoSelectedPreguntas;
    private static PreguntasDataModel bancoDataModel;
    private PreguntasImpBO preguntasBO;

    public AsignarPreguntasBean() {
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
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

    public PreguntasDataModel getDataModel() {
        return dataModel;
    }

    public PreguntasDataModel getBancoDataModel() {
        return bancoDataModel;
    }

    public Preguntas getSelectedPregunta() {
        return selectedPregunta;
    }

    public void setSelectedPregunta(Preguntas selectedPregunta) {
        this.selectedPregunta = selectedPregunta;
    }

    public List<Preguntas> getBancoSelectedPreguntas() {
        return bancoSelectedPreguntas;
    }

    public void setBancoSelectedPreguntas(List<Preguntas> bancoSelectedPreguntas) {
        this.bancoSelectedPreguntas = bancoSelectedPreguntas;
    }
    
    public PreguntasImpBO getPreguntasBO() {
        return preguntasBO;
    }

    public void setPreguntasBO(PreguntasImpBO preguntasBO) {
        this.preguntasBO = preguntasBO;
    }

    public void insert() {
        try {
            preguntasBO.insert(this);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Creada !!", "La pregunta fue creada correctamente."));
            getAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error !!", "ocurrio un error al crear la pregunta."));
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            Preguntas p = new Preguntas();
            p.setIdPregunta(selectedPregunta.getIdPregunta());
            p.setDescripcion(selectedPregunta.getDescripcion());
            p.setRespuestas(selectedPregunta.getRespuestas());
            p.setBanco(selectedPregunta.getBanco());
            preguntasBO.update(p);
            getAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Modificada !!", "La pregunta fue modificada correctamente."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error !!", "Ocurrio un error a la hora de modificar la pregunta."));
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            preguntasBO.deleteOfPreguntaEvaluacion(selectedPregunta);
            getAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Removida !!", "La pregunta fue eliminada correctamente."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error !!", "ocurrio un error al remover la pregunta."));
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void getAll() {
        dataModel = new PreguntasDataModel(preguntasBO.getAllFromPreguntaEvaluacion());
    }

    public void obtenerPreguntasFromBanco() {
        bancoDataModel = new PreguntasDataModel(preguntasBO.getAllFromBanco());
    }

    public void asignarFromBanco() {
        preguntasBO.asignarFromBanc(bancoSelectedPreguntas);
        getAll();
    }
}