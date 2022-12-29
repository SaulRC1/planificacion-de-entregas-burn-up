<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Proyecto ${proyecto.nombreDeProyecto}</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="${pageContext.request.contextPath}/css/clases-comunes/flexbox.css" />
    <link
      rel="stylesheet"
      type="text/css"
      href="${pageContext.request.contextPath}/css/clases-comunes/fuentes.css" />
    <script
      src="${pageContext.request.contextPath}/js/historia-1/tarea-1/ventana-inicial.js"
      defer></script>
    <link
      rel="stylesheet"
      type="text/css"
      href="${pageContext.request.contextPath}/css/historia-1/tarea-1/estilo-ventana-inicial.css" />
  </head>

  <body>
    <div class="menu">
      <a href="${pageContext.request.contextPath}/ventana-pedir-datos"
        >Crear Proyecto</a
      >
    </div>
  </body>
</html>
