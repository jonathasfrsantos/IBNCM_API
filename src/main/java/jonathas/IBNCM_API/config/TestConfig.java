package jonathas.IBNCM_API.config;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
		
		/*
		 * Finalidade f1 = new Finalidade(null, "dízimos", "0"); Finalidade f2 = new
		 * Finalidade(null, "ofertas", "0"); Finalidade f3 = new Finalidade(null,
		 * "lanches e refeições", "0"); Finalidade f4 = new Finalidade(null,
		 * "energia elétrica", "0"); Finalidade f5 = new Finalidade(null,
		 * "Água e esgoto", "0"); Finalidade f6 = new Finalidade(null, "Internet", "0");
		 * Finalidade f7 = new Finalidade(null, "Prestação de serviços - PJ", "0");
		 * 
		 * 
		 * 
		 * finalidadeRepo.saveAll(Arrays.asList(f1, f2, f3, f4, f5, f6, f7));
		 */
		
//Lancamento l1 = new Lancamento(null, LocalDate.parse("02/10/2022", formatter), 100.00, null, "Laura rato", f1, BancoCaixa.CAIXA);
		
		
		
		/*
		 * Lancamento l1 = new Lancamento(null, LocalDate.parse("02/10/2022",
		 * formatter), 100.00, null, "Laura", f1, BancoCaixa.CAIXA); Lancamento l2 = new
		 * Lancamento(null, LocalDate.parse("02/10/2022", formatter), 260.00, null,
		 * "Maria", f1, BancoCaixa.CAIXA); Lancamento l3 = new Lancamento(null,
		 * LocalDate.parse("01/10/2022", formatter), null, 35.69,
		 * "Mercado tal LTDA - lanche irmãos", f3, BancoCaixa.CAIXA); Lancamento l4 =
		 * new Lancamento(null, LocalDate.parse("14/10/2022", formatter), null, 978.97,
		 * "Light S.A.", f4, BancoCaixa.ITAÚ); Lancamento l5 = new Lancamento(null,
		 * LocalDate.parse("15/10/2022",formatter), 520.00, null, "Oferta fulano", f2,
		 * BancoCaixa.CAIXA); Lancamento l6 = new Lancamento(null,
		 * LocalDate.parse("05/10/2022",formatter), 125.00, null, "Oferta beltrano", f2,
		 * BancoCaixa.ITAÚ); Lancamento l7 = new Lancamento(null,
		 * LocalDate.parse("16/10/2022",formatter), null, 213.00,
		 * "Águas do rio SPE - set/2022", f5, BancoCaixa.ITAÚ); Lancamento l8 = new
		 * Lancamento(null, LocalDate.parse("19/10/2022",formatter), null, 99.98,
		 * "VIVO INTERNET ", f6, BancoCaixa.ITAÚ); Lancamento l9 = new Lancamento(null,
		 * LocalDate.parse("06/10/2022",formatter), null, 150.00,
		 * "Manutenção ar condicionado ", f7, BancoCaixa.CAIXA);
		 */
		
		
		
		
		//lancamentoRepo.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9));
		
		
		
		
		
	}

}
