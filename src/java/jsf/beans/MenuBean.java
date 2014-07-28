 package jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            System.out.println(request.getContextPath()+"/admin/"+direccion+".faces");
            //response.sendRedirect(request.getContextPath()+"/admin/"+direccion+".xhtml");
            return "/admin/"+direccion+".xhtml";
    }
}
