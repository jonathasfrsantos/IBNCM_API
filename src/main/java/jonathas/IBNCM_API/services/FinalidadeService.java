package jonathas.IBNCM_API.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.repositories.FinalidadeRepository;

@Service
public class FinalidadeService {
	
	@Autowired
	private FinalidadeRepository repository;
	
	public List<Finalidade> findAll(){
		return repository.findAll();
		
	}
	

	

}
