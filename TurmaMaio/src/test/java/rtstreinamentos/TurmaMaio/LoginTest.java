package rtstreinamentos.TurmaMaio;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoginTest {
	
	Login login;
	String loginValido = "joao@gmail.com";
	String senhaValida = "12345678";
	
	@Before
	public void antesDeCadaTeste(){
		login = new Login();
	}
	
	//Dado que eu tenha o login "joao@gmail.com" e senha "12345678" existente no banco de dados
	//Quando eu entro com o email "joao@gmail.com" 
	//E senha "12345678"
	//Então login é efetuado com sucesso	
	@Test
	public void logarComSenhaEEmailValidos()
	{
		
		assertTrue(login.logar(loginValido,senhaValida));
	}
	
	//Quando eu não preencho o login
	//E tenha apenas a senha válida "12345678"
	//Então	o login não é efetuado com sucesso
	@Test
	public void naoLogarQuandoNaoInformarUsuario(){ 
		
		assertFalse(login.logar("","12345678"));
	}
	
	//Quando eu não preencho a senha 
	//E tenho apenas o login válido"joao@gmail.com"
	//Entao o login nao é efetuado com sucesso
	
	@Test
	public void naoLogarQuandoNaoInformarSenha() {
		
		assertFalse(login.logar(loginValido, ""));
	}
	
	//Quando eu informar o login "joao@gmail.com"
	//E informar senhar maior que 10 caracteres
	//Então o login não será efetuado com sucesso
	@Test
	public void naoLogarComSenhaMaiorQue10Caracteres(){
		
		assertFalse(login.logar(loginValido, "12345678911"));
		
	}
	
	
	//Quando eu informar o seguinte e-mail: "joao@gmail.com"
	//E quando informado uma senha com menos de 8 caracteres
	// e clico em logar
	//Então o login não será efetuado
	@Test
	public void naoLogarComSenhaMenorQue8Caracteres(){
		
		assertFalse(login.logar(loginValido,"1234567"));
		}
	
	// Quando tento efetuar o login com o email "paulo.com"
	// Então não consigo logar
	
	// Quando tento efetuar o login com um email com formato inválido
	// Então não consigo logar
	
	@Test
	public void naoLogarComEmailComFormatoInvalido() {
		
		assertFalse(login.logar("paulo.com", "12345678"));
	}

	
	//Quando tento efetuar o login com usuario inexistente
	//E preencho a senha valida "12345678"
	//Então não consigo logar
	@Test
	public void naoLogarComUsuarioInexistente() {
		
		assertFalse(login.logar("naoexistente@gmail.com", "12345678"));
	}
	
	//Quando tento efetuar login com email valido
	//E tento preencher com uma senha incorreta
	//Então o login não é efetuado
	
	
	//Quando tento efetuar login válido "joao@gmail.com"
	//E informo a senha inexistente com 8 caracteres
	//Então o login não é efetuado
	
	//Dado as credencias do João sendo email "joao@gmail.com" senha "12345678"
	//Quando tento efetuar email "joao@gmail.com"
	//E com a senha "12456723"
	//Então o login não é efetuado
	//Então recebo um email de boas vindas
	
	@Test
	
	public void naoLogarComSenhaIncorreta() {
		assertFalse(login.logar(loginValido, "12456723"));
	}
	
}
