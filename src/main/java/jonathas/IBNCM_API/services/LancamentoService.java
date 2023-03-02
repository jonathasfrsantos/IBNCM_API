package jonathas.IBNCM_API.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.entities.DTO.LancamentoDTO;
import jonathas.IBNCM_API.factory.DTOFactory;
import jonathas.IBNCM_API.repositories.FinalidadeRepository;
import jonathas.IBNCM_API.repositories.LancamentoRepository;
import jonathas.IBNCM_API.services.exceptions.DataBaseException;
import jonathas.IBNCM_API.services.exceptions.ResourceNotFoundException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;
	
	@Autowired
	private FinalidadeService finalidadeService;

	
	@Autowired
	private FinalidadeRepository finalidadeRepository;
	
	@Transactional
	public Lancamento create(LancamentoDTO dto) {
		Finalidade finalidade = finalidadeRepository.findByDescricao(dto.getFinalidade());
		
		if(finalidade == null) {
			finalidade = new Finalidade(null, dto.getFinalidade(), "0");
			finalidadeRepository.save(finalidade);
		}
		
		Lancamento lancamento = new Lancamento(dto.getId(), dto.getData(), dto.getEntrada(), dto.getSaida(), dto.getHistorico(), finalidade, dto.getBancoCaixa());
		
		repository.save(lancamento);
		
		return lancamento;
	}
	
	  
	public List<LancamentoDTO> findAll(){
		List<Lancamento> result = repository.findAllOrderedByData();
		List<LancamentoDTO> dto = result.stream().map((x) -> DTOFactory.createDTO(x)).collect(Collectors.toList());
		return dto;
	}
	
	
	public List<LancamentoDTO> findAllJr(){
		List<Lancamento> result = repository.findByOrderByData();
		List<LancamentoDTO> dto = result.stream().map((x) -> DTOFactory.createDTO(x)).collect(Collectors.toList());
		return dto;
		
	}

	public LancamentoDTO findById(Long id) {
		try {
			Lancamento result = repository.findById(id).get();
			LancamentoDTO dto = DTOFactory.createDTO(result);
			return dto;
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
	}



	public List<LancamentoDTO> findByFinalityDescription(String descricao) {
		List<Lancamento> result = repository.findByFinalidadeDescricao(descricao);
		List<LancamentoDTO> dto = result.stream().map((x) -> DTOFactory.createDTO(x)).collect(Collectors.toList());
		return dto;
	}

	public LancamentoDTO update(Long id, Lancamento obj) {
		try {
			Lancamento newObj= repository.getReferenceById(id);
			Finalidade finalidade = finalidadeRepository.findByDescricao(obj.getFinalidade().getDescricao());
			LancamentoDTO dto = DTOFactory.createDTO(obj);
			updateData(obj, newObj);
			newObj.setFinalidade(finalidade);
			repository.save(newObj);
			return dto;
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

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

	private void updateData(Lancamento obj, Lancamento newObj) {
		newObj.setId(obj.getId());
		newObj.setData(obj.getData());
		newObj.setEntrada(obj.getEntrada());
		newObj.setSaida(obj.getSaida());
		newObj.setFinalidade(obj.getFinalidade());
		newObj.setHistorico(obj.getHistorico());
		newObj.setBancoCaixa(obj.getBancoCaixa());
	
	}
	
	/*
	 * public List<LancamentoDTO> findAll(){ List<Lancamento> result =
	 * repository.findAll(); List<LancamentoDTO> dto = result.stream().map((x) ->
	 * DTOFactory.createDTO(x)).collect(Collectors.toList()); return dto; }
	 * 
	 * public Page<LancamentoDTO> findAll2(Pageable pageable){ Page<Lancamento>
	 * result = repository.findAllOrderByData(pageable); Page<LancamentoDTO> page =
	 * result.map((x) -> DTOFactory.createDTO(x)); return page;
	 * 
	 * }
	 */
	
	/*
	 * public Page<LancamentoDTO> findAll(Pageable pageable) { Page<Lancamento>
	 * result = repository.findAll(pageable); Page<LancamentoDTO> page =
	 * result.map((x) -> DTOFactory.createDTO(x)); return page; }
	 */

	



}
