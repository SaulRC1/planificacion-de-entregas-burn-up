<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventana de Historia</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/historia-4/tarea-2-4/ventana-historia.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/clases-comunes/flexbox.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/clases-comunes/fuentes.css">
    </head>
    <body>
        <div class="roboto-condensed">
            <!-- Sección de la recogida de datos de la Historia -->
            <div id="user-div">
                <label>Usuario: </label>
                <input type="text"/>
            </div>

            <div>
                <label>Nombre de Historia: </label>
                <input type="text"/>
            </div>

            <div>
                <label>Valor aportado: </label>
                <input type="number"/>
            </div>

            <div id="description-div">
                <label>Descripción: </label>
                <input type="text"/>
            </div>
            <!--------------------------------->

            <!-- Botones para editar y eliminar la historia -->
            <div>
                <button type = "button" >Editar</button>
                <button type = "button" >Eliminar</button>
            </div>
            <!--------------------------------->

            <!-- Listado de las tareas y boton para crear una nueva -->
            <div>
                <br/><p>Tareas Asociadas: </p>
                <table id="listado-tareas" border="1">
                    <tr>
                        <th>Tarea</th>
                        <th>Prioridad</th>
                        <th>Esfuerzo</th>
                        <th>Descripción</th>
                    </tr>
                    <tr>
                        <td>T1.1</td>
                        <td>2</td>
                        <td>60</td>
                        <td>Tarea 1.1 destinada a la historia 1</td>
                    </tr>
                    <tr>
                        <td>T1.1</td>
                        <td>2</td>
                        <td>60</td>
                        <td>Tarea 1.1 destinada a la historia 1</td>
                    </tr>
                </table>
                
                <button type = "button" >Añadir nueva Tarea</button>
            </div>
            <!--------------------------------->
        </div>
    </body>
</html>
