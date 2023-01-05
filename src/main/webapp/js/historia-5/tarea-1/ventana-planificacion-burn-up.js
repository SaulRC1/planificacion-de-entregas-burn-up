function getProjectNameFromURL(url) {
    
    let splitURL = url.split("/");
    
    let projectName = splitURL[splitURL.length - 1];
    
    return projectName;
}

document.getElementById("id-boton-volver").addEventListener("click", () => {
    
    window.location.href = window.location.origin + "/ventana-de-proyecto/" + getProjectNameFromURL(window.location.href);
    
});
