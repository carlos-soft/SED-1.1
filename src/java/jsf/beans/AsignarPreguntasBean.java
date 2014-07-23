package jsf.beans;

import bo.PreguntasImpBO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import persistencia.Preguntas;
import persistencia.PreguntasJoinEvaluacion;

public class AsignarPreguntasBean {

    private int idPregunta;
    private String descricion;
    private String respuestas;
    private static Preguntas selectedPregunta;
    private static PreguntasDataModel dataModel;
    private List<Preguntas> bancoSelectedPreguntas;
    private static PreguntasDataModel bancoDataModel;
    private PreguntasImpBO preguntasBO;
    private boolean btnActivar;

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

    public boolean isBtnActivar() {
        return btnActivar;
    }

    public void setBtnActivar(boolean btnActivar) {
        this.btnActivar = btnActivar;
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

    public void getAll() {
        dataModel = new PreguntasDataModel(preguntasBO.getAllFromPreguntaEvaluacion());
    }

    @PostConstruct
    public void obtenerPreguntasFromBanco() {
        bancoDataModel = new PreguntasDataModel(preguntasBO.getAllFromBanco());
        getAll();
    }

    public void asignarFromBanco() {
        preguntasBO.asignarFromBanc(bancoSelectedPreguntas);
        getAll();
    }

    public void mensajeProhibido() {
        if (selectedPregunta.getBanco().equals("s")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Prohibido !!", "Las preguntas del banco no pueden ser modificadas."));
        }
    }

    public void onRowSelect(SelectEvent event) {
        PreguntasJoinEvaluacion pe = preguntasBO.getFromPreguntasEvaluacion(bancoSelectedPreguntas);
        if (pe != null) {
            setBtnActivar(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Ya existe !!", "La pregunta con el Id: " + pe.getIdPregunta() + " ya fue agregada a la evaluacion."));
        } else {
            setBtnActivar(false);
        }
    }

    public void onRowUnselect(UnselectEvent event) {
        PreguntasJoinEvaluacion pe = preguntasBO.getFromPreguntasEvaluacion(bancoSelectedPreguntas);
        if (pe != null) {
            setBtnActivar(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Ya existe !!", "La pregunta con el Id: " + pe.getIdPregunta() + " ya fue agregada a la evaluacion."));
        } else {
            setBtnActivar(false);
        }
    }

    public void agregarABanco() {
        try {
            if (selectedPregunta.getBanco().equals("s")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !!", "La pregunta ya pertenece al Banco."));
            } else {
                preguntasBO.cambiarBanco(selectedPregunta.getIdPregunta());
                getAll();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Asignada !!", "La pregunta fue asignada al banco."));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error !!", "Ocurrio un error a la hora de asignar la pregunta."));
            e.printStackTrace();
        }
    }
}
