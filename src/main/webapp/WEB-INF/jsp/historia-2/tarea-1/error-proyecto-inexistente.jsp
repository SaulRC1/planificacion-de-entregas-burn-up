<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/historia-2/tarea-1/error-proyecto-inexistente.css" >
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/clases-comunes/flexbox.css" >
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/clases-comunes/fuentes.css" >
        
        <script src="${pageContext.request.contextPath}/js/historia-2/tarea-1/menu-ventana-de-proyecto.js" defer></script>
        <script src="${pageContext.request.contextPath}/js/historia-2/tarea-1/ventana-de-proyecto.js" defer></script>
    </head>
    <body>
        <div class="main-div flexbox-column flexbox-justify-center flex-align-center">
            <img src="${pageContext.request.contextPath}/images/historia-2/tarea-1/error.jpg">
            <p class="roboto-condensed" >Oops, parece que el proyecto "${errorNombre}" no existe!</p>
            <a class="roboto-condensed" href="${pageContext.request.contextPath}/">Volver a la pagina principal</a>
        </div>
    </body>
</html>
