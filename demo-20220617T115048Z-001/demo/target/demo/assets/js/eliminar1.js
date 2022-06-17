function eliminar(e,cod,cont){
	e.preventDefault();
	console.log(cont);

	Swal.fire({
	  title: '¿Esta seguro de eliminar este registro?',
	  text: "¡Esta accion no se puede reversar!",
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: '¡Si, Eliminar!',
	  cancelButtonText: "No, Cancelar",
	}).then((result) => {
	  if (result.isConfirmed) 
		 {
			ruta=cont+"?control=eliminar&IdAlbum="+cod;
			console.log(ruta);
			window.setTimeout(function(){window.location.href = ruta},2000);
			Swal.fire({
			  position: 'middle',
			  icon: 'success',
			  title: 'El registro ha sido borrado',
			  showConfirmButton: false,
			  timer: 1500
			})

          } else {
                  Swal.fire(
						'Cancelado', 
						'Cancelaste la eliminacion',
						'error');
                 }
	  
	});
	
};
