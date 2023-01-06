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
            cleanTareaFormInputs();
        }
    });
});

document.getElementById("add-tarea-cancelar-button").addEventListener("click", () => {

    let floatWindowBackground = document.getElementById("float-window-background");
    let ventanaTarea = document.getElementsByClassName("ventana-tarea")[0];

    ventanaTarea.style.display = "none";
    floatWindowBackground.style.display = "none";

    cleanTareaFormInputs();
});

document.getElementById("boton-cancelar-editar-tarea").addEventListener("click", () => {

    let floatWindowBackground = document.getElementById("float-window-background");
    let ventanaTareaEdit = document.getElementsByClassName("ventana-tarea-edit")[0];

    ventanaTareaEdit.style.display = "none";
    floatWindowBackground.style.display = "none";

    cleanTareaEditFormInputs();
});

document.getElementById("boton-cancelar-delete-tarea").addEventListener("click", () => {

    let floatWindowBackground = document.getElementById("float-window-background");
    let ventanaTareaDelete = document.getElementsByClassName("ventana-tarea-delete")[0];

    ventanaTareaDelete.style.display = "none";
    floatWindowBackground.style.display = "none";

});

document.getElementById("nombre-add-tarea").addEventListener("change", () => {
    
    let idHistoriaDeTarea = document.getElementById("select-add-tarea").value;
    
    let nombreTarea = document.getElementById("nombre-add-tarea").value;

    let url = window.location.origin + "/tarea-service/name/" + nombreTarea + "?id-historia=" + idHistoriaDeTarea;

    $.ajax({
        url: url,
        method: 'GET',
        success: (data, textStatus, jqXHR) => {
            checkIfTareaExists(data, textStatus, jqXHR);
        },
        error: function (jqXHR, textStatus, errorThrown) {/*alert(textStatus);*/
        }
    });

});

document.getElementById("select-add-tarea").addEventListener("change", () => {

    let idHistoria = document.getElementById("select-add-tarea").value;

    let url = window.location.origin + "/historia-service/" + idHistoria;

    $.ajax({
        url: url,
        method: 'GET',
        success: (data, textStatus, jqXHR) => {
            let idHistoriaTareaAdd = document.getElementById("id-historia-add-tarea");
            idHistoriaTareaAdd.value = idHistoria;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            cleanTareaFormInputs();
        }
    });
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

function checkIfTareaExists(data, textStatus, jqXHR) {

    if (typeof data.nombreDeTarea !== "undefined") {

        let nombreTarea = document.getElementById("nombre-add-tarea").value = "";

        alert("ERROR: Ya existe una tarea con ese nombre");
        return true;
    }
    
    return false;
}

function validarEditarTarea() {
    let tareaEdit = document.getElementById("select-tarea-edit");

    if (tareaEdit.value === "default") {
        alert("Selecciona una tarea");
        return false;
    }

    return true;
}

function cleanTareaEditFormInputs() {

    let selectHistoria = document.getElementById("select-tarea-edit");
    let nombreTarea = document.getElementById("nombre-tarea-edit");
    let prioridadTarea = document.getElementById("prioridad-tarea-edit");
    let esfuerzoTarea = document.getElementById("esfuerzo-tarea-edit");
    let descripcionTarea = document.getElementById("descripcion-tarea-edit");

    selectHistoria.value = "default";
    nombreTarea.value = "";
    prioridadTarea.value = "";
    esfuerzoTarea.value = "";
    descripcionTarea.value = "";
}

function cleanTareaFormInputs() {

    let selectHistoria = document.getElementById("select-add-tarea");
    let nombreTarea = document.getElementById("nombre-add-tarea");
    let prioridadTarea = document.getElementById("prioridad-add-tarea");
    let esfuerzoTarea = document.getElementById("esfuerzo-add-tarea");
    let descripcionTarea = document.getElementById("descripcion-add-tarea");

    selectHistoria.value = "default";
    nombreTarea.value = "";
    prioridadTarea.value = "";
    esfuerzoTarea.value = "";
    descripcionTarea.value = "";
}

function validarAddTarea() {
    
    let historiaDeTarea = document.getElementById("select-add-tarea").value;
    
    if(historiaDeTarea === "default") {
        alert("Selecciona una historia, por favor.");
        return false;
    }
    
    let idHistoriaDeTarea = document.getElementById("select-add-tarea").value;
    
    let nombreTarea = document.getElementById("nombre-add-tarea").value;

    let url = window.location.origin + "/tarea-service/name/" + nombreTarea + "?id-historia=" + idHistoriaDeTarea;

    let existeTarea = false;
    
    $.ajax({
        url: url,
        method: 'GET',
        success: (data, textStatus, jqXHR) => {
            existeTarea = checkIfTareaExists(data, textStatus, jqXHR);
        },
        error: function (jqXHR, textStatus, errorThrown) {/*alert(textStatus);*/
        },
        async: false
    });
    
    if(existeTarea) {
        return false;
    }
    
    return true;
}