package br.edu.ifmt.controledeacesso.models.dto

import br.edu.ifmt.controledeacesso.config.NoArg

/**
 * Created by daohn on 09/02/2021
 * @author daohn
 * @since 09/02/2021
 * @version 1.0.0
 */
@NoArg
data class VisitaSaveDTO(
  var data: String,
  var motivo: String,
  var ocorrido: Boolean,
  var professor: ProfessorDTO,
  var visitante: VisitanteDTO,
) {

}