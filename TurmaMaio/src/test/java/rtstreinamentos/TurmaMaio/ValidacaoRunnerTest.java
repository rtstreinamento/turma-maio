package rtstreinamentos.TurmaMaio;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = { "@validação", "~@execuçãoManual" }, format = { "json:target/cucumber.json" })
public class ValidacaoRunnerTest {

}
