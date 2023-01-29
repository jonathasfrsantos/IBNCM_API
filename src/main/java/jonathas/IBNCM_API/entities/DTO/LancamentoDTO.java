package jonathas.IBNCM_API.entities.DTO;

import java.time.LocalDate;

import jonathas.IBNCM_API.entities.Finalidade;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class LancamentoDTO {
	
	private Long id;
	private LocalDate data;
	private Double entrada;
	private Double saida;
	private String historico;
	private String finalidade;
	private String bancoCaixa;
	
	public LancamentoDTO() {
		
	}
	
	public LancamentoDTO(Long id, LocalDate data, Double entrada, Double saida, String historico, Finalidade finalidade, String bancoCaixa) {
		this.id = id;
		this.data = data;
		this.entrada = entrada;
		this.saida = saida;
		this.historico = historico;
		this.finalidade = finalidade.getDescricao();
		this.bancoCaixa = bancoCaixa;
	}


	

}
