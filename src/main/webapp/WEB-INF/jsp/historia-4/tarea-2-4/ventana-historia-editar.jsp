<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="ventana-historia-edit roboto-condensed flexbox-column flexbox-justify-start">

    <div class="ventana-ajustes-de-proyecto-title flexbox-column flexbox-justify-center flex-align-center">
        <p class="roboto-condensed" >Editar Historia</p>
    </div>
    
    <form id="form-edit-historia" method="POST" action="${pageContext.request.contextPath}/historia-service/update">
        <!-- Sección de la recogida de datos de la Historia -->
        <div id="user-div">
            <label>¿Qué historia quieres editar?: </label>
            <select name="select-edit" id="select-edit" required>
                <c:forEach var="historia" items="${historiasDeUsuario}">
                    <option value="${historia.idHistoriaDeUsuario}">${historia.nombreDeHistoria}</option>
                </c:forEach>
            </select>
        </div>

        <div id="user-div">
            <label>Usuario: </label>
            <input id="usuario-historia-edit" name="usuario-historia-edit" type="text" required/>
        </div>

        <div>
            <label>Nombre de Historia: </label>
            <input id="nombre-historia-edit" name="nombre-historia-edit" type="text" required/>
        </div>

        <div>
            <label>Valor aportado: </label>
            <input id="valor-historia-edit" name="valor-historia-edit" type="number" required/>
        </div>

        <div id="description-div">
            <label>Descripción: </label>
            <textarea id="descripcion-edit" name="descripcion-edit" ></textarea>
        </div>

        <button id="id-boton-cancelar-editar-historia" type="button">Cancelar</button>
        <input type="submit" value="Editar">
    </form>

</div>

