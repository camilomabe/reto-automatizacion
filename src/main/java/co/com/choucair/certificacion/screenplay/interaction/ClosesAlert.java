package co.com.choucair.certificacion.screenplay.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static co.com.choucair.certificacion.screenplay.util.CommonMethod.waitSeconds;

public class ClosesAlert implements Interaction {

    public static Performable alertTo() {
        return Tasks.instrumented(ClosesAlert.class);
    }

    @Override
    @Step("{0} closes product's added alert")
    public <T extends Actor> void performAs(T actor) {
        waitSeconds(2000);
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.switchTo().alert().accept();
        waitSeconds(3000);
    }
}
