<%@include file="../header.jsp"%>

    <title>Mofificar Album</title>

    <div class="box-bodyrA">

        <h1>Genero</h1>


        <hr>

        <form method="post" action="album?control=editAlbum">

            <c:forEach var="album" items="${albumnes}">

                <input type="hidden" name="idAlbum" id="idAlbum" value="${album.getIdAlbum()}">

                <div class="form-group">
                    <label class="form-label">Nombre: </label>
                    <input type="text" name="nombre" id="nombre" value="${album.getNombreAlbum()}">
                </div>

                <div class="form-group">
                    <label class="form-label">Fecha de publicacion: </label>
                    <input type="text" name="anioPublicacion" id="anioPublicacion" value="${album.getAnioPublicacion()}">
                </div>




                <div class="form-check">


                    <c:if test="${album.getEstadoAlbum() == true}">
                        <input type="checkbox" name="chkestado" id="chkestado" checked class="form-check-input" value="checked">
                        <label for="chkestado"> Activo</label>
                    </c:if>

                    <c:if test="${album.getEstadoAlbum() == false}}">
                        <input type="checkbox" name="chkestado" id="chkestado" class="form-check-input" value="unchecked">
                        <label for="chkestado"> Inactivo</label>
                    </c:if>


            </c:forEach>
            </div>

            <button type="submit" class="btn btn-dark" name="control">Guardar</button>
        </form>

    </div>

    <%@include file="../footer.jsp"%>