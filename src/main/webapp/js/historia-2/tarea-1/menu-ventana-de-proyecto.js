//############################## LISTENERS ###########################

document.getElementById("boton-añadir-historia").addEventListener("click", () => {
    
    let ventanaHistoria = document.getElementsByClassName("ventana-historia")[0];
    
    ventanaHistoria.style.display = "flex";
    
});

document.getElementById("boton-ajustes-proyecto").addEventListener("click", () => {
   
    let floatWindowBackground = document.getElementById("float-window-background");
    
    if(floatWindowBackground.style.display === "flex") {
        
        floatWindowBackground.style.display = "none";
    
    } else {
        
        floatWindowBackground.style.display = "flex";
    }
    
});



//############################# FUNCIONES #############################
