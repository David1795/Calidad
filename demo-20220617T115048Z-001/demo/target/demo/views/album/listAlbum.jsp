<%@include file="../header.jsp"%>

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script src="assets/js/eliminar1.js"></script>

            

<div class="box-body">

    <h1>Consulta Album
    <a type="button" class="btn btn-primary" href="album?control=abrirForm"><i class="fa fa-plus"></i> Registrar</a>
    </h1> 

    <hr>
    <div class="table-responsive">
        <table id="userList" class="table">
            <thead class="table-thead">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Fecha de Publicacion</th>
                <th scope="col">Estado</th>
                <th colspan="3">Acciones</th>
                    
            </tr> 
            </thead>
            

            <c:forEach var="album" items="${albumnes}">   
            <tr>
                <td>${album.getIdAlbum()}</td>
                <td>${album.getNombreAlbum()}</td>
                <td>${album.getAnioPublicacion()}</td>
                
                

                <c:if test="${album.getEstadoAlbum() == true}">
                    <td><span class="badge bg-success active"> Activo</span></td> 
                 </c:if>

                <c:if test="${album.getEstadoAlbum() == false}">
                    <td><span class="badge bg-danger active"> Inactivo</span></td> 
                </c:if>
                

                <td>
                    
                <c:if test="${album.getEstadoAlbum() == true}">
                    <a rol="button" class="btn btn-danger btn-sm" href="album?control=desactivar&idAlb=${album.getIdAlbum()}&estado=${album.getEstadoAlbum()}" >Inactivar</a>
                </c:if>

                <c:if test="${album.getEstadoAlbum() == false}">
                    <a rol="button" class="btn btn-success btn-sm" href="album?control=activar&idAlb=${album.getIdAlbum()}&estado=${album.getEstadoAlbum()}">Activar </a>
                </c:if>


                <a rol="button" class="btn btn-outline-secondary" href="album?control=buscarReg&idAlb=${album.getIdAlbum()}"><i class="fa fa-edit fa-lg"></i> </a>
                
            
                <a rol="button" class="btn btn-outline-secondary"  onclick="eliminar(event ,'${album.getIdAlbum()}', 'album')"><i class="fa fa-trash fa-lg"></i> </a>
                </td>



            
            </tr>

            </c:forEach>    
            
        </table>

</div>
</div>

<%@include file="../footer.jsp" %>