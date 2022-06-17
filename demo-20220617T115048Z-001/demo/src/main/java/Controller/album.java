package Controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AlbumVo;
import Model.AlbumDao;

public class album extends HttpServlet{
    AlbumVo aVo = new AlbumVo();
    AlbumDao aDao = new AlbumDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al doGet");
        String control=req.getParameter("control");
        System.out.println("El control es "+control);

        switch(control){
            case "listar":
                listar(req,resp);
            break;

            case "abrirForm":
                abrirForm(req, resp);
            break;

            case "buscarReg":
                buscarReg(req, resp);
            break;

            case "eliminar":
                eliminar(req, resp);
            break;

            case "desactivar":
                desactivar(req, resp);
            break;

            case "activar":
                activar(req, resp);
            break;
        }


    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al doPost");
        String control=req.getParameter("control");
        System.out.println("El control es "+control);

        switch(control){
            case "addAlbum":
                addAlbum(req, resp);
            break;

            case "editAlbum":
                editAlbum(req,resp);
            break;
        }
        
    }


    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        AlbumDao aDao = new AlbumDao(); //crear objeto del modelo Dao

        try {
            List<AlbumVo> album = aDao.listar(); 
            req.setAttribute("albumnes", album);

            req.getRequestDispatcher("views/album/listAlbum.jsp").forward(req, resp);;//redireccionamos a la vista en la que se van a mostrar todos los requistros
            System.out.println("Lista correctamente");

        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.getRequestDispatcher("views/album/addAlbum.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");

        } catch (Exception e) {
            System.out.println("El formulario NO pudo ser abierto"+e.getMessage().toString());
        }
    }


    private void addAlbum(HttpServletRequest req, HttpServletResponse resp) {
        AlbumDao aDao = new AlbumDao();
        AlbumVo aVo = new AlbumVo();

        if(req.getParameter("nombre")!= null){
            aVo.setNombreAlbum(req.getParameter("nombre"));
        }

        if(req.getParameter("anioPublicacion") != null){
            aVo.setAnioPublicacion(req.getParameter("anioPublicacion"));
        }

        

        if(req.getParameter("chkestado") != null){
            aVo.setEstadoAlbum(true);
        }else{
            aVo.setEstadoAlbum( false);
        }


        try{
            aDao.registrar(aVo);
            resp.sendRedirect("album?control=listar");
            System.out.println("Registro insertado correctamente");

        }catch(Exception e){
            req.setAttribute("msje","no se pudo registrar el album"+e.getMessage());
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }

    }

    private void buscarReg(HttpServletRequest req, HttpServletResponse resp) {
        AlbumDao aDao = new AlbumDao();
        AlbumVo aVo = new AlbumVo();

            if(req.getParameter("idAlb") != null){
                aVo.setIdAlbum(Integer.parseInt(req.getParameter("idAlb")));
                System.out.println("se encontró el id "+(req.getParameter("idAlb")));

            }else{
                req.setAttribute("msje","no se encontró el id");
                System.out.println("no se encontró el id ");
            }

        try {
            List<AlbumVo> album = aDao.buscarRegistro(aVo.getIdAlbum());
            req.setAttribute("albumnes", album);

            req.getRequestDispatcher("views/album/editAlbum.jsp").forward(req, resp);
            System.out.println("Se abrió el formulario editar album");

        } catch (Exception e) {
            req.setAttribute("msje","no se pudo abrir el formulario"+e.getMessage());
            System.out.println("Error en el cambio del registro "+e.getMessage().toString());
        }
    }


    private void editAlbum(HttpServletRequest req, HttpServletResponse resp) {
        AlbumDao aDao = new AlbumDao();
        AlbumVo aVo = new AlbumVo();

        if(req.getParameter("idAlbum") != null){
            aVo.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }

        if(req.getParameter("nombre")!= null){
            aVo.setNombreAlbum(req.getParameter("nombre"));
        }

        if(req.getParameter("anioPublicacion") != null){
            aVo.setAnioPublicacion(req.getParameter("anioPublicacion"));
        }

        

        if(req.getParameter("chkestado") != null){
            aVo.setEstadoAlbum(true);
        }else{
            aVo.setEstadoAlbum( false);
        }


        try{
            aDao.editarRegistro(aVo);
            resp.sendRedirect("album?control=listar");
            System.out.println("Registro modificado correctamente");

        }catch(Exception e){
            req.setAttribute("msje","no se pudo registrar el album"+e.getMessage());
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }


    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("IdAlbum") != null){
            aVo.setIdAlbum(Integer.parseInt(req.getParameter("IdAlbum")));
        }
        try {
            aDao.eliminar(aVo.getIdAlbum());
            
            resp.sendRedirect("album?control=listar");
            System.out.println("Se eliminó correctamentente");

        } catch (Exception e) {
            req.setAttribute("msje", "no se pudo eliminar el genero"+e.getMessage());
            System.out.println("no se pudo eliminar el genero"+e.getMessage().toString());
        }
    }


    private void desactivar(HttpServletRequest req, HttpServletResponse resp) {
        AlbumDao aDao = new AlbumDao();
        AlbumVo aVo = new AlbumVo();

        if(req.getParameter("idAlb") != null){
            aVo.setIdAlbum(Integer.parseInt(req.getParameter("idAlb")));
            System.out.println("se encontró el id "+(req.getParameter("idAlb")));

        }else{
            req.setAttribute("msje","no se encontró el id");
            System.out.println("no se encontró el id ");
        }

        if(req.getParameter("control").equals("activar")){
            aVo.setEstadoAlbum(true);
        
        }else{
            aVo.setEstadoAlbum(false);
        } 

        try {
            aDao.cambioEst(aVo);
            resp.sendRedirect("album?control=listar");
            System.out.println("Se cambió el estado correctamente");
            
        } catch (Exception e) {
            req.setAttribute("msje","no se pudo cambiar el estado"+e.getMessage());
            System.out.println("Error en el cambio el registro "+e.getMessage().toString());
        }
    }

    private void activar(HttpServletRequest req, HttpServletResponse resp) {
        AlbumDao aDao = new AlbumDao();
        AlbumVo aVo = new AlbumVo();

        if(req.getParameter("idAlb") != null){
            aVo.setIdAlbum(Integer.parseInt(req.getParameter("idAlb")));
            System.out.println("se encontró el id "+(req.getParameter("idAlb")));

        }else{
            req.setAttribute("msje","no se encontró el id");
            System.out.println("no se encontró el id ");
        }

        if(req.getParameter("control").equals("activar")){
            aVo.setEstadoAlbum(true);
        
        }else{
            aVo.setEstadoAlbum(false);
        } 

        try {
            aDao.cambioEst(aVo);
            resp.sendRedirect("album?control=listar");
            System.out.println("Se cambió el estado correctamente");
            
        } catch (Exception e) {
            req.setAttribute("msje","no se pudo cambiar el estado"+e.getMessage());
            System.out.println("Error en el cambio el registro "+e.getMessage().toString());
        }
    }

    
    
}
