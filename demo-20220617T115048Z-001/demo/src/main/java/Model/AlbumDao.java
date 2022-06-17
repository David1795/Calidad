package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlbumDao{
    
    
    Connection con;
    PreparedStatement ps; 
    ResultSet rs; 
    String sql=null; 
    int r;


    public List<AlbumVo> listar() throws SQLException{
        List<AlbumVo> album=new ArrayList<>(); 
        sql="SELECT * FROM album";

        try {
            con=conexion.conectar();//abrir conexion
            ps=con.prepareStatement(sql);//prepara sentencia select
            System.out.println(ps);
            rs=ps.executeQuery();//ejecute la consulta y la guarda los resultados

            while(rs.next()){
                AlbumVo r=new AlbumVo();

                
                r.setIdAlbum(rs.getInt("idAlbum"));
                r.setNombreAlbum(rs.getString("nombreAlbum"));
                r.setAnioPublicacion(rs.getString("anioPublicacion"));
                r.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
                album.add(r);

            }

            ps.close();
            System.out.print("Consulta exitosa");

        } catch (Exception e) {
            System.out.println("No se pudo ejecutar la consulta"+e.getMessage().toString());
            
        }finally{
            con.close();//Cierre de la conexiòn
        }
        return album;
    }

    public int registrar(AlbumVo album) throws SQLException{
        sql="INSERT INTO album (nombreAlbum, anioPublicacion, estadoAlbum) VALUES(?, ?, ?)";

        try {
            con=conexion.conectar();
            ps=con.prepareStatement(sql);

            ps.setString(1, album.getNombreAlbum());
            ps.setString(2, album.getAnioPublicacion());
            ps.setBoolean(3, album.getEstadoAlbum());
            System.out.println(ps);

            ps.executeUpdate();
            ps.close();

            System.out.println("Se registró el album correctamente");

        } catch (Exception e) {
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }

    public List<AlbumVo> buscarRegistro (int idAlb) throws SQLException{
        List<AlbumVo> album=new ArrayList<>();
        sql="SELECT * FROM album WHERE idAlbum = "+ idAlb;

        try {
            con=conexion.conectar();//abrir conexion
            ps=con.prepareStatement(sql);//prepara sentencia select
            System.out.println(ps);
            rs=ps.executeQuery();//ejecute la consulta y la guarda los resultados

            if(rs.next()){
                AlbumVo r=new AlbumVo();

                //Escribir  en el setter cada valor encontrado:
                r.setIdAlbum(rs.getInt("idAlbum"));
                r.setNombreAlbum(rs.getString("nombreAlbum"));
                r.setAnioPublicacion(rs.getString("anioPublicacion"));
                r.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
                album.add(r);
            }

            ps.close();
            System.out.print("Se encontró el registro");

        } catch (Exception e) {
            System.out.println("No se encontró el registro"+e.getMessage().toString());
            
        }finally{
            con.close();//Cierre de la conexiòn
        }
        return album;
    }


    public void editarRegistro(AlbumVo album) throws SQLException{
        sql="UPDATE album SET nombreAlbum = '"+album.getNombreAlbum()+"', anioPublicacion = "+album.getAnioPublicacion()+", estadoAlbum = "+album.getEstadoAlbum()+" WHERE idAlbum = "+album.getIdAlbum();
        System.out.println("se encontró el id "+album.getIdAlbum());
 
        try {
            con=conexion.conectar(); //abrir conexión-modelo
            ps=con.prepareStatement(sql); //prepara sentencia sql
            System.out.println(ps);
            ps.executeUpdate();//Ejecuta la sentencia
            ps.close();

            System.out.println("Cambio de datos exitosos");

        } catch (Exception e) {
            System.out.println("Error en el cambio de datos "+e.getMessage().toString());
        }

        finally{
            con.close();
        }
    }


    public void eliminar(int idAlbum) throws SQLException{
        sql="DELETE FROM album WHERE idAlbum = "+idAlbum;

        System.out.print(sql);

        try {
            con=conexion.conectar(); //abrir conexión-modelo
            ps=con.prepareStatement(sql); //prepara sentencia sql
            System.out.println(ps);
            ps.executeUpdate();//Ejecuta la sentencia
            ps.close();

            System.out.println("Se eliminó el registro");

        } catch (Exception e) {
            System.out.println("Error en la eliminaciòn del genero "+e.getMessage().toString());
        }

        finally{
            con.close();
        }
    }


    public int cambioEst(AlbumVo album)throws SQLException{
        sql="UPDATE album SET estadoAlbum = "+album.getEstadoAlbum()+ " WHERE idAlbum = "+ album.getIdAlbum();
        System.out.println("se encontró el estado "+album.getEstadoAlbum());

        try {
            con=conexion.conectar(); //abrir conexión-modelo
            ps=con.prepareStatement(sql); //prepara sentencia sql
            System.out.println(ps);
            ps.executeUpdate();//Ejecuta la sentencia
            ps.close();

            System.out.println("Cambio de estado exitoso");

        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }

}