package jonathas.IBNCM_API.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	
	List<Lancamento> findByFinalidade(Finalidade finalidade);
	
	List<Lancamento> findByFinalidadeDescricao(String descricao);
	
	@Query(value = "SELECT SUM(ENTRADA) AS totalDizimos FROM tb_lancamento WHERE FINALIDADE_ID = 1", nativeQuery = true)
	double totalDizimos();
	



}
