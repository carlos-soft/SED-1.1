
<%@page import="persistencia.Preguntas"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.Docentes"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%
    HttpSession sesion = request.getSession();
    List<Preguntas> p = (List<Preguntas>) sesion.getAttribute("preguntas");
    List<List<Integer>> c = (List<List<Integer>>) sesion.getAttribute("calificaciones");
    List<String> com = (List<String>) sesion.getAttribute("comentarios");
    Docentes d = (Docentes) sesion.getAttribute("docente");
%>
<html>
    <head></head>
    <body>
        <div style="position: absolute; 
             right: 6%; left: 0%; 
             top: 0%; height: 16%;
             margin-bottom: 4%;
             background: #ffffff;">
            <img src="../resources/img/logo5.png"/>
        </div>
        <div style="padding: 1%;
             border: thin solid lightGray;
             background: #ffffff;
             position: absolute;
             right: 1%;
             left: 0%;
             top: 12%;
             height: 82%;">
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
        </div>
    </body>
</html>
