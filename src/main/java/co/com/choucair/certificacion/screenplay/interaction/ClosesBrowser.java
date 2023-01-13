package co.com.choucair.certificacion.screenplay.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static co.com.choucair.certificacion.screenplay.util.CommonMethod.waitSeconds;

public class ClosesBrowser implements Interaction {
    public static Performable quit() {
        return Tasks.instrumented(ClosesBrowser.class);
    }

    @Override
    @Step("{0} closes the browser")
    public <T extends Actor> void performAs(T actor) {
        waitSeconds(6000);
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.quit();
    }
}
