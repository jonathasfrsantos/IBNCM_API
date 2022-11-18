package jonathas.IBNCM_API.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.services.FinalidadeService;

@RestController
@RequestMapping(value = "/finalidades")
public class LancamentoResource {
	
	@Autowired
	private FinalidadeService service;
	
	@GetMapping
	public ResponseEntity<List<Finalidade>> findAll(){
		List<Finalidade> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
