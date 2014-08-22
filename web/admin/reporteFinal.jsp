<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="persistencia.Preguntas"%>
<%@page import="java.util.List"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%
    HttpSession sesion = request.getSession();
    List<Preguntas> p = (List<Preguntas>) sesion.getAttribute("preguntas");
    List<List<Integer>> c = (List<List<Integer>>) sesion.getAttribute("calificaciones");
    List<String> com = (List<String>) sesion.getAttribute("comentarios");
%>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <table border="2">
            <tr>
                <th>PREGUNTA</th>
                    <% for (int i = 0; i < c.size(); i++) {%>
                <th><%="A#" + (i + 1)%></th>
                    <%}%>
            </tr>
            <% for (int i = 0; i < p.size(); i++) {%>
            <tr>
                <td>
                    <%= p.get(i).getDescripcion()%>
                </td>
                <% for (int j = 0; j < c.size(); j++) {%>
                <td >
                    <%= c.get(j).get(i)%>
                </td>
                <% } %>
            </tr>
            <% }%>
        </table><br/><br/>
        <table border="2">
            <tr>
                <th>COMENTARIOS</th>
            </tr>
            <%for (String comentario : com) {%>
            <tr>
                <td>
                    <%=comentario%>
                </td>
                <%}%>
            </tr>
        </table>
    </body>
</html>
