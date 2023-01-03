<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="ventana-add-historia" class="ventana-historia roboto-condensed flexbox-column flexbox-justify-start">

    <div class="ventana-ajustes-de-proyecto-title flexbox-column flexbox-justify-center flex-align-center">
        <p class="roboto-condensed" >Añadir Historia</p>
    </div>

    <form id="form-add-historia" class="ajustes-proyecto-form-style flexbox-column flexbox-justify-evenly" method="post" action="${pageContext.request.contextPath}/historia-service/save">
        
        <input name="id-proyecto" type="text" style="display: none;" value="${proyecto.idProyecto}">
        
        <label>Usuario: </label>
        <input id="usuario-historia" name="usuario-historia" type="text" required/>


        <label>Nombre de Historia: </label>
        <input id="nombre-historia" name="nombre-historia" type="text" required/>



        <label>Valor aportado: </label>
        <input id="valor-historia" name="valor-historia" type="number" required/>



        <label>Descripción: </label>
        <textarea id="description" name="descripcion" style="resize: none; font-size: 14px;" class="roboto-condensed"></textarea>
    </form>

    <div class="ajustes-de-proyecto-buttons-div flexbox-row flexbox-justify-center flex-align-center">
        <input type="submit" value="Añadir Historia" form="form-add-historia" class="floating-window-button ajustes-de-proyecto-buttons roboto-condensed">
        <button id="add-historia-cancelar-button" type="button" class="floating-window-button ajustes-de-proyecto-buttons roboto-condensed">Cancelar</button>
    </div>

</div>

