package dao

import java.util.List
import domain.Jugador

//import static org.hibernate.criterion.Restrictions.*
import static dao.SessionManager.*

class JugadoresRepo {
	
	def List<Jugador> getAll() 
	{
		val query = session.createQuery("from Jugador")
		query.list()
	}
	
}