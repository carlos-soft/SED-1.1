package jsf.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import persistencia.Evaluaciones;

@ManagedBean
@RequestScoped
public class SubirArchivoBean {

    public void update(FileUploadEvent event) {
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String fileName, InputStream in) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ServletContext context = ((HttpServletRequest) ctx.getExternalContext().getRequest()).getSession().getServletContext();
        String path = context.getRealPath("grupos");
        path = path.replace("\\", "\\\\");
        path += "\\\\";
        try {
            System.out.println(path);
            File f = new File(path+fileName);
            OutputStream out = new FileOutputStream(f);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Evaluaciones getEvaluacionActiva(){
        return null;
    }
}

/*
 * String etiquetas[] = {"GRUPO:", "MATERIA:", "PROFESOR:", "NIVEL:", "CLAVE", "NOMBRE DEL ALUMNO"};
 Workbook archivoExcel = Workbook.getWorkbook(new File("C:\\Users\\Carlos\\Desktop\\conv. adultos.xls"));
 String grupo = "", materia = "", profesor = "", nivel = "";
 List<String> claves = new ArrayList<String>();
 List<String> nombres = new ArrayList<String>();
 Cell temp = null;
 Cell row[] = null;
 Cell clav[] = null;
 Cell nom[] = null;
 Sheet hoja = null;
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
 System.out.println("Grupo:" + grupo);
 System.out.println("Materia:" + materia);
 System.out.println("Profesor:" + profesor);
 System.out.println("Nivel:" + nivel);
 for (int i = 0; i < nombres.size(); i++) {
 System.out.println(claves.get(i) + " " +nombres.get(i));
            
 }
 System.out.println("Total: " + nombres.size());
 */
