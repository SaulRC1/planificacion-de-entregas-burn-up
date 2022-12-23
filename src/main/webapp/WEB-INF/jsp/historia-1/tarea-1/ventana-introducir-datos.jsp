<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@tagliburi="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link
      rel="stylesheet"
      type="text/css"
      href="${pageContext.request.contextPath}/css/historia-1/tarea-1/estilo-ventana-pedir-datos.css" />
  </head>
  <body>
    <div class="posicionamiento">
      <div>
        <label class="margin-top bold" for="idnombre">Nombre</label>
        <input
          class="tamanio-input"
          name="nombre"
          type="text"
          id="idnombre"
          placeholder="No se admiten espacios en blanco"
          required />
      </div>
      <br />
      <div>
        <label class="margin-top bold" for="idduracion"
          >Duración del sprint</label
        >
        <input
          class="tamanio-input"
          name="duracion"
          type="number"
          id="idduracion"
          placeholder="No se admiten caracteres"
          required />
      </div>
      <br />
      <div>
        <label class="margin-top bold" for="idvelocidad"
          >Velocidad del equipo (puntos/sprint)</label
        >
        <input
          class="tamanio-input"
          name="velocidad"
          type="number"
          id="idvelocidad"
          placeholder="No se admiten caracteres"
          required />
      </div>
      <br />
      <button id="id-boton-cancelar-proyecto" type="button">Cancelar</button>
      <button id="id-boton-siguiente" type="button">Siguiente</button>
    </div>
  </body>
</html>
