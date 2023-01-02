<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto ${proyecto.nombreDeProyecto}</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/historia-2/tarea-1/ventana-de-proyecto.css" >
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/clases-comunes/flexbox.css" >
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/clases-comunes/fuentes.css" >
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/historia-4/tarea-2-4/ventana-historia.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/historia-4/tarea-2-4/ventana-historia-edit.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/clases-comunes/botones.css">

        <script src="${pageContext.request.contextPath}/js/jquery-3.6.3.min.js" defer></script>
        <script src="${pageContext.request.contextPath}/js/historia-2/tarea-1/menu-ventana-de-proyecto.js" defer></script>
        <script src="${pageContext.request.contextPath}/js/historia-2/tarea-1/ventana-ajustes-proyecto.js" defer></script>
        <script src="${pageContext.request.contextPath}/js/historia-2/tarea-1/ventana-de-proyecto.js" defer></script>
        <script src="${pageContext.request.contextPath}/js/historia-4/tarea-2-4/ventana-historia.js" defer></script>
        
    </head>
    <body>      
        <div class="main-div flexbox-column flexbox-justify-start">
            
            <div id="float-window-background" class="flexbox-column flexbox-justify-center flex-align-center floating-window-background">
                <jsp:include page="ventana-ajustes-proyecto.jsp" />
                <jsp:include page="../../historia-4/tarea-2-4/ventana-historia-editar.jsp" />
            </div>
            
            <jsp:include page="../../historia-4/tarea-2-4/ventana-historia.jsp" />
            
            <!-- Titulo del proyecto -->
            <div class="div-titulo flexbox-row flex-align-center flexbox-justify-center">
                <p class="roboto-condensed">${proyecto.nombreDeProyecto}</p>
            </div>

            <!-- Menu de opciones -->
            <jsp:include page="menu-ventana-proyecto.jsp"/>

            <!-- Seccion principal -->
            <div class="project-section flexbox-column flexbox-justify-start">

                <table class="project-table roboto-condensed">

                    <tr>
                        <th>Historia de Usuario</th>
                        <th>Valor</th>
                        <th>Tarea</th>
                        <th>Prioridad</th>
                        <th>Metrica de viabilidad (Valor * Prioridad)</th>
                        <th>Esfuerzo</th>
                    </tr>

                    <c:forEach items="${historiasDeUsuario}" var="historia">
                        <c:forEach items="${historia.listaDeTareas}" var="tarea">
                            <tr>
                                <td>${tarea.historia.nombreDeHistoria}</td>
                                <td>${tarea.historia.valorAportado}</td>
                                <td>${tarea.nombreDeTarea}</td>
                                <td>${tarea.prioridad}</td>
                                <td>${tarea.historia.valorAportado * tarea.prioridad}</td>
                                <td>${tarea.esfuerzo}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>


                </table>

            </div>

            <div class="project-planification-div flexbox-row flexbox-justify-end flex-align-center">

                <button type="button" class="action-button roboto-condensed project-button project-action-button">
                    Generar gráfica burn-up
                </button>

                <button type="button" class="action-button roboto-condensed project-button project-action-button">
                    Planificar
                </button>
            </div>
        </div>
    </body>
</html>
