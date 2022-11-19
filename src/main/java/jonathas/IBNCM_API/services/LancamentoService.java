package jonathas.IBNCM_API.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.repositories.LancamentoRepository;
import jonathas.IBNCM_API.services.exceptions.DataBaseException;
import jonathas.IBNCM_API.services.exceptions.ResourceNotFoundException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;
	
	public List<Lancamento> findAll(){
		return repository.findAll();
		
	}
	
	public Lancamento findById(Long id) {
		Optional<Lancamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Lancamento insert(Lancamento obj) {
		return repository.save(obj);
	}
	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);	
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public Lancamento update(Long id, Lancamento obj) {
		try {
			Lancamento entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Lancamento entity, Lancamento obj) {
		entity.setData(obj.getData());
		entity.setEntrada(obj.getEntrada());
		entity.setSaida(obj.getSaida());
		entity.setFinalidade(obj.getFinalidade());
		entity.setHistorico(obj.getHistorico());
		entity.setBancoCaixa(obj.getBancoCaixa());
		
	}
	

	

}
