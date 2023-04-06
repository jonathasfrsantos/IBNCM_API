package jonathas.IBNCM_API.repositories;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jonathas.IBNCM_API.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	
	
	// SELECT SUM(ENTRADA) AS TOTALSUM FROM TB_LANCAMENTO WHERE DATA BETWEEN '2023-01-01' AND '2023-01-31';
	
	@Query(value = "SELECT *, B.descricao FROM tb_lancamento A INNER JOIN tb_finalidade B",  nativeQuery = true)
	List<Lancamento> findAllTeste();
	
	@Query(value = "SELECT * FROM tb_lancamento WHERE DATA BETWEEN :data_inicial AND :data_final", nativeQuery = true)
	List<Lancamento> findAllDateSelected(@Param("data_inicial") LocalDate data_inicial, @Param("data_final") LocalDate data_final);
	
	@Query(value = "SELECT SUM(ENTRADA) AS totaSum FROM tb_lancamento WHERE DATA BETWEEN :data_inicial AND :data_final", nativeQuery = true)
	Double totalEntradasPerPeriodo(@Param("data_inicial") LocalDate data_inicial, @Param("data_final") LocalDate data_final);
	
	@Query(value = "SELECT * FROM tb_lancamento WHERE date_part('month', data) = date_part('month', CURRENT_DATE) AND date_part('year', data) = date_part('year', CURRENT_DATE)", nativeQuery = true)
	List<Lancamento> findAllCurrentMonth();
	
	@Query(value = "SELECT * FROM tb_lancamento l ORDER BY l.data", nativeQuery = true)
	Page<Lancamento> findAllOrderByData(Pageable pageable);
	
	@Query(value = "SELECT * FROM tb_lancamento l ORDER BY l.data", nativeQuery = true)
	List<Lancamento> findAllOrderedByData();
	
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
