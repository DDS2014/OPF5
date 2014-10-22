# CREATE
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
	Id_Modalidad int not null
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
	FechaDeInscripcion DateTime NOT NULL,
	Equipo tinyint NULL,
	primary key (Id_Partido, Id_Jugador)
);

create table Bajas
(
	Id_Partido int,
	Id_Jugador int,
	Fecha DateTime NOT NULL,
	Reemplazante int NULL,
    Motivo varchar(255),
	primary key (Id_Partido, Id_Jugador)
);

create table Modalidades
(
	Id_Modalidad int primary key,
	Descripcion varchar(20) NOT NULL,
	Prioridad tinyint NOT NULL
);

create table Calificaciones
(
	Id_Calificacion int AUTO_INCREMENT primary key,
	Id_JugadorCalificado int NOT NULL,
	Id_JugadorCalificador int NOT NULL,
	Id_Partido int NOT NULL,
	Puntaje tinyint NOT NULL,
	Critica varchar(255),
	Fecha DateTime NOT NULL
);

create table Infracciones
(
	Id_Infracccion int AUTO_INCREMENT primary key,
	Jugador int NOT NULL,
    Fecha DateTime NOT NULL,
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
	Id_Jugador int NULL
);

create table Denegaciones
(
	Id_Denegacion int AUTO_INCREMENT primary key,
    Fecha DateTime NOT NULL,
	Motivo varchar(255),
    Id_Sugerencia int NOT NULL
);

# FOREIGN KEYS
ALTER TABLE Jugadores
		ADD CONSTRAINT FK_Modalidad
        FOREIGN KEY (Id_Modalidad) REFERENCES Modalidades (Id_Modalidad);

ALTER TABLE Jugadores_Partidos 
		ADD CONSTRAINT FK_Jugador
        FOREIGN KEY (Id_Jugador) REFERENCES Jugadores (Id_Jugador),
		ADD CONSTRAINT FK_Partido
        FOREIGN KEY (Id_Partido) REFERENCES Partidos (Id_Partido);

ALTER TABLE Bajas
		ADD CONSTRAINT FK_Baja_Jugador
        FOREIGN KEY (Id_Jugador, Id_Partido) REFERENCES Jugadores_Partidos (Id_Jugador, Id_Partido);
        
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

# INSERTS
insert into Modalidades (Id_Modalidad, Descripcion, Prioridad) values (1, 'Estándar', 1);
insert into Modalidades (Id_Modalidad, Descripcion, Prioridad) values (2, 'Solidaria', 2);
insert into Modalidades (Id_Modalidad, Descripcion, Prioridad) values (3, 'Condicional', 3);

        
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad) 
values ( 'Juan', 'Casas', 'pepe', 21765454, 'pepe@gmail.com', '1945-05-12', 6, 1);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad) 
values ( 'Diego', 'Marado', 'd10s', 27768654, 'diegote@gmail.com', '1970-03-08', 10, 1);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad)  
values ('Esteban', 'Casas', 'bichi', 31765454, 'bichigol@gmail.com', '1989-07-02', 9, 1);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad) 
values ('Claudio', 'Pol', 'cani', 31765954, 'pajaro@gmail.com', '1975-12-23', 8, 1);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad) 
values ('Roberto', 'Casas', 'rober', 18545194, 'roro@gmail.com', '1973-09-02', 5, 1);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad) 
values ('Homero', 'Tompson', 'homer', 1765454, 'nosoysimpson@gmail.com', '1950-01-04', 2, 1);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad) 
values ('Carlos', 'Saul', 'carlitos', 38995454, 'noventas@gmail.com', '1990-09-09', 3, 1);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad) 
values ('Leonardo', 'Lolo', 'lenny', 36176990, 'lennin@gmail.com', '1953-11-1', 7, 1);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad) 
values ('Marcos', 'Palmas', 'loco', 21363551, 'locopalmas@gmail.com', '1991-10-21', 7, 1);
insert into Jugadores (Nombre,	Apellido,	Apodo,	Documento,	Email, FechaNacimiento, Handicap, Id_Modalidad) 
values ('Leo', 'Messi', 'pulga', 41765454, 'leo10@gmail.com', '1990-5-23', 10, 1);

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

INSERT INTO infracciones(Jugador, Fecha, Motivo)
VALUES(1,NOW(),'No llega a tiempo.');
INSERT INTO infracciones(Jugador, Fecha, Motivo)
VALUES(1,NOW(),'Lesionado.');
INSERT INTO infracciones(Jugador, Fecha, Motivo)
VALUES(1,NOW(),'No le gusto el equipo.');
INSERT INTO infracciones(Jugador, Fecha, Motivo)
VALUES(1,NOW(),'Enfermedad.');
INSERT INTO infracciones(Jugador, Fecha, Motivo)
VALUES(2,NOW(),'Lesionado.');


# FUNCTIONS
DROP FUNCTION IF EXISTS Fn_EsMalo;
DELIMITER //
CREATE FUNCTION Fn_EsMalo(idJugador int)
  RETURNS boolean
BEGIN
  RETURN (SELECT (handicap <= 5) AS es_malo
		FROM jugadores
		WHERE Id_Jugador = idJugador);
END;
//
DELIMITER ;

DROP FUNCTION IF EXISTS Fn_GetEdad;
DELIMITER //
CREATE FUNCTION Fn_GetEdad(fecha DateTime)
  RETURNS int
BEGIN
	RETURN ((YEAR(current_time) - YEAR(fecha)) - ((DATE_FORMAT(current_time, '00-%m-%d') < DATE_FORMAT(fecha, '00-%m-%d'))));
END;
//
DELIMITER ;


# STORED PROCEDURES
 DROP PROCEDURE IF EXISTS Sp_GetJugadoresMalos;
 DELIMITER //
 CREATE PROCEDURE Sp_GetJugadoresMalos()
   BEGIN
	SELECT * FROM jugadores
		WHERE Fn_EsMalo(Id_Jugador);
   END//
 DELIMITER ;
 
 DROP PROCEDURE IF EXISTS Sp_GetJugadoresAMejorar;
DELIMITER //
 CREATE PROCEDURE Sp_GetJugadoresAMejorar()
   BEGIN
	SELECT * FROM jugadores
		WHERE Fn_EsMalo(Id_Jugador) and Fn_GetEdad(FechaNacimiento) <= 25;
   END//
 DELIMITER ;
 
 DROP PROCEDURE IF EXISTS Sp_GetJugadoresTraicioneros;
DELIMITER //
CREATE PROCEDURE Sp_GetJugadoresTraicioneros()
BEGIN
    SELECT @auxId := j.Id_Jugador FROM jugadores j
	INNER JOIN infracciones i
		ON j.Id_Jugador = i.Jugador
	WHERE i.Fecha >= DATE_ADD(NOW(),INTERVAL -1 MONTH)
	GROUP BY j.Id_Jugador
	HAVING COUNT(*) > 3;
    
    SELECT * FROM Jugadores
    WHERE Id_Jugador = @auxId;
END //
DELIMITER ;


# TRIGGERS
DROP TRIGGER IF EXISTS Trg_MultarBaja;
DELIMITER //
CREATE TRIGGER Trg_MultarBaja AFTER INSERT ON Bajas
FOR EACH ROW
BEGIN
	if (NEW.Reemplazante IS NULL) THEN
		INSERT INTO infracciones(Jugador, Fecha, Motivo)
		VALUES(NEW.Id_Jugador,NOW(),'Dado de baja.');
	END IF;
END;//
DELIMITER ;