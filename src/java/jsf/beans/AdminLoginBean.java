package jsf.beans;

import bo.AdministradoresImpBO;
import java.io.IOException;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class AdminLoginBean {

    private AdministradoresImpBO administradoresBO;
    private String usuario;
    private String password;

    public AdminLoginBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdministradoresImpBO getAdministradoresBO() {
        return administradoresBO;
    }

    public void setAdministradoresBO(AdministradoresImpBO administradoresBO) {
        this.administradoresBO = administradoresBO;
    }

    public void validar() throws IOException {
        if (administradoresBO.obtenerAcceso(usuario, password).equals("pass")) {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            Map<String, Object> sessionMap = ec.getSessionMap();
            sessionMap.put("administrador", "pass");
            ec.redirect(ec.getRequestContextPath() + "/faces/admin/addEvaluacion.xhtml");
        } else {
        }
    }
}
