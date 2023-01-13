package co.com.choucair.certificacion.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PlaceOrderPage extends PageObject {

    public static final Target BTN_PLACE_ORDER = Target.the("purchase").located(By.xpath("//button[contains(text(),'Place Order')]"));
    public static final Target TXT_NAME = Target.the("nombre").located(By.id("name"));
    public static final Target TXT_COUNTRY = Target.the("country").located(By.id("country"));
    public static final Target TXT_CITY = Target.the("city").located(By.id("city"));
    public static final Target TXT_CREDIT_CARD = Target.the("card").located(By.id("card"));
    public static final Target TXT_MONTH = Target.the("month").located(By.id("month"));
    public static final Target TXT_YEAR = Target.the("year").located(By.id("year"));
    public static final Target BTN_PURCHASE = Target.the("purchase").located(By.xpath("//button[@onclick='purchaseOrder()']"));
    public static final Target TXT_PURCHASE_SUCCESS = Target.the("purchase done").located(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"));

}