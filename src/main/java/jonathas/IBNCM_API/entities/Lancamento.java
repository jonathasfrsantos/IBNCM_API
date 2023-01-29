package jonathas.IBNCM_API.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_lancamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long id;
	private LocalDate data;
	private Double entrada;
	private Double saida;
	private String historico;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "finalidade_id")
	private Finalidade finalidade;
	@Column(name = "banco_caixa")
	private String bancoCaixa;

	
	
	
	
	
	
	
	
	
	

}
