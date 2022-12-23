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
      src="${pageContext.request.contextPath}/js/historia-5/tarea-1/ventana-vista-general.js"
      defer></script>
    <link
      rel="stylesheet"
      type="text/css"
      href="${pageContext.request.contextPath}/css/historia-5/tarea-1/estilo-ventana-vista-general.css" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet" />
  </head>

  <body>
    <div></div>

    <div>
      <table id="listado-tareas" border="1">
        <tr>
          <th>Historia de Usuario</th>
          <th>Valor</th>
          <th>Tarea</th>
          <th>Prioridad</th>
          <th>Metrica de viabilidad(valor*prioridad)</th>
          <th>Esfuerzo</th>
        </tr>
        <tr>
          <td>H1</td>
          <td>2</td>
          <td>T1</td>
          <td>2</td>
          <td>4</td>
          <td>9</td>
        </tr>
        <tr>
          <td>H1</td>
          <td>2</td>
          <td>T2</td>
          <td>6</td>
          <td>5</td>
          <td>10</td>
        </tr>
      </table>
    </div>
  </body>
</html>
