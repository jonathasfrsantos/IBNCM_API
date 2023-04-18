package jonathas.IBNCM_API.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.entities.DTO.LancamentoDTO;
import jonathas.IBNCM_API.factory.DTOFactory;
import jonathas.IBNCM_API.repositories.FinalidadeRepository;
import jonathas.IBNCM_API.repositories.LancamentoRepository;
import jonathas.IBNCM_API.services.LancamentoService;

@RestController
@RequestMapping(value = "/lancamentos")
@CrossOrigin(origins = "http://localhost:3000")
public class LancamentoController {

	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	private LancamentoService service;

	@Autowired
	private LancamentoRepository repository;

	@Autowired
	private FinalidadeRepository finalidadeRepository;

	/*
	 * @PostMapping
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public ResponseEntity<Lancamento>
	 * insert(@RequestBody @Validated Lancamento lancamento) { return
	 * ResponseEntity.ok().body(service.insert(lancamento));
	 * 
	 * }
	 */

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<LancamentoDTO> create(@RequestBody @Validated LancamentoDTO dto) {
		return ResponseEntity.ok().body(service.create(dto));

	}
	/*
	 * @GetMapping public ResponseEntity<Page<LancamentoDTO>> findAll(
	 * 
	 * @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC)
	 * Pageable pageable){ return
	 * ResponseEntity.ok().body(service.findAll(pageable));
	 * 
	 * }
	 */

	@GetMapping
	public ResponseEntity<List<LancamentoDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());

	}
	



	@GetMapping("/getTotalEntradasPerPeriod")
	public Double getTotalEntradasPerPeriodo(@RequestParam("dataInicial") LocalDate dataInicial,
			@RequestParam("dataFinal") LocalDate dataFinal) {
		return repository.totalEntradasPerPeriodo(dataInicial, dataFinal);
	}
	
	@GetMapping("/getByDateInterval")
	public ResponseEntity<List<LancamentoDTO>> getByDateInterval(
	    @RequestParam("dataInicial") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial,
	    @RequestParam("dataFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal) {
    
	    return ResponseEntity.ok().body(service.findByDateInterval(dataInicial, dataFinal));
	}
	
	@GetMapping("/getByCurrentMonth")
	public ResponseEntity<List<LancamentoDTO>> getByCurrentMonth(){
		return ResponseEntity.ok().body(service.findByCurrentMonth());
	
	}



	
		/*
		 * @GetMapping("/currentMonth") public ResponseEntity<List<Lancamento>>
		 * findAllCurrentMonth(){ return
		 * ResponseEntity.ok().body(repository.findAllCurrentMonth()); }
		 */
	
	@GetMapping("/testeQueryNative")
	public ResponseEntity<List<Lancamento>> findAllTeste(){
		return ResponseEntity.ok().body(repository.findAllTeste());
	}
	
	

	/*
	 * @GetMapping("/getTotalEntradasPerPeriod") public Double
	 * getTotalEntradasPerPeriodo(
	 * 
	 * @Param("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	 * LocalDate dataInicial,
	 * 
	 * @Param("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
	 * dataFinal) {
	 * 
	 * return repository.totalEntradasPerPeriodo(dataInicial, dataFinal); }
	 */
	/*
	 * @GetMapping("/allOrderByData") public ResponseEntity<Page<LancamentoDTO>>
	 * findAll2(
	 * 
	 * @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC)
	 * Pageable pageable){ return
	 * ResponseEntity.ok().body(service.findAll2(pageable));
	 * 
	 * }
	 */

	@GetMapping(value = "/{id}")
	public ResponseEntity<LancamentoDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	/*
	 * @GetMapping("/filter") public ResponseEntity<List<LancamentoDTO>>
	 * findByFinality(@RequestParam("finalidade") Finalidade finalidade){ return
	 * ResponseEntity.ok().body(service.findAllByFinality(finalidade)); }
	 */

	@GetMapping("/filter")
	public ResponseEntity<List<LancamentoDTO>> findByFinalityDescription(@RequestParam("finalidade") String descricao) {
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

	@GetMapping("/getAllDizimos")
	public List<Lancamento> getAllDizimos() {
		return repository.findAllDizimos();
	}

	/*
	 * @PutMapping(value = "/{id}") public ResponseEntity<LancamentoDTO>
	 * update(@PathVariable Long id, @RequestBody Lancamento obj) { return
	 * ResponseEntity.ok().body(service.update(id, obj));
	 * 
	 * }
	 */
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LancamentoDTO> update(@PathVariable Long id, @RequestBody LancamentoDTO dto){
		return ResponseEntity.ok().body(service.update2(id, dto));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
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
