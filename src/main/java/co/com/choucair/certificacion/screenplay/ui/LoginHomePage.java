package co.com.choucair.certificacion.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginHomePage extends PageObject {

    public static final Target LBL_LOG_IN = Target.the("tag login in").located(By.id("login2"));
    public static final Target TXT_USER = Target.the("user name").located(By.id("loginusername"));
    public static final Target TXT_PASSWORD = Target.the("password").located(By.id("loginpassword"));
    public static final Target BTN_LOGIN = Target.the("login").located(By.xpath("//button[contains(text(),'Log in')]"));

}