package bo;

import jdbc.dao.ImpAdministradores;

public class AdministradoresImpBO implements AdministradoresBO{

    private ImpAdministradores administradoresDAO;

    public ImpAdministradores getAdministradoresDAO() {
        return administradoresDAO;
    }

    public void setAdministradoresDAO(ImpAdministradores administradoresDAO) {
        this.administradoresDAO = administradoresDAO;
    }
    
    public String obtenerAcceso(String user, String pass) {
        return administradoresDAO.obtenerAcceso(user, pass);
    }
    
}
