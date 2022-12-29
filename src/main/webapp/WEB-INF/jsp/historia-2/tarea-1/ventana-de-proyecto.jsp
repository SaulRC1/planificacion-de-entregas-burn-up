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
        
        <script src="${pageContext.request.contextPath}/js/historia-2/tarea-1/menu-ventana-de-proyecto.js" defer></script>
        <script src="${pageContext.request.contextPath}/js/historia-2/tarea-1/ventana-de-proyecto.js" defer></script>
        <script src="${pageContext.request.contextPath}/js/historia-4/tarea-2-4/ventana-historia.js" defer></script>
    </head>
    <body>      
        <div class="main-div flexbox-column flexbox-justify-start">   
            <jsp:include page="../../historia-4/tarea-2-4/ventana-historia.jsp" />
            <!-- Titulo del proyecto -->
            <div class="div-titulo flexbox-row flex-align-center flexbox-justify-center">
                <p class="roboto-condensed">${proyecto.nombreDeProyecto}</p>
            </div>
            
            <!-- Menu de opciones -->
            <jsp:include page="menu-ventana-proyecto.jsp"/>
            
            <!-- Seccion principal -->
            <div>
                
            </div>
            
        </div>
    </body>
</html>
