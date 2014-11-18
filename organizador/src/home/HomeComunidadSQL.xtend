package home

import dao.PartidosRepo
import dao.JugadoresRepo
import java.util.ArrayList
import domain.Partido
import domain.Jugador
import java.util.HashSet
import dao.SessionManager
import static dao.SessionManager.*

class HomeComunidadSQL extends HomeComunidad


{
	int nroDePartido
	
	new(int n)
	{
		this.nroDePartido = n
	}
	
	def configurar()
	{
	this.partidos = PartidosRepo::getAll() as ArrayList<Partido>
	this.aprobados = JugadoresRepo::getAll() as ArrayList<Jugador>
	}
	
	
	override getPartidoRelevante()
	{
		return this.getPartidos.get(nroDePartido)
	}
	
}