package jonathas.IBNCM_API.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.services.LancamentoService;

@RestController
@RequestMapping(value = "/lançamentos")
public class LancamentoResource {
	
	@Autowired
	private LancamentoService service;
	
	@GetMapping
	public ResponseEntity<List<Lancamento>> findAll(){
		List<Lancamento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Lancamento> findById(@PathVariable Long id){
		Lancamento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Lancamento> insert(@RequestBody Lancamento obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
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

}
