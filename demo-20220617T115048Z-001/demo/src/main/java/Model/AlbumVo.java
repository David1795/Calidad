package Model;


public class AlbumVo {
    private int idAlbum;
    private String nombreAlbum;
    private String anioPublicacion;
    private boolean estadoAlbum;

    public AlbumVo(){
        
    }

    public AlbumVo(int idAlbum, String nombreAlbum, String anioPublicacion,  boolean estadoAlbum){
        this.idAlbum=idAlbum;
        this.nombreAlbum=nombreAlbum;
        this.anioPublicacion=anioPublicacion;
        this.estadoAlbum=estadoAlbum;
    }

    

    public void setIdAlbum(int idAlbum){
        this.idAlbum=idAlbum;
    }
    public int getIdAlbum(){
        return idAlbum;
    }

    

    public void setNombreAlbum(String nombreAlbum){
        this.nombreAlbum=nombreAlbum;
    }
    public String getNombreAlbum(){
        return nombreAlbum;
    }

    

    public void setAnioPublicacion(String anioPublicacion){
        this.anioPublicacion=anioPublicacion;
    }
    public String getAnioPublicacion(){
        return anioPublicacion;
    }

    

    
    public void setEstadoAlbum(boolean estadoAlbum){
        this.estadoAlbum=estadoAlbum;
    }
    public Boolean getEstadoAlbum(){
        return estadoAlbum;
    }
}
