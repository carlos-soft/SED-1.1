
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
    String grupo = (String) sesion.getAttribute("grupo");
    String evaluacion = (String) sesion.getAttribute("evaluacion");
%>
<html>
    <head><title>S E D</title></head>
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
             height: 82%;" align="center">
            <table style="font-family: monospace; font-size: 15px;">
                <tr>
                    <td style="text-align: right; font-weight: bold;">EVALUACION: </td>
                    <td> <%= evaluacion%></td>
                </tr>
                <tr>
                    <td style="text-align: right; font-weight: bold;">DOCENTE: </td>
                    <td> <%= d.getNombre()%></td>
                </tr>
                <tr>
                    <td style="text-align: right; font-weight: bold;">GRUPO: </td>
                    <td> <%= grupo%></td>
                </tr>
            </table><br/>
            <table border="2" style="font-family:Tahoma;">
                <tr style="text-align: center;">
                    <th>PREGUNTA</th>
                        <% for (int i = 0; i < c.size(); i++) {%>
                    <th><%="A#" + (i + 1)%></th>
                        <%}%>
                </tr>
                <% for (int i = 0; i < p.size(); i++) {%>
                <tr>
                    <td style="text-align: left; font-family: Tahoma;">
                        <%= p.get(i).getDescripcion()%>
                    </td>
                    <% for (int j = 0; j < c.size(); j++) {%>
                    <td style="text-align: center; font-family: monospace; font-size: 15px;">
                        <%= c.get(j).get(i)%>
                    </td>
                    <% } %>
                </tr>
                <% }%>
            </table><br/><br/>
            <table border="2" style="font-family:Tahoma;">
                <tr>
                    <th style="text-align: center; font-weight: bold;">COMENTARIOS</th>
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
