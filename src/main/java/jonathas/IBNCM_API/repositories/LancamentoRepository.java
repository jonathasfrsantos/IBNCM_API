package jonathas.IBNCM_API.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.entities.DTO.LancamentoDTO;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {


}
