package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;





public class GeneroDao  {

    Connection con;

    PreparedStatement ps;

    ResultSet rs;
    
    String sql=null;

    int r;


public int registar (GeneroVo genero) throws SQLException{
    sql="INSERT INTO genero(nombreGenero , estadoGenero) VALUES (?,?)";
    try{
        con=conexion.conectar();
        ps=con.prepareStatement(sql);
        ps.setString(1, genero.getNombreGenero());
        ps.setBoolean(2, genero.getEstadoGenero());
        System.out.println(ps);
        ps.executeUpdate();
        ps.close();
        System.out.println("Registro Exitoso");
}
catch(Exception e){

    System.out.println("Error de registro."+e.getMessage());


 }

 finally{
     con.close();
 }
 return r;
}

public List<GeneroVo> listar() throws Exception{
 
    List<GeneroVo> genero= new ArrayList<>();
    sql="SELECT * FROM genero";
    try{
        con=conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        rs=ps.executeQuery();

        while(rs.next()){
            GeneroVo r =new GeneroVo();
            r.setIdGenero(rs.getInt("idGenero"));
            r.setNombreGenero(rs.getString("nombreGenero"));
            r.setEstadoGenero(rs.getBoolean("estadoGenero"));
            genero.add(r);
        }
        ps.close();
        System.out.println("Consulta Exitosa");

    }

    catch(Exception e){

       System.out.println("Error de consulta"+e.getMessage());


    }

    finally{
        con.close();
    }
    return genero;

}

public List<GeneroVo> listarId(int id) throws SQLException{

    List<GeneroVo> genero=new ArrayList<>();
    sql="SELECT * FROM genero WHERE idGenero = "+id;
    System.out.println("Listando Datos");

    try {
        con=conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        rs=ps.executeQuery();
        if (rs.next()){
            GeneroVo r=new GeneroVo(); 
            r.setIdGenero(rs.getInt("idGenero"));
            r.setNombreGenero(rs.getString("nombreGenero"));
            r.setEstadoGenero(rs.getBoolean("estadoGenero"));
            genero.add(r);
        }

        ps.close();
        System.out.println(" Consulta Exitosa");

    } catch (Exception e) {
        System.out.println("No se encontró el registro"+e.getMessage().toString());

    }finally{
        con.close();
    }
    return genero;
}

public void modificar (GeneroVo r) throws SQLException{
    
    System.out.println("Entro al DAO");
    sql = "UPDATE genero SET nombreGenero = '"+r.getNombreGenero()+"', estadoGenero = "+r.getEstadoGenero()+" WHERE idGenero = "+ r.getIdGenero();

    System.out.println("se encontró el id "+r.getIdGenero());
    
    try { 

        
        con=conexion.conectar();
        ps = con.prepareStatement(sql); 
        System.out.println(ps);
        ps.executeUpdate(); 
        ps.close();
        
        System.out.println("Se actualizaron los datos con exito");
        ps.close();

    } 
    catch (Exception e) {
        System.out.println("Error en el cambio de datos "+e.getMessage().toString());
    }
    finally{
        con.close();
    }
   
}

public int cambioEst(GeneroVo genero)throws SQLException{
    sql="UPDATE genero SET estadoGenero="+genero.getEstadoGenero()+ " WHERE idGenero = "+ genero.getIdGenero();
    System.out.println("se encontró el estado "+genero.getEstadoGenero());

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


public void eliminar(int idGenero)throws SQLException{
    sql="DELETE FROM genero WHERE idGenero="+idGenero;
    System.out.println(sql);


try{
    con=conexion.conectar();
    ps=con.prepareStatement(sql);
    System.out.println(ps);
    ps.executeUpdate(sql);
    ps.close();
    System.out.println("Se elimino correctamente");
}
catch( Exception e){

    System.out.println("Error en la eliminacion"+e.getMessage());

}
finally{
    con.close();
}
}
}






    





    
    



