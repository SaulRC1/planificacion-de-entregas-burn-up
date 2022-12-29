<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="ventana-historia roboto-condensed flexbox-column flexbox-justify-start">
    <form id="form-add-historia" method="post" action="${pageContext.request.contextPath}/ventana-de-historia">
        <!-- Sección de la recogida de datos de la Historia -->
        <div id="user-div">
            <label>Usuario: </label>
            <input id="usuario-historia" name="usuario-historia" type="text" required/>
        </div>

        <div>
            <label>Nombre de Historia: </label>
            <input id="nombre-historia" name="nombre-historia" type="text" required/>
        </div>

        <div>
            <label>Valor aportado: </label>
            <input id="valor-historia" name="valor-historia" type="number" required/>
        </div>

        <div id="description-div">
            <label>Descripción: </label>
            <textarea id="description" name="descripcion" ></textarea>
        </div>
        
        <input type="submit" value="Añadir Historia">
    </form>
</div>

