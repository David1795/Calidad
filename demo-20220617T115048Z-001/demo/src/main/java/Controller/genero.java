package Controller;


import java.io.IOException;
import java.util.List;

/*librerias de mi servlet*/
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*importar modelo*/
import Model.GeneroDao;
import Model.GeneroVo;

public class genero extends HttpServlet {
    GeneroDao gdao=new GeneroDao();
    GeneroVo r=new GeneroVo();
    int iduser;
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String accion=req.getParameter("accion");

        switch(accion){
            case "abrirForm":
            abrirForm(req,resp);
            break;

        
            case "listar":
            listar(req,resp);
            break;

            case "desactivar":
            desactivar(req, resp);
            break;

            case "activar":
            activar(req, resp);
            break;


            case "eliminar":
            eliminar(req, resp);
            break;

            case "buscaid":
            buscaid(req, resp);
            break;  
           
          
    }
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String accion=req.getParameter("accion");
       

        switch(accion){
            case "addGenero":
                addGenero(req, resp);
            break;

            case "modificar":
            modificar(req, resp);
            break;

        }
    }

       

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Genero/RegistroGenero.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void addGenero(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombre")!=null){
            r.setNombreGenero(req.getParameter("nombre"));
        }
        if(req.getParameter("estado")!=null){
            r.setEstadoGenero(true);
        }
        else{
            r.setEstadoGenero(false);
        }
        try {
            gdao.registar(r);
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Registro insertado correctamente");
        } catch (Exception e) {
            req.setAttribute("msje","no se pudo registrar el genero"+e.getMessage());
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {

        
        try {
            List<GeneroVo> genero=gdao.listar();
            req.setAttribute("generos", genero);
            req.getRequestDispatcher("views/Genero/consultar.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }




    private void buscaid (HttpServletRequest req, HttpServletResponse resp) {

        GeneroDao gdao=new GeneroDao();
        GeneroVo r=new GeneroVo();
        

        req.setAttribute("idGenero", req.getParameter("idGenero"));
        req.setAttribute("nombreGenero", req.getParameter("nombreGenero"));

        System.out.println("se encontró el id "+(req.getParameter("idGenero")));
            req.setAttribute("msje","no se encontró el id");
            System.out.println("no se encontró el id ");
        


        try {
            List<GeneroVo> genero=gdao.listarId(r.getIdGenero());
            req.setAttribute("generos", genero);
            req.getRequestDispatcher("views/Genero/modificar.jsp").forward(req, resp);
            System.out.println("Muestra Exitosa");

        } 
        catch (Exception e) {
            System.out.println("Error en la muestra "+e.getMessage().toString());
        }
            
        }   
       

    private void modificar(HttpServletRequest req, HttpServletResponse resp) {

      

        if (req.getParameter("idGenero")!=null) {
            r.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        if (req.getParameter("nombreGenero" )!=null) {
            r.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if (req.getParameter("estadoGenero")!=null) {
            r.setEstadoGenero(true);
        }
        else{
            r.setEstadoGenero(false);
        }
        try {
            gdao.modificar(r);
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Registro se ha actualizado correctamente");

        } 
        catch (Exception e) {
            req.setAttribute("msje", "no se pudo modificar el formulario "+e.getMessage());
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    

    private void activar(HttpServletRequest req, HttpServletResponse resp) {
        GeneroDao gdao=new GeneroDao();
        GeneroVo r= new GeneroVo(); 
        System.out.println("entró al método ");

        if(req.getParameter("IdGenero")!=null){
            r.setIdGenero(Integer.parseInt(req.getParameter("IdGenero")));
            System.out.println("se encontró el id "+(req.getParameter("IdGenero")));
        }
        else{
            req.setAttribute("msje","no se encontró el id");
            System.out.println("no se encontró el id ");
        }

        System.out.println("se encontró el estado "+(req.getParameter("estado")));

        if(req.getParameter("accion").equals("activar")){
            r.setEstadoGenero(true);;
        
        }else{
            r.setEstadoGenero(false);
        } 

        try {
            gdao.cambioEst(r);
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Se cambió el estado correctamente");
            
        } catch (Exception e) {
            req.setAttribute("msje","no se pudo cambiar el estado"+e.getMessage());
            System.out.println("Error en el cambio el registro "+e.getMessage().toString());
        }
    }

    private void desactivar(HttpServletRequest req, HttpServletResponse resp) {
        GeneroDao gdao=new GeneroDao();
        GeneroVo r= new GeneroVo(); 

        if(req.getParameter("IdGenero")!=null){
            r.setIdGenero(Integer.parseInt(req.getParameter("IdGenero")));
            System.out.println("se encontró el id "+(req.getParameter("IdGenero")));
        }else{
            req.setAttribute("msje","no se encontró el id");
            System.out.println("no se encontró el id ");
        }

        if(req.getParameter("accion").equals("activar")){
            r.setEstadoGenero(true);;
        
        }else{
            r.setEstadoGenero(false);
        } 

        try {
            gdao.cambioEst(r);
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Se cambió el estado correctamente");
            
        } catch (Exception e) {
            req.setAttribute("msje","no se pudo cambiar el estado"+e.getMessage());
            System.out.println("Error en el cambio el registro "+e.getMessage().toString());
        }
    }


    private void eliminar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("IdGenero")!=null){
            r.setIdGenero(Integer.parseInt(req.getParameter("IdGenero")));
        }
        try {
            gdao.eliminar(r.getIdGenero());
            
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Se eliminó correctamentente");

        } catch (Exception e) {
            req.setAttribute("msje", "no se pudo eliminar el genero"+e.getMessage());
            System.out.println("no se pudo eliminar el genero"+e.getMessage().toString());
        }finally{

        }
    }

      
        
    }






    

