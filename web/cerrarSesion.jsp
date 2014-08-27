<%
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        response.sendRedirect(request.getContextPath()+ "/index.faces");
%>
