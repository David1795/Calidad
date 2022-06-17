create database music;

use music;

create table genero(
idGenero int AUTO_INCREMENT,
nombreGenero varchar(30),
estadoGenero boolean,
primary key(idGenero)
);

create table disquera(
idDisquera int auto_increment,
nitDisquera varchar(30),
nombreDisquera varchar(100),
telefonoDisquera bigint,
direccionDisquera varchar(100),
estadoDisquera boolean,
primary key(idDisquera)
);

create table artista(
idArtista int auto_increment,
noDocumeto bigint unique,
tipodocumento varchar(20),
nombreArtista varchar(50),
apellidoArtista varchar(50),
nombreArtistico varchar(50),
fenaciArtista date,
emailArtista varchar(50),
estadoArtista boolean,
primary key(idArtista)
);

create table album(
idAlbum int auto_increment,
nombreAlbum varchar(70),
anioPublicacion varchar(10),
estadoAlbum boolean,
primary key(idAlbum)
);

create table cancion(
idCancion int auto_increment,
nombreCancion varchar(50),
fechaGrabacion date,
duracionCancion varchar(5),
estadoCancion boolean,
primary key(idCancion)

);

select * from album;
select * from genero;

