package dao

import java.util.List
import domain.Partido

import static dao.SessionManager.*

class EquiposRepo {
	def List<Partido> getAll() {
		val query = session.createQuery("from Partido")
		query.list()
	}
}