<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ventana-historia-edit roboto-condensed flexbox-column flexbox-justify-start">

    <div class="ventana-ajustes-de-proyecto-title flexbox-column flexbox-justify-center flex-align-center">
        <p class="roboto-condensed" >Editar Historia</p>
    </div>

    <form id="form-edit-historia" class="tarea-edit-form-style roboto-condensed flexbox-column flexbox-justify-evenly"
          method="POST" action="${pageContext.request.contextPath}/historia-service/update">

        <label>¿Qué historia quieres editar?: </label>
        <select name="select-edit" id="select-edit" required>
            <c:forEach var="historia" items="${historiasDeUsuario}">
                <option value="${historia.idHistoriaDeUsuario}">${historia.nombreDeHistoria}</option>
            </c:forEach>
        </select>

        <label>Usuario: </label>
        <input id="usuario-historia-edit" name="usuario-historia-edit" value="${historiasDeUsuario.get(0).usuario}" type="text" required/>

        
        <label>Nombre de Historia: </label>
        <input id="nombre-historia-edit" name="nombre-historia-edit" value="${historiasDeUsuario.get(0).nombreDeHistoria}" type="text" required/>

        
        <label>Valor aportado: </label>
        <input id="valor-historia-edit" name="valor-historia-edit" value="${historiasDeUsuario.get(0).valorAportado}" type="number" required/>

        
        <label>Descripción: </label>
        <textarea id="descripcion-edit" name="descripcion-edit">${historiasDeUsuario.get(0).descripcion}</textarea>
    </form>

    <div class="historia-edit-buttons-div flexbox-row flexbox-justify-center flex-align-center">
        <input type="submit" value="Editar" form="form-edit-historia" class="floating-window-button historia-edit-buttons roboto-condensed">
        <button id="id-boton-cancelar-editar-historia" class="floating-window-button historia-edit-buttons roboto-condensed" type="button">Cancelar</button>
    </div>
</div>

          