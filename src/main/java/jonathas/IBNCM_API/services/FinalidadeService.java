package jonathas.IBNCM_API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.repositories.FinalidadeRepository;
import jonathas.IBNCM_API.services.exceptions.DataBaseException;
import jonathas.IBNCM_API.services.exceptions.ExistThisValueAlready;
import jonathas.IBNCM_API.services.exceptions.ResourceNotFoundException;

@Service
public class FinalidadeService {

	@Autowired
	private FinalidadeRepository repository;

	public Page<Finalidade> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	
	public Finalidade findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));		
	}
	
	@Transactional
	public Finalidade insert (Finalidade finalidade) {
			if(existsByDescricao(finalidade.getDescricao())) {
				throw new ExistThisValueAlready(finalidade.getDescricao(), finalidade);
			}
			
			return repository.save(finalidade);
	

	}	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Finalidade update(Long id, Finalidade obj) {
		try {
			Finalidade entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateData(Finalidade entity, Finalidade obj) {
		entity.setContaContabil(obj.getContaContabil());
		entity.setDescricao(obj.getDescricao());

	}

	public boolean existsByDescricao(String descricao) {
		return repository.existsByDescricao(descricao);
	}



	/*
	 * public List<Finalidade> findAll(){ return repository.findAll();
	 * 
	 * }
	 */

	/*
	 * public Finalidade findById(Long id) { Optional<Finalidade> obj =
	 * repository.findById(id); return obj.orElseThrow(() -> new
	 * ResourceNotFoundException(id)); }
	 */
	
	
	/*
	 * public FinalidadeDTO findById(Long id) { try { Finalidade entity =
	 * repository.findById(id).get(); FinalidadeDTO dto = new FinalidadeDTO();
	 * dto.toDTO(entity); return dto;
	 * 
	 * } catch (NoSuchElementException e) { throw new ResourceNotFoundException(id);
	 * }
	 * 
	 * }
	 */
	
	
	/*
	 * @Transactional public Finalidade insert(Finalidade obj) { return
	 * repository.save(obj); }
	 */

}
