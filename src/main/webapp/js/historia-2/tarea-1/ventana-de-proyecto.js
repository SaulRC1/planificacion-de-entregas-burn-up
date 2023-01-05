document.getElementById("id-boton-planificar").addEventListener("click", () => {
    
    window.location.href = window.location.origin + "/planificacion/" + getProjectNameFromURL(window.location.href);
    
});


document.getElementById("generar-grafica-button").addEventListener("click", () => {
    window.location.href = window.location.origin + "/grafica-burn-up/" + getProjectNameFromURL(window.location.href);
});