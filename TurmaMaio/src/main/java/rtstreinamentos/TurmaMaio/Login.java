package rtstreinamentos.TurmaMaio;

public class Login {

	public boolean logar(String login, String senha) {

		if (login.equals("joao@gmail.com") && senha.equals("12345678")) {
			return true;
		}

		return false;

	}

}
