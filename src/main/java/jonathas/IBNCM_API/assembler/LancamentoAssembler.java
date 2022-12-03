package jonathas.IBNCM_API.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.entities.DTO.LancamentoDTO;

@Component
public class LancamentoAssembler {

	private ModelMapper modelMapper;

	public LancamentoDTO toDTO(Lancamento lancamento) {

		return modelMapper.map(lancamento, LancamentoDTO.class);

	}

	public List<LancamentoDTO> toCollectionDTO(List<Lancamento> finalidades) {
		return finalidades.stream().map(this::toDTO).collect(Collectors.toList());

	}

}
