package jonathas.IBNCM_API.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jonathas.IBNCM_API.converters.ConverterDTO;
import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.DTO.FinalidadeDTO;
import jonathas.IBNCM_API.factory.DTOFactory;
import jonathas.IBNCM_API.repositories.FinalidadeRepository;
import jonathas.IBNCM_API.services.exceptions.DataBaseException;
import jonathas.IBNCM_API.services.exceptions.ExistThisValueAlready;
import jonathas.IBNCM_API.services.exceptions.ResourceNotFoundException;

@Service
public class FinalidadeService implements ConverterDTO {

	@Autowired
	private FinalidadeRepository repository;

	@Autowired
	public ModelMapper modelMapper;

	@Transactional
	public Finalidade insert(Finalidade finalidade) {
		if (existsByDescricao(finalidade.getDescricao())) {
			throw new ExistThisValueAlready(finalidade.getDescricao(), finalidade);
		}

		return repository.save(finalidade);

	}

	public FinalidadeDTO findById(Long id) {
		try {
			Finalidade result = repository.findById(id).get();
			FinalidadeDTO dto = DTOFactory.createDTO(result);
			return dto;

		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Page<FinalidadeDTO> findAll(Pageable pageable) {
		Page<Finalidade> result = repository.findAll(pageable);
		Page<FinalidadeDTO> page = result.map((x) -> DTOFactory.createDTO(x));
		return page;
	}
	
	public List<FinalidadeDTO> findAllByDescription(String description){
		List<Finalidade> result = repository.findByDescricaoContains(description);
		List<FinalidadeDTO> listDTO = result
				.stream()
				.map((x) -> DTOFactory.createDTO(x))
				.collect(Collectors.toList());
		return listDTO;
		
		
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

	@Transactional
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	private void updateData(Finalidade newObj, Finalidade oldObj) {
		newObj.setDescricao(oldObj.getDescricao());
		newObj.setContaContabil(oldObj.getContaContabil());
	}

	public boolean existsByDescricao(String descricao) {
		return repository.existsByDescricao(descricao);
	}

	@Override
	public FinalidadeDTO entityToDTo(Finalidade finalidade) {
		FinalidadeDTO dto = new FinalidadeDTO();
		dto.setId(finalidade.getId());
		dto.setDescricao(finalidade.getDescricao());
		return dto;
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

	/*
	 * public FinalidadeDTO findById(Long id) { try { Finalidade result =
	 * repository.findById(id).get(); FinalidadeDTO dto = entityToDTo(result);
	 * return dto;
	 * 
	 * } catch (NoSuchElementException e) { throw new ResourceNotFoundException(id);
	 * }
	 * 
	 * }
	 */

}
