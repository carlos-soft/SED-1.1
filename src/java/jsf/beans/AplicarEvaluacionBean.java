package jsf.beans;

import bo.DocentesImpBO;
import bo.PreguntasImpBO;
import bo.RegistrosImpBO;
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
    private RegistrosImpBO registrosBO;
    private Alumnos a;

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

    public Alumnos getA() {
        return a;
    }

    public RegistrosImpBO getRegistrosBO() {
        return registrosBO;
    }

    public void setRegistrosBO(RegistrosImpBO registrosBO) {
        this.registrosBO = registrosBO;
    }

    @PostConstruct
    public void obtenerPreguntasAEvaluar() {
        this.preguntas = preguntasBO.getAllFromPreguntaEvaluacion();
        informacion();
    }

    public void informacion() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = ec.getSessionMap();
        this.a = (Alumnos) sessionMap.get("alumno");
        this.alumno = a.getNombre();
        this.docente = (String) docentesBO.getFromAlumno(a.getIdGrupo()).getNombre();
    }

    public void guardarEvaluacion() {
        boolean error = false;
        for (Preguntas p1 : preguntas) {
            if (p1.getAnswer() == null) {
                error = true;
                p1.setAnswer("no");
            }
        }
        if (!error) {
            if (comentario.equals("")) {
                comentario = "Ninguno";
            }
            registrosBO.insert(this);
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !!", "Falta contestar la(s) preguntas."));
        }
    }
}
/*
select a.nombre as alumno, d.nombre as docente, p.idPregunta, p.descripcion, res.answer, reg.comentario
from Docentes d
join Grupos g
join Alumnos a
join Registros reg
join Resultados res
join Preguntas p
join preguntasjoinevaluacion pe
join Evaluaciones e
where d.idDocente = idDoc and
	d.idDocente = g.idDocente and
	g.idGrupo = a.idGrupo and 
	a.idAlumno = reg.idAlumno and
	reg.idRegistro = res.idRegistro and
	res.idPregunta = p.idPregunta and
	p.idPregunta = pe.idPregunta and
	pe.idEvaluacion = e.idEvaluacion;



call reporte(1);

DROP PROCEDURE IF EXISTS reporte;
*/