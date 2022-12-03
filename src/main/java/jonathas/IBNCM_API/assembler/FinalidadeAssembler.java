package jonathas.IBNCM_API.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.DTO.FinalidadeDTO;

@Component
public class FinalidadeAssembler {

	private ModelMapper modelMapper;

	public FinalidadeDTO toDTO(Finalidade finalidade) {

		return modelMapper.map(finalidade, FinalidadeDTO.class);

	}

	public List<FinalidadeDTO> toCollectionDTO(List<Finalidade> finalidades) {
		return finalidades.stream().map(this::toDTO).collect(Collectors.toList());

	}

}
