package rtstreinamentos.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class Pagina {

	protected WebDriver driver;
	public void abrirBrowser() {
		System.setProperty("webdriver.chrome.driver",	"c:\\web-drivers\\chromedriver.exe");
		System.setProperty("phantom.binary.path",	"c:\\web-drivers\\phantomjs.exe");
		
		driver = new ChromeDriver();
		//driver = new PhantomJSDriver();
	}
	
}
