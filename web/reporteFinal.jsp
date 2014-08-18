<%@page import="persistencia.Preguntas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%
    HttpSession sesion = request.getSession();
    List<Preguntas> p = (List<Preguntas>) sesion.getAttribute("preguntas");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Reporte</title>
    </head>
    <body>
        <%            for (Preguntas l : p) {
                out.println(l.getDescripcion());
            }
        %>
    </body>
</html>
