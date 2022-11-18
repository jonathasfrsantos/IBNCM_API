package jonathas.IBNCM_API.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.services.LancamentoService;

@RestController
@RequestMapping(value = "/lançamentos")
public class FinalidadeResource {
	
	@Autowired
	private LancamentoService service;
	
	@GetMapping
	public ResponseEntity<List<Lancamento>> findAll(){
		List<Lancamento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
