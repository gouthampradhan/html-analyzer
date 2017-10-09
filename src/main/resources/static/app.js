function render() {
    var url = document.getElementById("url").value;
    var json = getMetadata(url);
    renderLinks(json.internalLinks + json.externalLinks);
    $("#tab-metadata tr").remove();
    $("#tab-heading tr").remove();
    $("#tab-link-count tr").remove();
    $("#tab-links tr").remove();
    //$("#metadata").append('<tr class="info"><th>METADATA</th></tr>');
    $("#metadata").append('<tr class="info"><th>HTML VERSION</th><th>TITLE</th><th>HAS LOGIN</th></tr>');
    $("#metadata").append('<tr><td>' + json.htmlVersion + '</td><td>'+ json.title +' </td><td>'
    + json.hasLogin +' </td></tr>');
    $("#metadata").append('<tr></tr>');
    //$("#heading").append('<tr class="info"><th>HEADINGS</th></tr>');
    $("#heading").append('<tr class="info"><th>HEADING H1</th><th>HEADING H2</th><th>HEADING H3</th><th>HEADING H4</th>'
    + '<th>HEADING H5</th><th>HEADING H6</th></tr>');
    $("#heading").append('<tr><td>' + json.h1Count +'</td><td>' + json.h2Count + '</td><td>'
    + json.h3Count +'</td><td>' + json.h4Count +'</td><td>' + json.h5Count +' </td><td>' + json.h6Count +' </td></tr>');
    $("#heading").append('<tr></tr>');
    //$("#links").append('<tr class="info"><th>LINK SUMMARY</th></tr>');
    $("#links").append('<tr class="info"><th>INTERNAL LINKS</th><th>EXTERNAL LINKS</th></tr>');
    $("#links").append('<tr><td>' + json.internalLinks + '</td><td>' + json.externalLinks +' </td></tr>');
    $("#links").append('<tr></tr>');
}

function renderLinks(totalLinks) {
    $('#pagination-container').pagination({
        dataSource: "/rest/links?url=" + document.getElementById("url").value,
        locator: 'links',
        totalNumber: totalLinks,
        pageSize: 10,
        ajax: {
            beforeSend: function() {
                $('#data-container').html('Loading data...');
            }
        },
        callback: function(data, pagination) {
            var html = simpleTemplating(data);
            $('#data-container').html(html);
        }
    })
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
    $( "#submit" ).click(function() { render(); });
});

function simpleTemplating(data) {
    var html = '<tr class="info"><th>LINK</th><th>REACHABLE</th><th>STATUS</th></tr>';
    $.each(data, function(index, item){
        html += '<tr>';
        html += '<td>'+ item.url +'</td>';
        html += '<td>'+ item.reachable +'</td>';
        html += '<td>'+ item.status +'</td>';
        html += '</tr>';
    });
    return html;
}

