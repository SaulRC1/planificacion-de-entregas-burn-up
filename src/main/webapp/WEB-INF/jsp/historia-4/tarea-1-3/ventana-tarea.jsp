<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventana de Tarea</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/historia-4/tarea-1-3/ventana-tarea.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/clases-comunes/flexbox.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/clases-comunes/fuentes.css">
        
        <script src="${pageContext.request.contextPath}/js/historia-4/tarea-1-3/ventana-tarea.js" defer></script>
    </head>
    <body>
        <div class="roboto-condensed">
            <div>
                <label>Historia a la que pertenece:</label>
                <select>
                    <option value=""></option>
                    <option value="Historia-1">Historia 1</option>
                    <option value="Historia-2">Historia 2</option>                 
                    <option value="Historia-3">Historia 3</option>                 
                </select>
            </div>
            
            <div>
                <label>Nombre:</label>
                <input type="text"/>
            </div>
            
            <div>
                <label>Prioridad:</label>
                <input type="number"/>
            </div>
            
            <div>
                <label>Esfuerzo:</label>
                <input type="number"/>
            </div>
            
            <div id="textarea-div">
                <p>Descripción:</p>
                <textarea class="roboto-condensed"></textarea>
            </div>
            
            <div>
                <button type = "button" id="boton-cancelarTarea">Cancelar</button>
                <button type = "button" id="boton-okTarea">OK</button>
            </div>
        </div>
    </body>
</html>
