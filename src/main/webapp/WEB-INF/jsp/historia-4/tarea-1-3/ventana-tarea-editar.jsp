<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="ventana-editar-tarea" class="ventana-tarea-edit roboto-condensed flexbox-column flexbox-justify-start">

    <div class="ventana-ajustes-de-proyecto-title flexbox-column flexbox-justify-center flex-align-center">
        <p class="roboto-condensed" >Editar Tarea</p>
    </div>

    <form id="form-edit-tarea" class="tarea-edit-form-style roboto-condensed flexbox-column flexbox-justify-evenly"
          method="POST" action="${pageContext.request.contextPath}/tarea-service/update">

        <label>Tarea a editar:</label>
        <select id="select-tarea-edit" name="select-tarea-edit">
            <c:forEach var="historia" items="${historiasDeUsuario}">
                <c:forEach var="tarea" items="${historia.listaDeTareas}">
                        <option value="${tarea.idTarea}">${tarea.nombreDeTarea}</option>
                </c:forEach>
            </c:forEach>
        </select>

        <label>Nombre:</label>
        <input id="nombre-tarea-edit" name="nombre-tarea-edit" type="text"/>


        <label>Prioridad:</label>
        <input id="prioridad-tarea-edit" name="prioridad-tarea-edit" type="number"/>


        <label>Esfuerzo:</label>
        <input id="esfuerzo-tarea-edit" name="esfuerzo-tarea-edit" type="number"/>


        <p>Descripción:</p>
        <textarea id="descripcion-tarea-edit" name="descripcion-tarea-edit" class="roboto-condensed"></textarea>
    </form>

    <div class="tarea-edit-buttons-div flexbox-row flexbox-justify-center flex-align-center">
        <input type="submit" form="form-edit-tarea" value="Editar" class="floating-window-button tarea-edit-buttons roboto-condensed">
        <button id="boton-cancelar-editar-tarea" type="button" class="floating-window-button tarea-edit-buttons roboto-condensed">Cancelar</button>
    </div>
</div>

