package rtstreinamentos.TurmaMaio.Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rtstreinamentos.paginas.PaginaPesquisarProduto;
import rtstreinamentos.paginas.ResultadoPesquisa;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PesquisarProdutoSteps {

	WebDriver driver;
	PaginaPesquisarProduto pesquisarProduto = new PaginaPesquisarProduto();
	ResultadoPesquisa paginaResultado;

	@Dado("^que eu tenha um produto cadastrado$")
	public void que_eu_tenha_um_produto_cadastrado() throws Throwable {

		assertNotNull(pesquisarProduto.obterListaDeFilmes());
	}

	@Dado("^que eu tenha dois filmes com pelo menos uma palavra igual$")
	public void que_eu_tenha_dois_filmes_com_pelo_menos_uma_palavra_igual()
			throws Throwable {
		List<WebElement> ListaDeFilmes = pesquisarProduto
				.listarTodosFilmesCapa();

		String primeiroFilmeDaCapa = ListaDeFilmes.get(0).getText();
		String segundoFilmeDaCapa = ListaDeFilmes.get(1).getText();

		assertTrue(primeiroFilmeDaCapa.contains("Anéis"));
		assertTrue(segundoFilmeDaCapa.contains("Anéis"));
	}

	@Dado("^que o produto \"([^\"]*)\" não está disponível em estoque$")
	public void que_o_produto_não_está_disponível_em_estoque(String arg1)
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Dado("^que o produto \"([^\"]*)\" não esteja cadastrado no sistema$")
	public void que_o_produto_não_esteja_cadastrado_no_sistema(String arg1)
			throws Throwable {
		
	}

	@Dado("^que eu tenha produtos cadastrados$")
	public void que_eu_tenha_produtos_cadastrados() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Quando("^eu pesquiso por \"([^\"]*)\"$")
	public void eu_pesquiso_por(String nomeFilme) throws Throwable {
		pesquisarProduto.preencherCaixaDePesquisa(nomeFilme);
		paginaResultado = pesquisarProduto.clicarBotaoPesquisa();

	}

	@Quando("^eu pesquiso sem informar o produto$")
	public void eu_pesquiso_sem_informar_o_produto() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Então("^visualizo o resultado da pesquisa$")
	public void visualizo_o_resultado_da_pesquisa() throws Throwable {

		String filmeEsperado = "Bluray - Thor";
		String filmeAtual = paginaResultado.verResultadoPesquisa();
		assertEquals(filmeEsperado, filmeAtual);
	}

	@Então("^visualizo os resultados \"([^\"]*)\" - \"([^\"]*)\"$")
	public void visualizo_os_resultados_(String filmeEsperado1,
			String filmeEsperado2) throws Throwable {

		String filme1Exibido = paginaResultado
				.obterPrimeiroFilmeDoResultadoDeBusca();
		assertEquals(filmeEsperado1, filme1Exibido);
		String filme2Exibido = paginaResultado
				.obterSegundoFilmeDoResultadoDeBusca();
		assertEquals(filmeEsperado2, filme2Exibido);
	}

	@Então("^visualizo mensagem de produto indisponível$")
	public void visualizo_mensagem_de_produto_indisponível() throws Throwable {
		String filmeIndisponivel = paginaResultado.mensagemProdutoIndisponivel();
		assertTrue(filmeIndisponivel.contains("Indisponível"));
	}

	@Então("^visualizo mensagem de produto inexistente$")
	public void visualizo_mensagem_de_produto_inexistente() throws Throwable {
		String mensagemProdutoInexistente = paginaResultado.mensagemProdutoInexistente();
		String mensagemEsperada="produto não cadastrado";
		assertEquals(mensagemEsperada, mensagemProdutoInexistente);
	}

	@Então("^visualizo todos os produtos$")
	public void visualizo_todos_os_produtos() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

}
