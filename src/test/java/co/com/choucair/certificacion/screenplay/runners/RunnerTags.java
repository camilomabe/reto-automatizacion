package co.com.choucair.certificacion.screenplay.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"co/com/choucair/certificacion/screenplay/stepdefinitions"},
        tags = "@Regression")
public class RunnerTags {}

