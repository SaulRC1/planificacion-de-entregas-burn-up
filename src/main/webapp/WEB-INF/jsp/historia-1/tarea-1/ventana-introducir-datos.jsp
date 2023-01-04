<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@tagliburi="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="flexbox-column flexbox-justify-start ventana-introducir-datos">
  <form
    class="roboto-condensed flexbox-column flexbox-justify-evenly"
    method="post"
    action="${pageContext.request.contextPath}/ventana-pedir-datos">
    <div class="posicionamiento">
      <div>
        <label class="margin-top bold" for="idnombre">Nombre</label>
        <input
          class="tamanio-input1 roboto-condensed"
          name="nombre"
          type="text"
          id="idnombre"
          placeholder="No se admiten espacios en blanco"
          required />
      </div>
      <br />
      <div>
        <label class="margin-top bold" for="idduracion"
          >Duración del sprint(semanas)</label
        >
        <input
          class="tamanio-input2 roboto-condensed"
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
          class="tamanio-input3 roboto-condensed"
          name="velocidad"
          type="number"
          id="idvelocidad"
          placeholder="No se admiten caracteres"
          required />
      </div>
      <br />
      <button id="id-boton-cancelar-proyecto" type="button">Cancelar</button>
      <input
        id="id-boton-siguiente"
        class="roboto-condensed"
        type="submit"
        value="Siguiente" />
    </div>
  </form>
</div>
