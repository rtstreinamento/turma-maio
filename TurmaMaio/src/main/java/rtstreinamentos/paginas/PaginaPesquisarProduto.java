package rtstreinamentos.paginas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PaginaPesquisarProduto {

	WebDriver driver;
	public PaginaPesquisarProduto() {
		System.setProperty("webdriver.chrome.driver",	"c:\\web-drivers\\chromedriver.exe");
		System.setProperty("phantom.binary.path",	"c:\\web-drivers\\phantomjs.exe");
		
		//driver = new ChromeDriver();
		driver = new PhantomJSDriver();
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
	public void clicarBotaoPesquisa() {
		WebElement botaoPesquisa = driver.findElement(By
				.xpath("//*[@id=\"form-buscar\"]/button"));
		botaoPesquisa.click();
		

	}
	
	public String verResultadoPesquisa () {
		String filmeAtual = driver.findElement(By.className("nome-produto"))
				.getText();
		return filmeAtual;
	}
	
	public List<WebElement> listarTodosFilmesCapa (){
		List<WebElement> ListaDeFilmes = driver.findElements(By
				.xpath("//*[@id=\"listagemProdutos\"]/ul/li/ul/li"));
		return ListaDeFilmes;
	}

}
