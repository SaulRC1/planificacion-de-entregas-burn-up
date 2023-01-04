//############################## LISTENERS ###########################
document.getElementById("select-tarea-edit").addEventListener("change", () => {

    let idTarea = document.getElementById("select-tarea-edit").value;

    let url = window.location.origin + "/tarea-service/" + idTarea;

    $.ajax({
        url: url,
        method: 'GET',
        success: (data, textStatus, jqXHR) => {
            processTareaData(data, textStatus, jqXHR);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            let nombreTarea = document.getElementById("nombre-tarea-edit");
            let prioridadTarea = document.getElementById("prioridad-tarea-edit");
            let esfuerzoTarea = document.getElementById("esfuerzo-tarea-edit");
            let descripcionTarea = document.getElementById("descripcion-tarea-edit");

            nombreTarea.value = "";
            prioridadTarea.value = "";
            esfuerzoTarea.value = "";
            descripcionTarea.value = "";
        }
    });
});

document.getElementById("boton-cancelar-editar-tarea").addEventListener("click", () => {

    let floatWindowBackground = document.getElementById("float-window-background");
    let ventanaTareaEdit = document.getElementsByClassName("ventana-tarea-edit")[0];

    ventanaTareaEdit.style.display = "none";
    floatWindowBackground.style.display = "none";

});

document.getElementById("boton-cancelar-delete-tarea").addEventListener("click", () => {

    let floatWindowBackground = document.getElementById("float-window-background");
    let ventanaTareaDelete = document.getElementsByClassName("ventana-tarea-delete")[0];

    ventanaTareaDelete.style.display = "none";
    floatWindowBackground.style.display = "none";

});





//############################# FUNCIONES #############################
function processTareaData(data, textStatus, jqXHR) {

    let nombreTarea = document.getElementById("nombre-tarea-edit");
    let prioridadTarea = document.getElementById("prioridad-tarea-edit");
    let esfuerzoTarea = document.getElementById("esfuerzo-tarea-edit");
    let descripcionTarea = document.getElementById("descripcion-tarea-edit");

    nombreTarea.value = data.nombreDeTarea;
    prioridadTarea.value = data.prioridad;
    esfuerzoTarea.value = data.esfuerzo;
    descripcionTarea.value = data.descripcion;
}


function validarEditarTarea() {
    let tareaEdit = document.getElementById("select-tarea-edit");

    if (tareaEdit.value === "default") {
        alert("Selecciona una tarea");
        return false;
    }

    return true;
}