<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="ventana-historia-edit roboto-condensed flexbox-column flexbox-justify-start">
    
    <form id="form-edit-historia" method="GET" action="${pageContext.request.contextPath}/ventana-de-historia">
        <!-- Sección de la recogida de datos de la Historia -->
        <div id="user-div">
            <label>¿Qué historia quieres editar?: </label>
            <input id="nombre-historia-edit" name="nombre-historia-edit" type="text" required/>
        </div>
        
        <input type="submit" value="Editar">
    </form>
        
</div>

