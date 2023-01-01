<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ventana-ajustes-de-proyecto flexbox-column flexbox-justify-start">

    <div class="ventana-ajustes-de-proyecto-title flexbox-column flexbox-justify-center flex-align-center">
        <p class="roboto-condensed" >Ajustes de proyecto</p>
    </div>

    <form id="ajustes-proyecto-form" class="ajustes-proyecto-form-style roboto-condensed flexbox-column flexbox-justify-evenly">

        <label >Nombre</label>
        <input type="text" class="roboto-condensed">

        <label>Duracion del sprint (semanas)</label>
        <input type="number" class="roboto-condensed">

        <label>Velocidad del equipo (puntos/sprint)</label>
        <input type="number" class="roboto-condensed">

    </form>
    
    <div class="ajustes-de-proyecto-buttons-div flexbox-row flexbox-justify-center flex-align-center">
        <input type="submit" form="ajustes-proyecto-form" value="Aceptar" class="floating-window-button ajustes-de-proyecto-buttons roboto-condensed">
        <button id="ajustes-proyect-cancelar-button" type="button" class="floating-window-button ajustes-de-proyecto-buttons roboto-condensed">Cancelar</button>
    </div>

</div>
