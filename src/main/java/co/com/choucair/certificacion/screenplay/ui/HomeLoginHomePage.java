package co.com.choucair.certificacion.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeLoginHomePage extends PageObject {

    public static Target lblUserLogged(String user) {
        return Target.the("label user logged").located(By.xpath("//a[contains(text(),'Welcome " + user + "')]"));
    }

}