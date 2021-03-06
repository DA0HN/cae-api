package br.edu.ifmt.controledeacesso.domain.services

import br.edu.ifmt.controledeacesso.domain.dto.VisitanteDTO
import br.edu.ifmt.controledeacesso.domain.entities.Visitante
import br.edu.ifmt.controledeacesso.domain.repositories.VisitanteRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class VisitanteService(
    private val repository: VisitanteRepository,
    private val modelMapper: ModelMapper,
) {
  fun findAll(): List<VisitanteDTO> {
    return repository.findAll().map(this::buildDTO)
  }

  private fun buildDTO(visitante: Visitante): VisitanteDTO {
    return modelMapper.map(visitante, VisitanteDTO::class.java)
  }
}