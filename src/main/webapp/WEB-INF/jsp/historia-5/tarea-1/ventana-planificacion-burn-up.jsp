<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Planificación ${proyecto.nombreDeProyecto}</title>

        <link
            rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/css/clases-comunes/flexbox.css" />
        <link
            rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/css/clases-comunes/fuentes.css" />

        <link
            rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/css/clases-comunes/botones.css" />

        <link
            rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/css/historia-5/tarea-1/estilo-ventana-planificacion.css" />

        <script src="${pageContext.request.contextPath}/js/historia-5/tarea-1/ventana-planificacion-burn-up.js" defer></script>
    </head>
    <body>
        <div class="align-center">
            <table class="estilo-tabla margin-top" id="listado-tareas" border="1">
                <tr class="estilo-th">
                    <th>Historias de Usuario</th>
                    <th>Tareas</th>
                    <th>Sprint</th>
                    <th>Puntos de Usuario</th>
                    <th>Puntos de Iteracion Restantes</th>
                </tr>

                <c:forEach items="${proyectoPlanificado.tareasPlanificadas}" var="tarea">
                    <tr class="estilo-td">
                        <td>${tarea.historia.nombreDeHistoria}</td>
                        <td>${tarea.nombreDeTarea}</td>
                        <td>${proyectoPlanificado.numeroDeSprintsRealizados.get(proyectoPlanificado.tareasPlanificadas.indexOf(tarea))}</td>
                        <td>${tarea.esfuerzo}</td>
                        <td>${proyectoPlanificado.puntosRestantes.get(proyectoPlanificado.tareasPlanificadas.indexOf(tarea))}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div>
            <button
                id="id-boton-ocultar"
                class="action-button botones_menu flexbox-column flexbox-justify-center flex-align-center roboto-condensed margin-left-body estilo-boton">
                Ocultar
            </button>
        </div>
    </body>
</html>
