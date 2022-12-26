package jonathas.IBNCM_API.entities.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.enums.BancoCaixa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
	private BancoCaixa bancoCaixa;
	
	public LancamentoDTO() {
		
	}
	
	public LancamentoDTO(Long id, LocalDate data, Double entrada, Double saida, String historico, Finalidade finalidade, BancoCaixa bancoCaixa) {
		this.id = id;
		this.data = data;
		this.entrada = entrada;
		this.saida = saida;
		this.historico = historico;
		this.finalidade = finalidade.getDescricao();
		this.bancoCaixa = bancoCaixa;
			
	}


	

}
