package jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class MenuBean {

    private String direccion;

    public String getDireccion() {
        return direccion;
    }
    
    public MenuBean() {
    }
    
    public String despachador(String direccion){
        this.direccion = direccion;
        return direccion;
    }
}
