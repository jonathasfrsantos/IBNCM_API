package jonathas.IBNCM_API.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.DTO.FinalidadeDTO;

public interface FinalidadeRepository extends JpaRepository<Finalidade, Long> {
	
	boolean existsByDescricao(String descricao);
	
	List<Finalidade> findByDescricaoContains(String descricao);
	
	Finalidade findByDescricao(String descricao);
	
	@Query(value = "SELECT f.descricao FROM tb_finalidade f ORDER BY f.descricao", nativeQuery=true)
	List<Finalidade> findAllByDescription();
	

	
	
	
	
	
	
	
	
	

}
