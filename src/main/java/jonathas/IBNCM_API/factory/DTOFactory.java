package jonathas.IBNCM_API.factory;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.DTO.FinalidadeDTO;

public class DTOFactory {
	
	public static FinalidadeDTO createDTO(Finalidade finalidade) {
		FinalidadeDTO dto = new FinalidadeDTO();
		dto.setId(finalidade.getId());
		dto.setDescricao(finalidade.getDescricao());
		return dto;
	
	}

}
