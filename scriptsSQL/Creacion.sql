create table Jugadores
(
	Id_Jugador int AUTO_INCREMENT primary key,
	Nombre varchar(50) not null,
	Apellido varchar(50) not null,
	Apodo varchar(50) not null,
	Documento varchar(8) not null,
	Email varchar(50) not null,
	FechaNacimiento DateTime not null,
	Handicap tinyint not null,
	Id_Modalidad int not null,
	Id_Condicion int
);

create table Partidos
(
	Id_Partido int AUTO_INCREMENT primary key,
	Fecha DateTime not null,
	Estado CHAR(1) not null
);

create table Jugadores_Partidos
(
	Id_Partido int,
	Id_Jugador int,
	FechaDeInscripcion DateTime,
	Equipo tinyint,
	primary key (Id_Partido, Id_Jugador)
);

create table Condiciones
(
	Id_Condicion int primary key,
    TipoCondicion varchar(20),
	Edad tinyint,
	CantidadDeJugadores tinyint,
	MinimoDeEdad tinyint,
	MinimoDeJugadores tinyint
);

create table Modalidades
(
	Id_Modalidad int primary key,
	Prioridad tinyint
);

create table Calificaciones
(
	Id_Calificacion int AUTO_INCREMENT primary key,
	Id_JugadorCalificado int,
	Id_JugadorCalificador int,
	Id_Partido int,
	Puntaje tinyint,
	Critica varchar(255),
	Fecha DateTime
);

create table Infracciones
(
	Id_Infracccion int AUTO_INCREMENT primary key,
	Jugador int,
    Fecha DateTime,
	Motivo varchar(255)
);

create table Amistades
(
	Id_Jugador1 int,
	Id_Jugador2 int,
    primary key (Id_Jugador1, Id_Jugador2)
);

create table Sugerencias
(
	Id_Sugerencia int AUTO_INCREMENT primary key,
	Nombre varchar(50),
	Apellido varchar(50),
	Apodo varchar(50),
	FechaNacimiento DateTime,
	Documento varchar(8),
	Email varchar(50),
	Id_Jugador int
);

create table Denegaciones
(
	Id_Denegacion int AUTO_INCREMENT primary key,
    Fecha DateTime,
	Motivo varchar(255),
    Id_Sugerencia int
);

ALTER TABLE Jugadores
		ADD CONSTRAINT FK_Modalidad
        FOREIGN KEY (Id_Modalidad) REFERENCES Modalidades (Id_Modalidad),
        add CONSTRAINT FK_Condiciones
        FOREIGN KEY (Id_Condicion) REFERENCES Condiciones (Id_Condicion);

ALTER TABLE Jugadores_Partidos 
		ADD CONSTRAINT FK_Jugador
        FOREIGN KEY (Id_Jugador) REFERENCES Jugadores (Id_Jugador),
		ADD CONSTRAINT FK_Partido
        FOREIGN KEY (Id_Partido) REFERENCES Partidos (Id_Partido);

ALTER TABLE Calificaciones
		ADD CONSTRAINT FK_JugadorCalificado
        FOREIGN KEY (Id_JugadorCalificado) REFERENCES Jugadores (Id_Jugador),
        ADD CONSTRAINT FK_JugadorCalificador
        FOREIGN KEY (Id_JugadorCalificador) REFERENCES Jugadores (Id_Jugador),
		ADD CONSTRAINT FK_PartidoCalificado
        FOREIGN KEY (Id_Partido) REFERENCES Partidos (Id_Partido);        

ALTER TABLE Infracciones
		ADD CONSTRAINT FK_JugadorInfraccionado
        FOREIGN KEY (Jugador) REFERENCES Jugadores (Id_Jugador);
        
ALTER TABLE Amistades
		ADD CONSTRAINT FK_Amigo1
        FOREIGN KEY (Id_Jugador1) REFERENCES Jugadores (Id_Jugador),
		ADD CONSTRAINT FK_Amigo2
        FOREIGN KEY (Id_Jugador2) REFERENCES Jugadores (Id_Jugador);
        
ALTER TABLE Sugerencias
		ADD CONSTRAINT FK_Sugerencia
        FOREIGN KEY (Id_Jugador) REFERENCES Jugadores (Id_Jugador);
 
 ALTER TABLE Denegaciones
		ADD CONSTRAINT FK_Denegacion
        FOREIGN KEY (Id_Sugerencia) REFERENCES Sugerencias (Id_Sugerencia);

insert into Modalidades (Id_Modalidad, Prioridad) values (1, 1);
insert into Modalidades (Id_Modalidad, Prioridad) values (2, 2);
insert into Modalidades (Id_Modalidad, Prioridad) values (3, 3);

        
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad, Id_Condicion) 
values ( 'Juan', 'Casas', 'pepe', 21765454, 'pepe@gmail.com', '1945-05-12', 6, 1, NULL);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad, Id_Condicion) 
values ( 'Diego', 'Marado', 'd10s', 27768654, 'diegote@gmail.com', '1970-03-08', 10, 1, NULL);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad, Id_Condicion)  
values ('Esteban', 'Casas', 'bichi', 31765454, 'bichigol@gmail.com', '1989-07-02', 9, 1, NULL);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad, Id_Condicion) 
values ('Claudio', 'Pol', 'cani', 31765954, 'pajaro@gmail.com', '1975-12-23', 8, 1, NULL);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad, Id_Condicion) 
values ('Roberto', 'Casas', 'rober', 18545194, 'roro@gmail.com', '1973-09-02', 5, 1, NULL);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad, Id_Condicion) 
values ('Homero', 'Tompson', 'homer', 1765454, 'nosoysimpson@gmail.com', '1950-01-04', 2, 1, NULL);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad, Id_Condicion) 
values ('Carlos', 'Saul', 'carlitos', 38995454, 'noventas@gmail.com', '1990-09-09', 3, 1, NULL);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad, Id_Condicion) 
values ('Leonardo', 'Lolo', 'lenny', 36176990, 'lennin@gmail.com', '1953-11-1', 7, 1, NULL);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad, Id_Condicion) 
values ('Marcos', 'Palmas', 'loco', 21363551, 'locopalmas@gmail.com', '1991-10-21', 7, 1, NULL);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad, Id_Condicion) 
values ('Leo', 'Messi', 'pulga', 41765454, 'leo10@gmail.com', '1990-5-23', 10, 1, NULL);

insert into Partidos (Fecha, Estado)
values ('2014-10-21', 'A');
insert into Partidos (Fecha, Estado)
values ('2014-09-21', 'C');
insert into Partidos (Fecha, Estado)
values ('2014-10-10', 'C');

insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (1,1,'2014-10-05',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (1,2,'2014-10-05',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (1,3,'2014-10-05',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (1,4,'2014-10-05',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (1,5,'2014-10-05',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (1,6,'2014-10-05',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (1,7,'2014-10-05',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (1,8,'2014-10-05',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (1,9,'2014-10-05',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (1,10,'2014-10-05',2);

insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (2,1,'2014-09-15',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (2,3,'2014-09-15',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (2,5,'2014-09-15',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (2,7,'2014-09-15',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (2,9,'2014-09-15',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (2,2,'2014-09-15',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (2,4,'2014-09-15',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (2,6,'2014-09-15',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (2,8,'2014-09-15',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (2,10,'2014-09-15',2);

insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (3,1,'2014-10-09',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (3,3,'2014-10-07',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (3,5,'2014-10-08',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (3,7,'2014-10-08',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (3,9,'2014-10-08',1);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (3,2,'2014-10-09',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (3,4,'2014-10-06',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (3,6,'2014-10-07',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (3,8,'2014-10-09',2);
insert into Jugadores_Partidos (Id_Partido, Id_Jugador, FechaDeInscripcion, Equipo)
values (3,10,'2014-10-08',2);


