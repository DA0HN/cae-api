package br.edu.ifmt.controledeacesso.config

import br.edu.ifmt.controledeacesso.domain.entities.*
import br.edu.ifmt.controledeacesso.domain.repositories.ProfessorRepository
import br.edu.ifmt.controledeacesso.domain.repositories.UsuarioRepository
import br.edu.ifmt.controledeacesso.domain.repositories.VisitaRepository
import br.edu.ifmt.controledeacesso.domain.repositories.VisitanteRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.time.LocalDate

/**
 * @project cae-api
 * @author daohn on 06/02/2021
 */
@Configuration
@Profile("docker", "localhost")
class DatabaseConfig(
  private val encoder: BCryptPasswordEncoder,
  private val professorRepository: ProfessorRepository,
  private val usuarioRepository: UsuarioRepository,
  private val visitanteRepository: VisitanteRepository,
  private val visitaRepository: VisitaRepository,
) : CommandLineRunner {

  override fun run(vararg args: String?) {

    val p1 = Professor(null, "Gabriel", "gabriel@gmail.com")
    val p2 = Professor(null, "Ana", "ana@gmail.com")
    val p3 = Professor(null, "Carlos", "carlos@gmail.com")

    val v1 = Visitante(null, "visitante 1", "visitanteUm@gmail.com", "000.000.000-00")
    val v2 = Visitante(null, "visitante 2", "visitanteDois@gmail.com", "000.111.000-00")
    val v3 = Visitante(null, "visitante 3", "visitanteTres@gmail.com", "000.222.000-00")

    professorRepository.saveAll(listOf(p1, p2, p3))
    visitanteRepository.saveAll(listOf(v1, v2, v3))

    val visita1 = Visita(
      null, LocalDate.now().plusDays(10),
      "Buscar livro", false, p1, v1
    )
    val visita2 = Visita(
      null, LocalDate.now().minusDays(5),
      "Atualizar documentos", true, p2, v2
    )
    val visita3 = Visita(
      null, LocalDate.now().minusDays(1), "Devolver livro",
      false, p3, v3
    )
    val visita4 = Visita(
      null, LocalDate.now(), "Devolver livro",
      false, p1, v2
    )
    val visita5 = Visita(
      null, LocalDate.now(), "Devolver livro",
      false, p2, v3
    )
    val visita6 = Visita(
      null, LocalDate.now().plusDays(1), "Devolver livro",
      false, p2, v1
    )

    visitaRepository.saveAll(listOf(visita1, visita2, visita3, visita4, visita5, visita6))

    val u1 = Usuario(
      null,
      "admin",
      "admin",
      encoder.encode("admin"),
      setOf(Perfil.ADMIN)
    )
    val u2 = Usuario(
      null,
      "recepcionista",
      "recepcionista",
      encoder.encode("recepcionista"),
      setOf(Perfil.RECEPCIONISTA)
    )
    val u3 = Usuario(
      null,
      "usuario",
      "usuario",
      encoder.encode("usuario"),
      setOf(Perfil.USUARIO)
    )

    usuarioRepository.saveAll(listOf(u1, u2, u3))
  }

}