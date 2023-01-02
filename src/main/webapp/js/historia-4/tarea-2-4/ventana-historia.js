//############################## LISTENERS ###########################

document.getElementById("select-edit").addEventListener("change", () => {
    
    let idHistoriaDeUsuario = document.getElementById("select-edit").value;
    
    let url = window.location.origin + "/historia-service/" + idHistoriaDeUsuario;
    
    $.ajax({
        url: url,
        method: 'GET',
        success: (data, textStatus, jqXHR) => {processHistoriaData(data, textStatus, jqXHR);},
        error: function(jqXHR, textStatus, errorThrown) {alert(textStatus);}
    });
});


document.getElementById("id-boton-cancelar-editar-historia").addEventListener("click", () => {
    
    let floatWindowBackground = document.getElementById("float-window-background");

    floatWindowBackground.style.display = "none";
    
    
});



//############################# FUNCIONES #############################
function processHistoriaData(data, textStatus, jqXHR){
    
    
    let usuarioHistoria = document.getElementById("usuario-historia-edit");
    let nombreHistoria = document.getElementById("nombre-historia-edit");
    let valorHistoria = document.getElementById("valor-historia-edit");
    let descripcionHistoria = document.getElementById("descripcion-edit");
    
    usuarioHistoria.value = data.usuario;
    nombreHistoria.value = data.nombreDeHistoria;
    valorHistoria.value = data.valorAportado;
    descripcionHistoria.value = data.descripcion;
}