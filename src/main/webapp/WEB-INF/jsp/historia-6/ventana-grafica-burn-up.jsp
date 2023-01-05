<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
    uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Gráfica Burn-Up ${proyecto.nombreDeProyecto}</title>
            <link
                rel="stylesheet"
                type="text/css"
                href="${pageContext.request.contextPath}/css/historia-6/ventana-grafica-burn-up.css" />
            <link
                rel="stylesheet"
                type="text/css"
                href="${pageContext.request.contextPath}/css/clases-comunes/flexbox.css" />
            <link
                rel="stylesheet"
                type="text/css"
                href="${pageContext.request.contextPath}/css/clases-comunes/fuentes.css" />
            <link
                rel="stylesheet"
                type="text/css"
                href="${pageContext.request.contextPath}/css/clases-comunes/botones.css" />
            <script
                src="${pageContext.request.contextPath}/js/jquery-3.6.3.min.js"
            defer></script>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> 
        </head>
        <body>
            <div class="main-div flexbox-column flexbox-justify-start">

                <div class="div-titulo flexbox-row flex-align-center flexbox-justify-center">
                    <p class="roboto-condensed">Gráfico Burn-Up ${proyecto.nombreDeProyecto}</p>
                </div>

                <div id="grafico-burn-up" >

                </div>

                <div class="project-planification-div flexbox-row flexbox-justify-end flex-align-center">

                    <button id="velocidad-optimista-button" type="button" class="action-button roboto-condensed project-button project-action-button">
                        Gráfico Velocidad Optimista
                    </button>

                    <button id="velocidad-prevista-button" type="button" class="action-button roboto-condensed project-button project-action-button">
                        Gráfico Velocidad Prevista
                    </button>

                    <button id="velocidad-pesimista-button" type="button" class="action-button roboto-condensed project-button project-action-button">
                        Gráfico Velocidad Pesimista
                    </button>

                    <button id="volver-button" type="button" class="action-button roboto-condensed project-button project-action-button">
                        Volver
                    </button>

                    <button id="convertir-imagen-button" type="button" class="action-button roboto-condensed project-button project-action-button">
                        Convertir en imagen
                    </button>

                </div>

                <script>
                    google.charts.load('current', {packages: ['corechart']});
                    google.charts.setOnLoadCallback(drawChart);

                    let chart;

                    function drawChart() {

                        let nombreProyecto = getProjectNameFromURL(window.location.href);

                        let url = window.location.origin + "/proyecto-service/" + nombreProyecto;

                        let historiasDeUsuario;

                        let velocidadDelEquipo;

                        $.ajax({
                            url: url,
                            method: 'GET',
                            success: (data, textStatus, jqXHR) => {

                                historiasDeUsuario = data.historiasDeUsuario;
                                velocidadDelEquipo = data.velocidadDelEquipo;
                            },
                            error: function (jqXHR, textStatus, errorThrown) {/*alert(textStatus);*/
                            },
                            async: false
                        });

                        let esfuerzoArray = [
                            ['Sprints', 'Esfuerzo']
                        ];

                        let esfuerzoTotal = 0;

                        for (let i = 0; i < historiasDeUsuario.length; i++) {
                            let listaTareas = historiasDeUsuario[i].listaDeTareas;

                            for (let j = 0; j < listaTareas.length; j++) {

                                esfuerzoTotal += listaTareas[j].esfuerzo;

                                esfuerzoArray.push([esfuerzoTotal / velocidadDelEquipo, esfuerzoTotal]);
                            }
                        }

                        console.log("Sprints: " + (esfuerzoTotal / velocidadDelEquipo));

                        var dataGraph = google.visualization.arrayToDataTable(esfuerzoArray);

                        var options = {
                            title: 'Gráfico Burn-Up Velocidad Prevista',
                            hAxis: {title: 'Sprints'},
                            vAxis: {title: 'Product Backlog en esfuerzo estimado'},
                            legend: 'none'
                        };

                        chart = new google.visualization.LineChart(document.getElementById('grafico-burn-up'));
                        chart.draw(dataGraph, options);
                    }

                    function getProjectNameFromURL(url) {

                        let splitURL = url.split("/");

                        let projectName = splitURL[splitURL.length - 1];

                        return projectName;

                    }

                    document.getElementById("convertir-imagen-button").addEventListener("click", () => {
                        var imgUri = chart.getImageURI();

                        window.open(imgUri, '_blank').focus();
                    });
                    
                    document.getElementById("volver-button").addEventListener("click", () => {
                        window.location.href = window.location.origin + "/ventana-de-proyecto/" + getProjectNameFromURL(window.location.href);
                    });

                    document.getElementById("velocidad-prevista-button").addEventListener("click", () => {

                        drawChart();

                    });

                    document.getElementById("velocidad-optimista-button").addEventListener("click", () => {
                        let nombreProyecto = getProjectNameFromURL(window.location.href);

                        let url = window.location.origin + "/proyecto-service/" + nombreProyecto;

                        let historiasDeUsuario;

                        let velocidadDelEquipoOptimista;

                        $.ajax({
                            url: url,
                            method: 'GET',
                            success: (data, textStatus, jqXHR) => {

                                historiasDeUsuario = data.historiasDeUsuario;
                                velocidadDelEquipoOptimista = data.velocidadDelEquipo + (data.velocidadDelEquipo * 0.2);
                            },
                            error: function (jqXHR, textStatus, errorThrown) {/*alert(textStatus);*/
                            },
                            async: false
                        });

                        let esfuerzoArray = [
                            ['Sprints', 'Esfuerzo']
                        ];

                        let esfuerzoTotal = 0;

                        for (let i = 0; i < historiasDeUsuario.length; i++) {
                            let listaTareas = historiasDeUsuario[i].listaDeTareas;

                            for (let j = 0; j < listaTareas.length; j++) {

                                esfuerzoTotal += listaTareas[j].esfuerzo;

                                esfuerzoArray.push([esfuerzoTotal / velocidadDelEquipoOptimista, esfuerzoTotal]);
                            }
                        }

                        console.log("Sprints: " + (esfuerzoTotal / velocidadDelEquipoOptimista));

                        var dataGraph = google.visualization.arrayToDataTable(esfuerzoArray);

                        var options = {
                            title: 'Gráfico Burn-Up Velocidad Optimista',
                            hAxis: {title: 'Sprints'},
                            vAxis: {title: 'Product Backlog en esfuerzo estimado'},
                            legend: 'none',
                            series: {
                                0: {color: 'green'}
                            }

                        };

                        chart = new google.visualization.LineChart(document.getElementById('grafico-burn-up'));
                        chart.draw(dataGraph, options);
                    });

                    document.getElementById("velocidad-pesimista-button").addEventListener("click", () => {
                        let nombreProyecto = getProjectNameFromURL(window.location.href);

                        let url = window.location.origin + "/proyecto-service/" + nombreProyecto;

                        let historiasDeUsuario;

                        let velocidadDelEquipoPesimista;

                        $.ajax({
                            url: url,
                            method: 'GET',
                            success: (data, textStatus, jqXHR) => {

                                historiasDeUsuario = data.historiasDeUsuario;
                                velocidadDelEquipoPesimista = data.velocidadDelEquipo - (data.velocidadDelEquipo * 0.2);
                            },
                            error: function (jqXHR, textStatus, errorThrown) {/*alert(textStatus);*/
                            },
                            async: false
                        });

                        let esfuerzoArray = [
                            ['Sprints', 'Esfuerzo']
                        ];

                        let esfuerzoTotal = 0;

                        for (let i = 0; i < historiasDeUsuario.length; i++) {
                            let listaTareas = historiasDeUsuario[i].listaDeTareas;

                            for (let j = 0; j < listaTareas.length; j++) {

                                esfuerzoTotal += listaTareas[j].esfuerzo;

                                esfuerzoArray.push([esfuerzoTotal / velocidadDelEquipoPesimista, esfuerzoTotal]);
                            }
                        }

                        console.log("Sprints: " + (esfuerzoTotal / velocidadDelEquipoPesimista));

                        var dataGraph = google.visualization.arrayToDataTable(esfuerzoArray);

                        var options = {
                            title: 'Gráfico Burn-Up Velocidad Pesimista',
                            hAxis: {title: 'Sprints'},
                            vAxis: {title: 'Product Backlog en esfuerzo estimado'},
                            legend: 'none',
                            series: {
                                0: {color: 'red'}
                            }
                        };

                        chart = new google.visualization.LineChart(document.getElementById('grafico-burn-up'));
                        chart.draw(dataGraph, options);
                    });
                </script>

            </div>
        </body>
    </html>
