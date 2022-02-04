function requestPerson(){

    var personIin = document.getElementById("iin").value;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8080/search?iin=" + personIin);
    xmlhttp.send();
}

