<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <script
      src="${pageContext.request.contextPath}/js/historia-5/tarea-1/ventana-planificacion-burn-up.js"
      defer></script>
  </head>

  <body>
    <div class="main-div flexbox-column flexbox-justify-start">
      <div
        class="estilo-th project-planification-div div-titulo flexbox-row flex-align-center flexbox-justify-center">
        <p class="roboto-condensed">
          Planificacion ${proyecto.nombreDeProyecto}
        </p>
      </div>

      <div class="project-section flexbox-column flexbox-justify-start">
        <table
          class="project-table roboto-condensed"
          id="listado-tareas"
          border="1">
          <tr class="estilo-th">
            <th>Historias de Usuario</th>
            <th>Tareas</th>
            <th>Sprint</th>
            <th>Puntos de Usuario</th>
            <th>Puntos de Iteracion Restantes</th>
          </tr>

          <c:forEach
            items="${proyectoPlanificado.tareasPlanificadas}"
            var="tarea">
            <tr class="estilo-td">
              <td>${tarea.historia.nombreDeHistoria}</td>
              <td>${tarea.nombreDeTarea}</td>
              <td>
                ${proyectoPlanificado.numeroDeSprintsRealizados.get(proyectoPlanificado.tareasPlanificadas.indexOf(tarea))}
              </td>
              <td>${tarea.esfuerzo}</td>
              <td>
                ${proyectoPlanificado.puntosRestantes.get(proyectoPlanificado.tareasPlanificadas.indexOf(tarea))}
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>

      <div
        class="project-planification-div flexbox-row flexbox-justify-end flex-align-center">
        <button
          id="id-boton-volver"
          type="button"
          class="action-button roboto-condensed project-button project-action-button">
          Volver
        </button>
      </div>
    </div>
  </body>
</html>
