<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!doctype html>
        <html>

        <head>
            <meta charset="utf-8">

            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

            <title>RegistroGenero</title>

            

        </head>

        <body>


            <div class="modal__circle "></div>

            <center><img src="https://co.jbl.com/on/demandware.static/-/Sites-masterCatalog_Harman/default/dw053251de/JBL_FlipEssential_Hero_005_x1.png " style="width:25%; height: 25%;" class=" modal__product " /></center>
            </div>

            <center>

                <h1>Registar genero</h1>
                <form method="post" action="genero?accion=addGenero">

                    <label>Nombre:</label>
                    <input type="text" name="nombre" id="nombre" required>

                    <label>Estado:</label>
                    <input type="checkbox" name="estado" id="estado" checked>
                    <label for="estado">Activo</label>

                    <input type="submit" value="Registar" name="accion">
                </form>

            </center>
                         
                     
            </div>


            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>


        </body>

        </html>