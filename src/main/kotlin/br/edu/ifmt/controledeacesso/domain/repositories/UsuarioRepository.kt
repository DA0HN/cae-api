package br.edu.ifmt.controledeacesso.domain.repositories

import br.edu.ifmt.controledeacesso.domain.entities.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

/**
 * @project cae-api
 * @author daohn on 26/01/2021
 */
@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {
  fun findByLogin(login: String): Optional<Usuario>
}