package jonathas.IBNCM_API.converters;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.DTO.FinalidadeDTO;

public interface ConverterDTO {
	
	FinalidadeDTO entityToDTo(Finalidade finalidade);
	
	

}
