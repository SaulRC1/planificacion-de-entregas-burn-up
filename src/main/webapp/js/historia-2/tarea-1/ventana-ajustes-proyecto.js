//##################################### EVENTOS ##############################################

document.getElementById("ajustes-proyect-cancelar-button").addEventListener("click", () => {
    
    let floatWindowBackground = document.getElementById("float-window-background");
    
    floatWindowBackground.style.display = "none";
    
    let ventanaAjustesProyecto = document.getElementById("ventana-ajustes-de-proyecto");
        
    ventanaAjustesProyecto.style.display = "none";
    
});
