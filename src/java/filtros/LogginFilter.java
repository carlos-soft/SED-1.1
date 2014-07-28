package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogginFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        HttpSession session = req.getSession();
        resp.setHeader("Cache-Control", "no-cache");
        Object userInSession = session.getAttribute("usuarioLogeado");
        if(userInSession == null) {
            System.out.println("Session nula . . .");
            request.setAttribute("errorAccesos", "La sesion esta nula.");
            req.getRequestDispatcher("/login.faces").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        
    }
    
}
