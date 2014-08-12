package jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MenuBean {

    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public MenuBean() {
    }

    public String despachador(String direccion) {
        return direccion;
    }
}
