

ALTER TABLE Jugadores 
	drop foreign key FK_Modalidad;
	
    
ALTER TABLE Jugadores_Partidos 
	drop foreign key FK_Partido,
	drop foreign key FK_Jugador;

ALTER TABLE Equipos1
		drop foreign key FK_Jugador_E1,
		drop foreign key FK_Partido_E1;
		
ALTER TABLE Equipos2
		drop foreign key FK_Jugador_E2,
		drop foreign key FK_Partido_E2;

ALTER TABLE Bajas
	drop foreign key FK_Baja_Jugador;

ALTER TABLE Calificaciones 
	drop foreign key FK_JugadorCalificado,
	drop foreign key FK_JugadorCalificador,
    drop foreign key FK_PartidoCalificado;
    
ALTER TABLE Infracciones
	drop foreign key FK_JugadorInfraccionado;
    
ALTER TABLE Amistades
	drop foreign key FK_Amigo1,
	drop foreign key FK_Amigo2;
    
ALTER TABLE Sugerencias
	drop foreign key FK_Sugerencia;

ALTER TABLE Denegaciones
	drop foreign key FK_Denegacion;
    
drop table Jugadores, Partidos, Jugadores_Partidos, Equipos1, Equipos2, Modalidades, Calificaciones, Infracciones, Amistades, Sugerencias, Denegaciones, Bajas;