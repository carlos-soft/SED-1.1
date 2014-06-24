package jsf.beans;

import bo.AlumnosImpBO;
import bo.DocentesImpBO;
import bo.EvaluacionImpBO;
import bo.GruposImpBO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.primefaces.event.FileUploadEvent;
import persistencia.Alumnos;
import persistencia.Evaluaciones;
import persistencia.GruposJoinDocentes;

public class SubirArchivoBean {

    private EvaluacionImpBO evaluacionBO;
    private DocentesImpBO docentesBO;
    private GruposImpBO gruposBO;
    private AlumnosImpBO alumnosBO;
    private Evaluaciones activa;
    String etiquetas[] = {"GRUPO:", "MATERIA:", "PROFESOR:", "NIVEL:", "CLAVE", "NOMBRE DEL ALUMNO"};
    String grupo, materia, profesor, nivel;
    List<String> claves;
    List<String> nombres;
    private List<GruposJoinDocentes> lista;
    private GruposJoinDocentes selectedGrupo;
    private GruposDataModel dataModel;
    private List<Alumnos> alumnosFromGroup;
    private int selectedEvaluacion; 

    public EvaluacionImpBO getEvaluacionBO() {
        return evaluacionBO;
    }

    public void setEvaluacionBO(EvaluacionImpBO evaluacionBO) {
        this.evaluacionBO = evaluacionBO;
    }

    public DocentesImpBO getDocentesBO() {
        return docentesBO;
    }

    public void setDocentesBO(DocentesImpBO docentesBO) {
        this.docentesBO = docentesBO;
    }

    public GruposImpBO getGruposBO() {
        return gruposBO;
    }

    public void setGruposBO(GruposImpBO gruposBO) {
        this.gruposBO = gruposBO;
    }

    public AlumnosImpBO getAlumnosBO() {
        return alumnosBO;
    }

    public void setAlumnosBO(AlumnosImpBO alumnosBO) {
        this.alumnosBO = alumnosBO;
    }

    public Evaluaciones getActiva() {
        return activa;
    }

    public void setActiva(Evaluaciones activa) {
        this.activa = activa;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getNivel() {
        return nivel;
    }

    public String getMateria() {
        return materia;
    }

    public List<String> getClaves() {
        return claves;
    }

    public List<String> getNombres() {
        return nombres;
    }

    public List<GruposJoinDocentes> getLista() {
        return lista;
    }

    public void setLista(List<GruposJoinDocentes> lista) {
        this.lista = lista;
    }

    public GruposJoinDocentes getSelectedGrupo() {
        return selectedGrupo;
    }

    public void setSelectedGrupo(GruposJoinDocentes selectedGrupo) {
        this.selectedGrupo = selectedGrupo;
    }

    public GruposDataModel getDataModel() {
        return dataModel;
    }

    public List<Alumnos> getAlumnosFromGroup() {
        return alumnosFromGroup;
    }

    public void setAlumnosFromGroup(List<Alumnos> alumnosFromGroup) {
        this.alumnosFromGroup = alumnosFromGroup;
    }

    public Map<String, Integer> getEvaluacionesList() {
        return evaluacionBO.getAllForAList();
    }

    public int getSelectedEvaluacion() {
        return selectedEvaluacion;
    }

    public void setSelectedEvaluacion(int selectedEvaluacion) {
        this.selectedEvaluacion = selectedEvaluacion;
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Cargado...", "El Grupo se creo exitosamente."));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String fileName, InputStream in) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ServletContext context = ((HttpServletRequest) ctx.getExternalContext().getRequest()).getSession().getServletContext();
        String path = context.getRealPath("grupos");
        path = path.replace("\\", "\\\\");
        path += "\\\\";
        path += activa.getLenguaje() + activa.getFechaInicio() + activa.getFechaFin() + "\\\\" + fileName;
        try {
            File f = new File(path);
            OutputStream out = new FileOutputStream(f);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            leerArchivo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void leerArchivo(String fileName) {
        try {
            Workbook archivoExcel = Workbook.getWorkbook(new File(fileName));
            Cell temp = null;
            Cell row[] = null;
            Cell clav[] = null;
            Cell nom[] = null;
            Sheet hoja = null;
            claves = new ArrayList<String>();
            nombres = new ArrayList<String>();
            for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) {
                hoja = archivoExcel.getSheet(sheetNo);
                for (int i = 0; i < etiquetas.length; i++) {
                    temp = hoja.findCell(etiquetas[i]);
                    if (!etiquetas[i].equals("CLAVE") && !etiquetas[i].equals("NOMBRE DEL ALUMNO")) {
                        row = hoja.getRow(temp.getRow());
                        for (int j = 0; j < row.length; j++) {
                            if ((row[j].getContents().length() >= 1) && (!row[j].getContents().equals(etiquetas[i]))
                                    && (!row[j].getContents().contains("-"))) {
                                switch (etiquetas[i]) {
                                    case "GRUPO:":
                                        grupo = row[j].getContents();
                                        break;
                                    case "MATERIA:":
                                        materia = row[j].getContents();
                                        break;
                                    case "PROFESOR:":
                                        profesor = row[j].getContents();
                                        break;
                                    case "NIVEL:":
                                        nivel = row[j].getContents();
                                        break;
                                }
                            }
                        }
                    } else {
                        if (etiquetas[i].equals("CLAVE")) {
                            clav = hoja.getColumn(temp.getColumn());
                            for (int j = 0; j < clav.length; j++) {
                                if (clav[j].getContents().length() > 1 && !(clav[j].getContents().equals("CLAVE"))) {
                                    claves.add(clav[j].getContents());
                                }
                            }
                        } else {
                            nom = hoja.getColumn(temp.getColumn());
                            for (int j = 0; j < nom.length; j++) {
                                if (nom[j].getContents().length() > 10 && !(nom[j].getContents().equals("NOMBRE DEL ALUMNO"))) {
                                    nombres.add(nom[j].getContents());
                                }
                            }
                        }
                    }
                }

            }
            insert();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insert() {
        try {
            docentesBO.insert(this);
            gruposBO.insert(this);
            alumnosBO.insert(this);
            getAllGrupos();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void publicarMensaje() {
        activa = evaluacionBO.getEvaluacionActiva().get(0);
        getAllGrupos();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_WARN, "'"+activa.getLenguaje() + ": " + activa.getFechaInicio() + "-" + activa.getFechaFin()+"'.", " Evaluacion activa."));
    }
    
    @PostConstruct
    public void getAllGrupos() {
        setLista(gruposBO.getAllGroupsFromEvaluacion(activa));
        dataModel = new GruposDataModel(getLista());
    }

    public void obtenerAlumnosFromGroupId(){
        setAlumnosFromGroup(alumnosBO.getAlumnosFromGroupId(selectedGrupo));
    }

    public void deleteGrupo() {
        try {
            gruposBO.delete(selectedGrupo);
            getAllGrupos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado !!", "El grupo fue eliminado correctamente."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error !!", "Ocurrio un error a la hora de eliminar el registro."));
            e.printStackTrace();
        }
    }
}
