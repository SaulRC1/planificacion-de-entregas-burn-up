<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="ventana-eliminar-tarea" class="ventana-tarea-delete roboto-condensed flexbox-column flexbox-justify-start">

    <div class="ventana-ajustes-de-proyecto-title flexbox-column flexbox-justify-center flex-align-center">
        <p class="roboto-condensed" >Eliminar Tarea</p>
    </div>

    <form id="form-delete-tarea" class="tarea-delete-form-style roboto-condensed flexbox-column flexbox-justify-evenly"
          method="POST" action="${pageContext.request.contextPath}/tarea-service/delete">

        <label>Selecciona la Tarea que desee borrar:</label>
        <select id="select-tarea-delete" name="select-tarea-delete">
            <c:forEach var="historia" items="${historiasDeUsuario}">
                <c:forEach var="tarea" items="${historia.listaDeTareas}">
                    <option value="${tarea.idTarea}">${tarea.nombreDeTarea}</option>
                </c:forEach>
            </c:forEach>
        </select>
    </form>

    <div class="tarea-delete-buttons-div flexbox-row flexbox-justify-center flex-align-center">
        <input type="submit" form="form-delete-tarea" value="Eliminar" class="floating-window-button tarea-delete-buttons roboto-condensed">
        <button id="boton-cancelar-delete-tarea" type="button" class="floating-window-button tarea-delete-buttons roboto-condensed">Cancelar</button>
    </div>
</div>

