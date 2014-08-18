package jsf.beans;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
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

    public String despachador(String direccion) {
        System.out.println(direccion);
        return direccion;
    }
    
    public void cerrarSesion() throws IOException{
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/cerrarSesion.jsp");
    }
}
