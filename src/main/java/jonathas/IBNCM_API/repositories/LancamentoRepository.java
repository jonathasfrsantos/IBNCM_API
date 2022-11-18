package jonathas.IBNCM_API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import jonathas.IBNCM_API.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
