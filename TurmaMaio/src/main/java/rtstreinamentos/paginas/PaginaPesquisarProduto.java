package rtstreinamentos.paginas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaPesquisarProduto extends Pagina {

	public PaginaPesquisarProduto() {
		abrirBrowser();
		driver.get("http://tghcastro.lojaintegrada.com.br/");

	}
	public WebElement obterListaDeFilmes() {
		
		
		WebElement listaDeFilmes = driver.findElement(By
				.className("listagem-linha"));
		return listaDeFilmes;
	}
	public void preencherCaixaDePesquisa(String nomeFilme) {
		WebElement caixaPesquisa = driver.findElement(By.id("auto-complete"));
		caixaPesquisa.sendKeys(nomeFilme);
		
	}
	public ResultadoPesquisa clicarBotaoPesquisa() {
		WebElement botaoPesquisa = driver.findElement(By.xpath("//*[@id=\"form-buscar\"]/button"));
		botaoPesquisa.click();
		return new ResultadoPesquisa();
		

	}
	
	
	
	public List<WebElement> listarTodosFilmesCapa (){
		List<WebElement> ListaDeFilmes = driver.findElements(By
				.xpath("//*[@id=\"listagemProdutos\"]/ul/li/ul/li"));
		return ListaDeFilmes;
	}

}
