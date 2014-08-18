package jdbc.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ImpAdministradores extends HibernateDaoSupport implements IFaceAdministradores{

    public String obtenerAcceso(String user, String pass) {
        if (user.equals("admin") && pass.equals("123456")) {
            return "pass";
        } else {
            return "notpass";
        }
    }
    
}
