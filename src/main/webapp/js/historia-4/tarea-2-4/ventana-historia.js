//############################## LISTENERS ###########################

document.getElementById("select-edit").addEventListener("change", () => {

    let idHistoriaDeUsuario = document.getElementById("select-edit").value;

    let url = window.location.origin + "/historia-service/" + idHistoriaDeUsuario;

    $.ajax({
        url: url,
        method: 'GET',
        success: (data, textStatus, jqXHR) => {
            processHistoriaData(data, textStatus, jqXHR);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            let usuarioHistoria = document.getElementById("usuario-historia-edit");
            let nombreHistoria = document.getElementById("nombre-historia-edit");
            let valorHistoria = document.getElementById("valor-historia-edit");
            let descripcionHistoria = document.getElementById("descripcion-edit");

            usuarioHistoria.value = "";
            nombreHistoria.value = "";
            valorHistoria.value = "";
            descripcionHistoria.value = "";
        }
    });
});


document.getElementById("id-boton-cancelar-editar-historia").addEventListener("click", () => {

    let floatWindowBackground = document.getElementById("float-window-background");
    let ventanaHistoriaEdit = document.getElementsByClassName("ventana-historia-edit")[0];

    ventanaHistoriaEdit.style.display = "none";
    floatWindowBackground.style.display = "none";
});


document.getElementById("boton-cancelar-delete-historia").addEventListener("click", () => {

    let floatWindowBackground = document.getElementById("float-window-background");
    let ventanaHistoriaDelete = document.getElementsByClassName("ventana-historia-delete")[0];

    ventanaHistoriaDelete.style.display = "none";
    floatWindowBackground.style.display = "none";
});


/**
 * Boton cancelar en la ventana "Añadir Historia"
 */
document.getElementById("add-historia-cancelar-button").addEventListener("click", () => {

    let floatWindowBackground = document.getElementById("float-window-background");

    floatWindowBackground.style.display = "none";

    let ventanaHistoria = document.getElementById("ventana-add-historia");

    ventanaHistoria.style.display = "none";

    cleanFormInputs();
});

/**
 * 
 */
document.getElementById("nombre-historia").addEventListener("change", () => {

    let nombreHistoria = document.getElementById("nombre-historia").value;

    let url = window.location.origin + "/historia-service/name/" + nombreHistoria;

    $.ajax({
        url: url,
        method: 'GET',
        success: (data, textStatus, jqXHR) => {
            checkIfHistoriaExists(data, textStatus, jqXHR);
        },
        error: function (jqXHR, textStatus, errorThrown) {/*alert(textStatus);*/
        }
    });

});

//############################# FUNCIONES #############################
function processHistoriaData(data, textStatus, jqXHR) {

    let usuarioHistoria = document.getElementById("usuario-historia-edit");
    let nombreHistoria = document.getElementById("nombre-historia-edit");
    let valorHistoria = document.getElementById("valor-historia-edit");
    let descripcionHistoria = document.getElementById("descripcion-edit");

    usuarioHistoria.value = data.usuario;
    nombreHistoria.value = data.nombreDeHistoria;
    valorHistoria.value = data.valorAportado;
    descripcionHistoria.value = data.descripcion;
}

function checkIfHistoriaExists(data, textStatus, jqXHR) {

    if (typeof data.nombreDeHistoria !== "undefined") {

        let nombreHistoria = document.getElementById("nombre-historia").value = "";

        alert("ERROR: Ya existe una historia con ese nombre");
    }

}

function cleanFormInputs() {

    let usuarioHistoria = document.getElementById("usuario-historia");
    let nombreHistoria = document.getElementById("nombre-historia");
    let valorHistoria = document.getElementById("valor-historia");
    let descripcionHistoria = document.getElementById("description");

    usuarioHistoria.value = "";
    nombreHistoria.value = "";
    valorHistoria.value = "";
    descripcionHistoria.value = "";
}

function validarEditarHistoria() {
    let historiaEdit = document.getElementById("select-edit");

    if (historiaEdit.value === "default") {
        alert("Selecciona una historia");
        return false;
    }

    return true;
}