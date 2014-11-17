package dao

import java.util.List
import domain.Partido

import static dao.SessionManager.*

class PartidosRepo {
	def static List<Partido> getAll() {
		val query = session.createQuery("from Partido")
		query.list()
	}
}