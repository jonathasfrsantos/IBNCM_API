package jonathas.IBNCM_API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.services.LancamentoService;

@RestController
@RequestMapping(value = "/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService service;
	
	@GetMapping
	public ResponseEntity<Page<Lancamento>> findAll(Pageable pageable){
		return ResponseEntity.ok().body(service.findAll(pageable));
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Lancamento> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Lancamento> insert(@RequestBody @Validated Lancamento lancamento) {
		return ResponseEntity.ok().body(service.insert(lancamento));
		
	}
	
	

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Lancamento> update(@PathVariable Long id, @RequestBody Lancamento obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	
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