package persistencia;
// Generated 23/07/2014 02:04:06 PM by Hibernate Tools 3.6.0



/**
 * PreguntasJoinEvaluacion generated by hbm2java
 */
public class PreguntasJoinEvaluacion  implements java.io.Serializable {


     private int idPregunta;
     private int idEvaluacion;

    public PreguntasJoinEvaluacion() {
    }

    public PreguntasJoinEvaluacion(int idPregunta, int idEvaluacion) {
       this.idPregunta = idPregunta;
       this.idEvaluacion = idEvaluacion;
    }
   
    public int getIdPregunta() {
        return this.idPregunta;
    }
    
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
    public int getIdEvaluacion() {
        return this.idEvaluacion;
    }
    
    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }




}


