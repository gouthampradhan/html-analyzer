function analyze() {
    var url = document.getElementById("url").value;
    var json = getMetadata(url);
     $("#tab-metadata tr").remove();
     $("#tab-heading tr").remove();
     $("#tab-links tr").remove();

     $("#metadata").append("<tr><td>Html Version: </td><td>" + json.htmlVersion + "</td></tr>");
     $("#metadata").append("<tr><td>Title: </td><td>" + json.title + "</td></tr>");
     $("#metadata").append("<tr><td>Has Login: </td><td>" + json.hasLogin + "</td></tr>");
     $("#heading").append("<tr><td>H1: </td><td>" + json.h1Count + "</td></tr>");
     $("#heading").append("<tr><td>H2: </td><td>" + json.h2Count + "</td></tr>");
     $("#heading").append("<tr><td>H3: </td><td>" + json.h3Count + "</td></tr>");
     $("#heading").append("<tr><td>H4: </td><td>" + json.h4Count + "</td></tr>");
     $("#heading").append("<tr><td>H5: </td><td>" + json.h5Count + "</td></tr>");
     $("#heading").append("<tr><td>H6: </td><td>" + json.h6Count + "</td></tr>");
     $("#links").append("<tr><td>Internal: </td><td>" + json.internalLinks + "</td></tr>");
     $("#links").append("<tr><td>External: </td><td>" + json.externalLinks + "</td></tr>");
}

function getMetadata(url){
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "/rest/metadata?url=" + url, false);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    return JSON.parse(xhttp.responseText);
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#submit" ).click(function() { analyze(); });
});

