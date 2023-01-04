document.getElementById("id-boton-planificar").addEventListener("click", () => {
    
    window.location.href = window.location.origin + "/planificacion/" + getProjectNameFromURL(window.location.href);
    
});
