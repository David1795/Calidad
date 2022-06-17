<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset='utf-8'>
            <meta http-equiv='X-UA-Compatible' content='IE=edge'>
            <title>ConsultarGenero</title>
            <meta name='viewport' content='width=device-width, initial-scale=1'>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

            <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <script src="assets/js/eliminar.js"></script>

            
        </head>

        <body>
            <center>
                <h1>Consulta Genero</h1>
                <a href="genero?accion=abrirForm"><button class="btn btn-primary">Registar</button></a>
                
                <table class="table">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Estado</th>
                        <th scope="col" colspan="3">
                            <center>Acciones</center>
                        </th>
                    </tr>
                     <c:forEach var="genero" items="${generos}">
                        <tr>
                            <td>${genero.getIdGenero()}</td>
                            <td>${genero.getNombreGenero()}</td>
                    <c:if test="${genero.getEstadoGenero() == true}">        
                            <td><span>Activo</span></td> 
                    </c:if>
                    <c:if test="${genero.getEstadoGenero() == false}">
                            <td><span>Inactivo</span></td> 
                    </c:if>
                            <td>
                            <c:if test="${genero.getEstadoGenero() == true}">
                                <a rol="button" onclick="" href="genero?accion=desactivar&IdGenero=${genero.getIdGenero()}&estado=${genero.getEstadoGenero()}"><button type="button" class="btn btn-danger">Inactivar</button></a>
                            </c:if>
                            <c:if test="${genero.getEstadoGenero() == false}">
                                <a rol="button" href="genero?accion=activar&IdGenero=${genero.getIdGenero()}&estado=${genero.getEstadoGenero()}"><button type="button" class="btn btn-success">Activar</button></a>
                            </c:if>
                            </td> 
                            <td><a href="genero?accion=buscaid&idGenero=${genero.getIdGenero()}&nombreGenero=${genero.getNombreGenero()}"><button type="button" class="btn btn-success">Modificar</button></a></td>
                            <td><a genero="button" class="btn btn-danger" onclick="eliminar(event ,'${genero.getIdGenero()}', 'genero')">Eliminar</a></td>
                        </tr> 
                    </c:forEach>
                </table>
            </center>


   
            
        </body>

        
        </html>