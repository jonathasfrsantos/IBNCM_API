package jonathas.IBNCM_API.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.entities.DTO.LancamentoDTO;
import jonathas.IBNCM_API.repositories.LancamentoRepository;
import jonathas.IBNCM_API.services.LancamentoService;

@RestController
@RequestMapping(value = "/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService service;
	
	@Autowired
	private LancamentoRepository repository;
	
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Lancamento> insert(@RequestBody @Validated Lancamento lancamento) {
		return ResponseEntity.ok().body(service.insert(lancamento));

	}
	
	
	@GetMapping
	public ResponseEntity<Page<LancamentoDTO>> findAll(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable){
		return ResponseEntity.ok().body(service.findAll(pageable));
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LancamentoDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	/*
	 * @GetMapping("/filter") public ResponseEntity<List<LancamentoDTO>>
	 * findByFinality(@RequestParam("finalidade") Finalidade finalidade){ return
	 * ResponseEntity.ok().body(service.findAllByFinality(finalidade)); }
	 */
	
	@GetMapping("/filter")
	public ResponseEntity<List<LancamentoDTO>> findByFinalityDescription(@RequestParam("finalidade") String descricao){
		return ResponseEntity.ok().body(service.findByFinalityDescription(descricao));
	}
	
	@GetMapping("/getEntradas")
	public List<Lancamento> getEntradas() {
		return repository.findAllEntrada();
	}
	
	@GetMapping("/getSaidas")
	public List<Lancamento> getSaidas() {
		return repository.findAllSaida();
	}
	
	@GetMapping("/getTotalDizimos")
	public Double getTotalDizimos() {
		return repository.totalDizimos();
	}
	
	@GetMapping("/getTotalEntradas")
	public Double getTotalEntradas() {
		return repository.totalEntradas();
	}
	
	@GetMapping("/getTotalSaidas")
	public Double getTotalSaidas() {
		return repository.totalSaidas();
	}
	

	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Lancamento> update(@PathVariable Long id, @RequestBody Lancamento obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	
	/*
	 * @PostMapping public ResponseEntity<Lancamento> insert(@RequestBody Lancamento
	 * obj){ obj = service.insert(obj); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").
	 * buildAndExpand(obj.getId()).toUri(); return
	 * ResponseEntity.created(uri).body(obj);
	 * 
	 * }
	 */
	

}
