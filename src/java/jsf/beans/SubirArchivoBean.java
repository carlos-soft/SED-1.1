package jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.UploadedFile;

@ManagedBean
@RequestScoped
public class SubirArchivoBean {
    
    private UploadedFile file;
    
    public SubirArchivoBean() {
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public void upload() {
        if(file != null) {
            
        }
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