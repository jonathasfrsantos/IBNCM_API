package jonathas.IBNCM_API.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jonathas.IBNCM_API.entities.Finalidade;

public interface FinalidadeRepository extends JpaRepository<Finalidade, Long> {
	
	boolean existsByDescricao(String descricao);
	
	List<Finalidade> findByDescricaoContains(String descricao);
	
	
	
	
	
	

}
