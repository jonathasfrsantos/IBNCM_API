package jonathas.IBNCM_API.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.repositories.LancamentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;
	
	public List<Lancamento> findAll(){
		return repository.findAll();
		
	}
	

	

}
