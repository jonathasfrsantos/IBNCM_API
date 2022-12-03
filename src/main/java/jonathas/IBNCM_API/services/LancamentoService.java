package jonathas.IBNCM_API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.repositories.LancamentoRepository;
import jonathas.IBNCM_API.services.exceptions.DataBaseException;
import jonathas.IBNCM_API.services.exceptions.ResourceNotFoundException;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;
	
	public Page<Lancamento> findAll(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public Lancamento findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	@Transactional
	public Lancamento insert(Lancamento lancamento) {
		return repository.save(lancamento);
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
