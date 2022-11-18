package jonathas.IBNCM_API.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.convert.Jsr310Converters.LocalDateTimeToDateConverter;

import jonathas.IBNCM_API.entities.Finalidade;
import jonathas.IBNCM_API.entities.Lancamento;
import jonathas.IBNCM_API.entities.enums.BancoCaixa;
import jonathas.IBNCM_API.repositories.FinalidadeRepository;
import jonathas.IBNCM_API.repositories.LancamentoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Autowired
	private LancamentoRepository lancamentoRepo;
	
	@Autowired
	private FinalidadeRepository finalidadeRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Finalidade f1 = new Finalidade(null, "dízimos", "0");
		Finalidade f2 = new Finalidade(null, "ofertas", "0");
		Finalidade f3 = new Finalidade(null, "lanches e refeições", "0");
		Finalidade f4 = new Finalidade(null, "energia elétrica", "0");
		
		
		finalidadeRepo.saveAll(Arrays.asList(f1, f2, f3, f4));
		
		Lancamento l1 = new Lancamento(null, LocalDate.parse("02/10/2022", formatter), 100.00, null, "Laura", f1, BancoCaixa.CAIXA);
		Lancamento l2 = new Lancamento(null, LocalDate.parse("02/10/2022", formatter), 260.00, null, "Maria", f1, BancoCaixa.CAIXA);
		Lancamento l3 = new Lancamento(null, LocalDate.parse("01/10/2022", formatter), null, 35.69, "Mercado tal LTDA - lanche irmãos", f3, BancoCaixa.CAIXA);
		Lancamento l4 = new Lancamento(null, LocalDate.parse("14/10/2022", formatter), null, 978.97, "Light S.A.", f4, BancoCaixa.ITAÚ);
		
		lancamentoRepo.saveAll(Arrays.asList(l1, l2, l3, l4));
		
		
		
		
		
	}

}
