package jonathas.IBNCM_API.controllers;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jonathas.IBNCM_API.assembler.FinalidadeAssembler;
import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.DTO.FinalidadeDTO;
import jonathas.IBNCM_API.services.FinalidadeService;

@RestController
@RequestMapping(value = "/finalidades")
public class FinalidadeController {

	@Autowired
	private FinalidadeService service;

	
	@GetMapping
	public ResponseEntity<Page<FinalidadeDTO>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<FinalidadeDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Finalidade> insert(@RequestBody @Validated Finalidade finalidade) {
		return ResponseEntity.ok().body(service.insert(finalidade));

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Finalidade> update(@PathVariable Long id, @RequestBody Finalidade obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);

	}

	/*
	 * @GetMapping public ResponseEntity<Page<Finalidade>> findAll(Pageable
	 * pageable) { return ResponseEntity.ok().body(service.findAll(pageable)); }
	 */

	/*
	 * @GetMapping public ResponseEntity<List<Finalidade>> findAll(){
	 * List<Finalidade> list = service.findAll(null); return
	 * ResponseEntity.ok().body(list); }
	 */

	/*
	 * @GetMapping public ResponseEntity<List<FinalidadeDTO>> findAll(){ return
	 * ResponseEntity.ok().body(finalidadeAssembler.toCollectionDTO(service.findAll(
	 * )));
	 * 
	 * }
	 */

	/*
	 * @GetMapping(value = "/{id}") public ResponseEntity<Finalidade>
	 * findById(@PathVariable Long id){ Finalidade obj = service.findById(id);
	 * return ResponseEntity.ok().body(obj); }
	 */

	/*
	 * @PostMapping public ResponseEntity<Finalidade> insert(@RequestBody Finalidade
	 * obj){ obj = service.insert(obj); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").
	 * buildAndExpand(obj.getId()).toUri(); return
	 * ResponseEntity.created(uri).body(obj);
	 * 
	 * }
	 */

	/*
	 * @PostMapping public ResponseEntity<Object> insert(@RequestBody @Validated
	 * Finalidade finalidade) { service.insert(finalidade); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").
	 * buildAndExpand(finalidade.getId()) .toUri(); return
	 * ResponseEntity.created(uri).body(finalidade); }
	 */

}
