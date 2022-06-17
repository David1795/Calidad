<%@include file="../header.jsp"%>


    <div class="box-bodyrA">

        <h1>Album</h1>
     

        <hr>

        <form method="post" action="album?control=addAlbum" >

            <div class="form-group">
                <label class="form-label">Nombre: </label>
                <input type="text" class="form-control" name="nombre" id="nombre" >
            </div>

            <div class="form-group">
                <label class="form-label">Fecha de publicacion: </label>
                <input type="text" class="form-control" name="anioPublicacion" id="anioPublicacion" >
            </div>

            <div class="form-check">
                <input type="checkbox" name="chkestado" id="chkestado" checked class="form-check-input">
                <label for="chkestado"> Activo</label>
            </div>

            <button type="submit" class="btn btn-dark" name="control" value="add">Guardar</button>
        </form>
           
    </div>

    <%@include file="../footer.jsp"%>