package domain.calificaciones

import domain.Partido
import domain.Jugador
import java.util.Date

public class Calificacion {
	int puntaje
	String critica
	Partido partido
	Jugador calificador
	Date fecha
	
	new(int puntaje,String critica,Partido partido,Jugador calificador){
		this.puntaje=puntaje
		this.critica=critica
		this.partido=partido
		this.calificador=calificador
		this.fecha = new Date();
	} 
	
//	new (int puntaje){
//		this.puntaje=puntaje
//	}
	
	//constructor sin parametros para hibernate
	new()
	{
		
	}	
	
	//getters y setters para hibernate
	def getPuntaje() { puntaje }
	def setPuntaje(int p) { puntaje = p }
	def getCritica() { critica }
	def setCritica(String c) { critica = c }
	def getPartido() { partido }
	def setPartido(Partido p) { partido = p }
	def getCalificador() { calificador }
	def setCalificacdor(Jugador c) { calificador = c }
	def getFecha() { fecha }
	def setFecha(Date f) { fecha = f }
	
	
	
}