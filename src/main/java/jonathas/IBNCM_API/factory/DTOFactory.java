package jonathas.IBNCM_API.factory;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.entities.DTO.FinalidadeDTO;
import jonathas.IBNCM_API.entities.DTO.LancamentoDTO;

public class DTOFactory {

	public static FinalidadeDTO createDTO(Finalidade finalidade) {
		FinalidadeDTO dto = new FinalidadeDTO();
		dto.setId(finalidade.getId());
		dto.setDescricao(finalidade.getDescricao());
		return dto;

	}

	public static LancamentoDTO createDTO(Lancamento lancamento) {
		LancamentoDTO dto = new LancamentoDTO();
		dto.setData(lancamento.getData());
		dto.setEntrada(lancamento.getEntrada());
		dto.setSaida(lancamento.getSaida());
		dto.setHistorico(lancamento.getHistorico());
		dto.setFinalidade(lancamento.getFinalidade().getDescricao());
		dto.setBancoCaixa(lancamento.getBancoCaixa());
		return dto;

	}

}
