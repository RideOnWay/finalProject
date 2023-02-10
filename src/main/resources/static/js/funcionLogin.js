function validar(){
    
    let name = document.getElementById("name").value;
    let clave = document.getElementById("clave").value;

    
alert(location.href);
    if(name== "user" && clave == "password"){
        window.location.assign( "C:/Users/luna/OneDrive/Documentos/SENA-ALEJO/proyectoWeb/ventas.html");
        alert("i");
    }else{
        alert("no way");
    }
}