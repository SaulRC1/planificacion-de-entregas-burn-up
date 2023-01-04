<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Proyecto ${proyecto.nombreDeProyecto}</title>
        <link
            rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/css/historia-2/tarea-1/ventana-de-proyecto.css" />
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
            href="${pageContext.request.contextPath}/css/historia-4/tarea-2-4/ventana-historia.css" />
        <link
            rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/css/historia-4/tarea-2-4/ventana-historia-edit.css" />
        <link
            rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/css/historia-4/tarea-2-4/ventana-historia-delete.css" />
        <link
            rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/css/historia-4/tarea-1-3/ventana-tarea-edit.css" />
        <link
            rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/css/historia-4/tarea-1-3/ventana-tarea-delete.css" />
        <link
            rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/css/clases-comunes/botones.css" />

        <link
            rel="stylesheet"
            type="text/css"
            href="${pageContext.request.contextPath}/css/historia-5/tarea-1/estilo-ventana-planificacion.css" />

        <script
            src="${pageContext.request.contextPath}/js/jquery-3.6.3.min.js"
        defer></script>
        <script
            src="${pageContext.request.contextPath}/js/historia-2/tarea-1/menu-ventana-de-proyecto.js"
        defer></script>
        <script
            src="${pageContext.request.contextPath}/js/historia-2/tarea-1/ventana-ajustes-proyecto.js"
        defer></script>
        <script
            src="${pageContext.request.contextPath}/js/historia-2/tarea-1/ventana-de-proyecto.js"
        defer></script>
        <script
            src="${pageContext.request.contextPath}/js/historia-4/tarea-2-4/ventana-historia.js"
        defer></script>
        <script
            src="${pageContext.request.contextPath}/js/historia-4/tarea-1-3/ventana-tarea.js"
        defer></script>

        <script
            src="${pageContext.request.contextPath}/js/historia-5/tarea-1/ventana-planificacion-burn-up.js"
        defer></script>
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
                <tr class="estilo-td">
                    <td>H1</td>
                    <td>T2</td>
                    <td>4</td>
                    <td>4</td>
                    <td>12</td>
                </tr>
                <tr class="estilo-td">
                    <td>H1</td>
                    <td>T2</td>
                    <td>4</td>
                    <td>4</td>
                    <td>12</td>
                </tr>
                <tr class="estilo-td">
                    <td>H1</td>
                    <td>T2</td>
                    <td>4</td>
                    <td>4</td>
                    <td>12</td>
                </tr>
                <tr class="estilo-td">
                    <td>H1</td>
                    <td>T2</td>
                    <td>4</td>
                    <td>4</td>
                    <td>12</td>
                </tr>
                <tr class="estilo-td">
                    <td>H1</td>
                    <td>T2</td>
                    <td>4</td>
                    <td>4</td>
                    <td>12</td>
                </tr>
                <tr class="estilo-td">
                    <td>H1</td>
                    <td>T2</td>
                    <td>4</td>
                    <td>4</td>
                    <td>12</td>
                </tr>
                <tr class="estilo-td">
                    <td>H1</td>
                    <td>T2</td>
                    <td>4</td>
                    <td>4</td>
                    <td>12</td>
                </tr>
                <tr class="estilo-td">
                    <td>H1</td>
                    <td>T2</td>
                    <td>4</td>
                    <td>4</td>
                    <td>12</td>
                </tr>
                <tr class="estilo-td">
                    <td>H1</td>
                    <td>T2</td>
                    <td>4</td>
                    <td>4</td>
                    <td>12</td>
                </tr>
                <tr class="estilo-td">
                    <td>H1</td>
                    <td>T2</td>
                    <td>4</td>
                    <td>4</td>
                    <td>12</td>
                </tr>
                <tr class="estilo-td">
                    <td>H1</td>
                    <td>T2</td>
                    <td>4</td>
                    <td>4</td>
                    <td>12</td>
                </tr>
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
