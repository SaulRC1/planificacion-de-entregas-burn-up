<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="ventana-add-tarea" class="ventana-tarea roboto-condensed flexbox-column flexbox-justify-start">

    <div class="ventana-ajustes-de-proyecto-title flexbox-column flexbox-justify-center flex-align-center">
        <p class="roboto-condensed" >Añadir Tarea</p>
    </div>

    <form id="form-add-tarea" class="ajustes-proyecto-form-style flexbox-column flexbox-justify-evenly" method="post" action="${pageContext.request.contextPath}/tarea-service/save">

        <input id="id-historia-add-tarea" name="id-historia-add-tarea" type="text" style="display: none;">
        
        <label>Historia a la que pertenece: </label>
        <select id="select-add-tarea" name="select-add-tarea" required>
            <option value="default">Selecciona una historia</option>
            <c:forEach var="historia" items="${historiasDeUsuario}">
                <option value="${historia.idHistoriaDeUsuario}">
                    ${historia.nombreDeHistoria}
                </option>
            </c:forEach>
        </select>


        <label>Nombre de Tarea: </label>
        <input id="nombre-add-tarea" name="nombre-add-tarea" type="text" required/>



        <label>Prioridad: </label>
        <input id="prioridad-add-tarea" name="prioridad-add-tarea" type="number" required/>


        <label>Esfuerzo: </label>
        <input id="esfuerzo-add-tarea" name="esfuerzo-add-tarea" type="number" required/>


        <label>Descripción: </label>
        <textarea id="descripcion-add-tarea" name="descripcion-add-tarea" style="resize: none; font-size: 14px;" class="roboto-condensed"></textarea>
    </form>

    <div class="ajustes-de-proyecto-buttons-div flexbox-row flexbox-justify-center flex-align-center">
        <input type="submit" value="Añadir Tarea" form="form-add-tarea" class="floating-window-button ajustes-de-proyecto-buttons roboto-condensed">
        <button id="add-tarea-cancelar-button" type="button" class="floating-window-button ajustes-de-proyecto-buttons roboto-condensed">Cancelar</button>
    </div>

</div>

