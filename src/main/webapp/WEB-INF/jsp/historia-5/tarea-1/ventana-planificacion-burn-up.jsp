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
      src="${pageContext.request.contextPath}/js/historia-5/tarea-1/ventana-planificacion-burn-up.js"
      defer></script>
    <link
      rel="stylesheet"
      type="text/css"
      href="${pageContext.request.contextPath}/css/historia-5/tarea-1/estilo-ventana-vista-general.css" />
    <!--<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet" /-->
  </head>

  <body>
    <div class="align-center">
      <table class="estilo-tabla" id="listado-tareas" border="1">
        <tr>
          <th>Historia de Usuario</th>
          <th>Tarea</th>
          <th>Sprint</th>
          <th>Puntos de Usuario</th>
          <th>Puntos de Iteracion Restantes</th>
        </tr>
        <tr>
          <td>H1</td>
          <td>T2</td>
          <td>4</td>
          <td>4</td>
          <td>12</td>
        </tr>
        <tr>
          <td>H1</td>
          <td>T2</td>
          <td>4</td>
          <td>4</td>
          <td>12</td>
        </tr>
        <tr>
          <td>H1</td>
          <td>T2</td>
          <td>4</td>
          <td>4</td>
          <td>12</td>
        </tr>
        <tr>
          <td>H1</td>
          <td>T2</td>
          <td>4</td>
          <td>4</td>
          <td>12</td>
        </tr>
        <tr>
          <td>H1</td>
          <td>T2</td>
          <td>4</td>
          <td>4</td>
          <td>12</td>
        </tr>
        <tr>
          <td>H1</td>
          <td>T2</td>
          <td>4</td>
          <td>4</td>
          <td>12</td>
        </tr>
        <tr>
          <td>H1</td>
          <td>T2</td>
          <td>4</td>
          <td>4</td>
          <td>12</td>
        </tr>
        <tr>
          <td>H1</td>
          <td>T2</td>
          <td>4</td>
          <td>4</td>
          <td>12</td>
        </tr>
        <tr>
          <td>H1</td>
          <td>T2</td>
          <td>4</td>
          <td>4</td>
          <td>12</td>
        </tr>
        <tr>
          <td>H1</td>
          <td>T2</td>
          <td>4</td>
          <td>4</td>
          <td>12</td>
        </tr>
        <tr>
          <td>H1</td>
          <td>T2</td>
          <td>4</td>
          <td>4</td>
          <td>12</td>
        </tr>
      </table>
    </div>

    <div>
      <button id="boton-id-ocultar" class="margin-left-body">Ocultar</button>
    </div>
  </body>
</html>
