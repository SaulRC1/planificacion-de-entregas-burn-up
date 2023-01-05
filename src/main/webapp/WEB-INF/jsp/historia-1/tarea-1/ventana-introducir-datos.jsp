<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@tagliburi="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div
  class="ventana-introducir-datos roboto-condensed flexbox-column flexbox-justify-start">
  <div
    class="ventana-introducir-datos-title flexbox-column flexbox-justify-center flex-align-center">
    <p class="roboto-condensed">Introducir Datos</p>
  </div>
  <form
    class="introducir-datos-form-style roboto-condensed flexbox-column flexbox-justify-evenly"
    method="post"
    action="${pageContext.request.contextPath}/ventana-pedir-datos">
    <label class="roboto-condensed" for="idnombre">Nombre</label>
    <input
      class="roboto-condensed"
      name="nombre"
      type="text"
      id="idnombre"
      placeholder="No se admiten espacios en blanco"
      required />

    <label class="roboto-condensed" for="idduracion"
      >Duración del sprint(semanas)</label
    >
    <input
      class="roboto-condensed"
      name="duracion"
      type="number"
      id="idduracion"
      placeholder="No se admiten caracteres"
      required />

    <label class="roboto-condensed" for="idvelocidad"
      >Velocidad del equipo (puntos/sprint)</label
    >
    <input
      class="roboto-condensed"
      name="velocidad"
      type="number"
      id="idvelocidad"
      placeholder="No se admiten caracteres"
      required />

    <div
      class="historia-introducir-datos-div flexbox-row flexbox-justify-center flex-align-center">
      <input
        id="id-boton-siguiente"
        class="floating-window-button introducir-datos-buttons roboto-condensed"
        type="submit"
        value="Siguiente" />
      <button
        class="floating-window-button introducir-datos-buttons roboto-condensed"
        id="id-boton-cancelar-proyecto"
        type="button">
        Cancelar
      </button>
    </div>
  </form>
</div>
