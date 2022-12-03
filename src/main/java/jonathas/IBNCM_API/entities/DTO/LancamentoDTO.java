package jonathas.IBNCM_API.entities.DTO;

import java.time.LocalDate;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.enums.BancoCaixa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class LancamentoDTO {
	
	private Long id;
	private LocalDate data;
	private Double entrada;
	private Double saida;
	private String historico;
	private Finalidade finalidade;
	private BancoCaixa bancoCaixa;
	

}
