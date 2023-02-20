// Obtener referencias a la tabla y los labels


function editarProveedor(){
const tabla = document.getElementById('tablaProveedor');
const botonesVerDetalles = document.querySelectorAll('.btnEditar');
botonesVerDetalles.forEach(boton => {
  boton.addEventListener('click', function() {
   															 					// Obtener la fila correspondiente al botón
    const fila = boton.parentNode.parentNode;
	alert("Por favor verifique todos los datos antes de guardar");
    																			// Obtener los datos de la fila
    const idProveedor = fila.querySelector('td:nth-child(1)').textContent;
    const razonSocial = fila.querySelector('td:nth-child(2)').textContent;
    const nombreContacto = fila.querySelector('td:nth-child(3)').textContent;
    const correoProveedor = fila.querySelector('td:nth-child(5)').textContent;
    const numeroProveedor = fila.querySelector('td:nth-child(6)').textContent;
    const direccionProveedor = fila.querySelector('td:nth-child(7)').textContent;
    
    																			// Mostrar los datos en los labels correspondientes
    document.getElementById('idProveedor').value=idProveedor;
	document.getElementById('razonSocial').value=razonSocial ;
	document.getElementById('nombreContacto').value=nombreContacto ;
	document.getElementById('correoProveedor').value=correoProveedor;
	document.getElementById('numeroProveedorP').value=numeroProveedor ;
	document.getElementById('direccionProveedor').value=direccionProveedor ;
    
  });
});
}

function editarInsumo(){
  const tabla = document.getElementById('tablaInsumo');
  const botonesVerDetalles = document.querySelectorAll('.btnEditar');
  botonesVerDetalles.forEach(boton => {
    boton.addEventListener('click', function() {
                                              // Obtener la fila correspondiente al botón
      const fila = boton.parentNode.parentNode;
    alert("Por favor verifique todos los datos antes de guardar");
                                            // Obtener los datos de la fila
      const idInsumo = fila.querySelector('td:nth-child(1)').textContent;
      const nombreInsumo = fila.querySelector('td:nth-child(2)').textContent;
      const precioInsumo = fila.querySelector('td:nth-child(3)').textContent;
      
                                            // Mostrar los datos en los labels correspondientes
      document.getElementById('idInsumo').value=idInsumo;
    document.getElementById('nombreInsumo').value=nombreInsumo;
    document.getElementById('precioInsumo').value=precioInsumo;   
    });
  }); 
  }

  function editarProducto(){
    const tabla = document.getElementById('tablaProducto');
    const botonesVerDetalles = document.querySelectorAll('.btnEditar');
    botonesVerDetalles.forEach(boton => {
      boton.addEventListener('click', function() {
                                                // Obtener la fila correspondiente al botón
        const fila = boton.parentNode.parentNode;
      alert("Por favor verifique todos los datos antes de guardar");
                                              // Obtener los datos de la fila
        const idProducto = fila.querySelector('td:nth-child(1)').textContent;
        const nombreProducto = fila.querySelector('td:nth-child(2)').textContent;
        const precioProducto = fila.querySelector('td:nth-child(3)').textContent;
        const descripcionP = fila.querySelector('td:nth-child(7)').textContent;
        
                                              // Mostrar los datos en los labels correspondientes
      document.getElementById('idProducto').value=idProducto;
      document.getElementById('nombreProducto').value=nombreProducto;
      document.getElementById('precioProducto').value=precioProducto;
      document.getElementById('descripcionP').value=descripcionP;
        
      });
    });
    }

    function editarUsuario(){
      const tabla = document.getElementById('tablaUsuario');
      const botonesVerDetalles = document.querySelectorAll('.btnEditar');
      botonesVerDetalles.forEach(boton => {
        boton.addEventListener('click', function() {
                                                  // Obtener la fila correspondiente al botón
          const fila = boton.parentNode.parentNode;
        alert("Por favor verifique todos los datos antes de guardar");
                                                // Obtener los datos de la fila
          const idUsuario = fila.querySelector('td:nth-child(1)').textContent;
          const nombreUsuario = fila.querySelector('td:nth-child(2)').textContent;
          const correoUsuario = fila.querySelector('td:nth-child(5)').textContent;
          const numeroUsuario = fila.querySelector('td:nth-child(6)').textContent;
          const direccionUsuario = fila.querySelector('td:nth-child(7)').textContent;
          const descripcionUsuario = fila.querySelector('td:nth-child(8)').textContent;
          
                                                // Mostrar los datos en los labels correspondientes
          document.getElementById('idUsuario').value=idUsuario;
        document.getElementById('nombreUsuario').value=nombreUsuario;
        document.getElementById('correoUsuario').value=correoUsuario;
        document.getElementById('numeroUsuario').value=numeroUsuario;
        document.getElementById('direccionUsuario').value=direccionUsuario;
        document.getElementById('descripcionUsuario').value=descripcionUsuario;
          
        });
      });
      }

      function editarCliente(){
        const tabla = document.getElementById('tablaCliente');
        const botonesVerDetalles = document.querySelectorAll('.btnEditar');
        botonesVerDetalles.forEach(boton => {
          boton.addEventListener('click', function() {
                                                    // Obtener la fila correspondiente al botón
            const fila = boton.parentNode.parentNode;
          alert("Por favor verifique todos los datos antes de guardar");
                                                  // Obtener los datos de la fila
            const idCliente = fila.querySelector('td:nth-child(1)').textContent;
            const nombreCliente = fila.querySelector('td:nth-child(2)').textContent;
            const telefonoCliente = fila.querySelector('td:nth-child(3)').textContent;
            const direccionCliente = fila.querySelector('td:nth-child(4)').textContent;
            
                                                  // Mostrar los datos en los labels correspondientes
            document.getElementsByName('idCliente').value=idCliente;
          document.getElementByName('nombreCliente').value=nombreCliente;
          document.getElementByName('telefonoCliente').value=telefonoCliente;
          document.getElementByName('direccionCliente').value=direccionCliente;
            
          });
        });
        }