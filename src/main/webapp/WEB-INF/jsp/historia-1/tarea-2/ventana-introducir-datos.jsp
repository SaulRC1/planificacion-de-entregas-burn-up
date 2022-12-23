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
      src="${pageContext.request.contextPath}/js/historia-1/tarea-1/ventana-pedir-datos.js"
      defer></script>
  </head>

  <body>
    <div>
      <label for="idnombre">Nombre</label>
      <input
        name="nombre"
        type="text"
        id="idnombre"
        placeholder="No se admiten espacios en blanco"
        required />
      <br />
      <label for="idduracion">Duración del sprint</label>
      <input
        name="duracion"
        type="number"
        id="idduracion"
        placeholder="No se admiten caracteres"
        required />
      <br />
      <label for="idvelocidad">Velocidad del equipo (puntos/sprint)</label>
      <input
        name="velocidad"
        type="number"
        id="idvelocidad"
        placeholder="No se admiten caracteres"
        required />
      <br />
      <button id="id-boton-cancelar-proyecto" type="button">Cancelar</button>
      <button id="id-boton-siguiente" type="button">Siguiente</button>
    </div>
  </body>
</html>
