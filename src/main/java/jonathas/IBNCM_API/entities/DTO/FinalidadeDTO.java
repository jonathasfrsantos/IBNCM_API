package jonathas.IBNCM_API.entities.DTO;

import jonathas.IBNCM_API.entities.Finalidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class FinalidadeDTO {

	private Long id;
	private String descricao;

	/*
	 * public FinalidadeDTO(Finalidade finalidade) { id = finalidade.getId();
	 * descricao = finalidade.getDescricao(); }
	 */


}
