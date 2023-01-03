<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="ventana-eliminar-historia" class="ventana-historia-delete roboto-condensed flexbox-column flexbox-justify-start">

    <div class="ventana-ajustes-de-proyecto-title flexbox-column flexbox-justify-center flex-align-center">
        <p class="roboto-condensed" >Eliminar Historia</p>
    </div>

    <form id="form-delete-historia" class="historia-delete-form-style roboto-condensed flexbox-column flexbox-justify-evenly"
          method="POST" action="${pageContext.request.contextPath}/historia-service/delete">

        <label>Selecciona la Tarea que desee borrar:</label>
        <select id="select-historia-delete" name="select-tarea-delete">
            <c:forEach var="historia" items="${historiasDeUsuario}">
                <option value="${historia.idHistoriaDeUsuario}">${historia.nombreDeHistoria}</option>
            </c:forEach>
        </select>
    </form>

    <div class="historia-delete-buttons-div flexbox-row flexbox-justify-center flex-align-center">
        <input type="submit" form="form-delete-historia" value="Eliminar" class="floating-window-button historia-delete-buttons roboto-condensed">
        <button id="boton-cancelar-delete-historia" type="button" class="floating-window-button historia-delete-buttons roboto-condensed">Cancelar</button>
    </div>
</div>

