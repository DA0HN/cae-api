package br.edu.ifmt.controledeacesso.api.controllers

import br.edu.ifmt.controledeacesso.domain.dto.ProfessorDTO
import br.edu.ifmt.controledeacesso.domain.dto.VisitanteDTO
import br.edu.ifmt.controledeacesso.domain.services.VisitanteService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/visitantes")
class VisitanteController(private val service: VisitanteService) {
  @GetMapping
  @Secured("ROLE_ADMIN")
  fun findAll(): ResponseEntity<List<VisitanteDTO>> {
    val visitante = service.findAll()
    return ResponseEntity.ok(visitante)
  }

  @GetMapping("/{id}")
  @Secured("ROLE_ADMIN")
  fun findById(@PathVariable("id") id: Long): ResponseEntity<VisitanteDTO> {
    val visitante = service.findById(id)
    return ResponseEntity.ok(visitante)
  }
}