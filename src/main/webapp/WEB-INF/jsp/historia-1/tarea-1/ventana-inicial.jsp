<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Planificación Burn-Up</title>
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
      href="${pageContext.request.contextPath}/css/historia-1/tarea-1/estilo-ventana-inicial.css" />

    <link
      rel="stylesheet"
      type="text/css"
      href="${pageContext.request.contextPath}/css/clases-comunes/botones.css" />

    <link
      rel="stylesheet"
      type="text/css"
      href="${pageContext.request.contextPath}/css/historia-1/tarea-1/estilo-ventana-pedir-datos.css" />

    <script
      src="${pageContext.request.contextPath}/js/historia-1/tarea-1/ventana-inicial.js"
      defer></script>

    <script
      src="${pageContext.request.contextPath}/js/historia-1/tarea-1/ventana-pedir-datos.js"
      defer></script>
  </head>

  <body>
    <div class="flexbox-column flexbox-justify-start main-div">
      <div
        id="float-window-background-pedir-datos"
        class="flexbox-column flexbox-justify-center flex-align-center floating-window-background">
        <jsp:include page="ventana-introducir-datos.jsp" />
      </div>

      <div class="menu flexbox-row flexbox-justify-start flex-align-center">
        <button
          id="id-boton-crear-proyecto"
          class="action-button botones_menu flexbox-column flexbox-justify-center flex-align-center roboto-condensed"
          type="button">
          Crear Proyecto
        </button>
      </div>

      <div class="main-section flexbox-column flexbox-justify-start">
        <table class="estilo_tabla roboto-condensed" border="1">
          <tr>
            <th>Nombre del Proyecto</th>
            <th>Velocidad(Puntos/Sprint)</th>
            <th>Duracion del Sprint(Semanas)</th>
          </tr>

          <c:forEach items="${listaDeProyectos}" var="proyect">
            <tr>
              <td>
                <a
                  href="${pageContext.request.contextPath}/ventana-de-proyecto/${proyect.nombreDeProyecto}"
                  >${proyect.nombreDeProyecto}</a
                >
              </td>
              <td>${proyect.duracionDelSprint}</td>
              <td>${proyect.velocidadDelEquipo}</td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </body>
</html>
