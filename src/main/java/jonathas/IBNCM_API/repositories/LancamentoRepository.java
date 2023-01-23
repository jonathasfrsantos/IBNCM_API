package jonathas.IBNCM_API.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	
	@Query(value = "SELECT * FROM tb_lancamento l ORDER BY l.data", nativeQuery = true)
	Page<Lancamento> findAllOrderByData(Pageable pageable);
	
	@Query(value = "SELECT * FROM tb_lancamento WHERE ENTRADA IS NOT NULL", nativeQuery = true)
	List<Lancamento> findAllEntrada();
	
	@Query(value = "SELECT * FROM tb_lancamento WHERE SAIDA IS NOT NULL", nativeQuery = true)
	List<Lancamento> findAllSaida();
	
	@Query(value = "SELECT * FROM tb_lancamento l WHERE FINALIDADE_ID = 1 ORDER BY  l.data", nativeQuery = true )
	List<Lancamento> findAllDizimos();

	
	List<Lancamento> findByFinalidadeDescricao(String descricao);
	
	@Query(value = "SELECT SUM(ENTRADA) AS totalDizimos FROM tb_lancamento WHERE FINALIDADE_ID = 1", nativeQuery = true)
	double totalDizimos();
	
	@Query(value = "SELECT SUM(ENTRADA) AS totalEntradas FROM tb_lancamento", nativeQuery = true)
	double totalEntradas();
	
	@Query(value = "SELECT SUM(SAIDA) AS totalSaidas FROM tb_lancamento", nativeQuery = true)
	double totalSaidas();
	
	List<Lancamento> findByOrderByData();


}
