//############################## LISTENERS ###########################

document.getElementById("boton-añadir-historia").addEventListener("click", () => {
    
    let ventanaHistoria = document.getElementsByClassName("ventana-historia")[0];
    
    ventanaHistoria.style.display = "flex";
    
});

document.getElementById("boton-editar-historia").addEventListener("click", () => {
    
    let floatWindowBackground = document.getElementById("float-window-background");
    let ventanaHistoriaEdit = document.getElementsByClassName("ventana-historia-edit")[0];
    
    ventanaHistoriaEdit.style.display = "flex";
    floatWindowBackground.style.display = "flex";
    
    
});

document.getElementById("boton-eliminar-historia").addEventListener("click", () => {
    
    let floatWindowBackground = document.getElementById("float-window-background");
    let ventanaHistoriaDelete = document.getElementsByClassName("ventana-historia-delete")[0];
    
    ventanaHistoriaDelete.style.display = "flex";
    floatWindowBackground.style.display = "flex";
    
    
});

document.getElementById("boton-editar-tarea").addEventListener("click", () => {
    
    let floatWindowBackground = document.getElementById("float-window-background");
    let ventanaTareaEdit = document.getElementsByClassName("ventana-tarea-edit")[0];
    
    ventanaTareaEdit.style.display = "flex";
    floatWindowBackground.style.display = "flex";
    
    
});

document.getElementById("boton-eliminar-tarea").addEventListener("click", () => {
    
    let floatWindowBackground = document.getElementById("float-window-background");
    let ventanaTareaDelete = document.getElementsByClassName("ventana-tarea-delete")[0];
    
    ventanaTareaDelete.style.display = "flex";
    floatWindowBackground.style.display = "flex";
    
    
});

document.getElementById("boton-ajustes-proyecto").addEventListener("click", () => {
   
    let floatWindowBackground = document.getElementById("float-window-background");
    
    let projectName = getProjectNameFromURL(window.location.href);
    
    let host = window.location.host;
   
    let getURL = "http://" + host + "/proyecto-service/" + projectName;
            
    $.ajax({
        url: getURL,
        method: 'GET',
        success: (data, textStatus, jqXHR) => {processProjectData(data, textStatus, jqXHR);},
        error: function(jqXHR, textStatus, errorThrown) {alert(textStatus);}
    });
    
    if(floatWindowBackground.style.display === "flex") {
        
        floatWindowBackground.style.display = "none";
    
    } else {
        
        floatWindowBackground.style.display = "flex";
        
        let ventanaAjustesProyecto = document.getElementById("ventana-ajustes-de-proyecto");
        
        ventanaAjustesProyecto.style.display = "flex";
    }
    
});



//############################# FUNCIONES #############################
function getProjectNameFromURL(url) {
    
    let splitURL = url.split("/");
    
    let projectName = splitURL[splitURL.length - 1];
    
    return projectName;
    
}

function processProjectData(data, textStatus, jqXHR) {
    
    let idInput = document.getElementById("ajustes-id-proyecto-input");
    let nombreInput = document.getElementById("ajustes-nombre-proyecto-input");
    let duracionInput = document.getElementById("ajustes-duracion-sprint-proyecto-input");
    let velocidadInput = document.getElementById("ajustes-velocidad-proyecto-input");
    
    idInput.value = data.idProyecto;
    nombreInput.value = data.nombreDeProyecto;
    duracionInput.value = data.duracionDelSprint;
    velocidadInput.value = data.velocidadDelEquipo;
    
}