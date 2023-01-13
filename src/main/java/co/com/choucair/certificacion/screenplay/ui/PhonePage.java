package co.com.choucair.certificacion.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PhonePage extends PageObject {

    public static final Target HOME_PRODUCTS = Target.the("product store").located(By.xpath("//a[@id='nava']"));
    public static final Target FILTER_PHONES = Target.the("filtrar telefonos").located(By.xpath("//a[contains(text(),'Phones')]"));
    public static final Target CART = Target.the("carrito").located(By.id("cartur"));
    public static final Target BTN_ADD_TO_CART = Target.the("aggregar al carrito").located(By.xpath("//a[contains(text(),'Add to cart')]"));
    public static final Target DELETE_PRODUCT = Target.the("elimina el producto uno").located(By.xpath("//a[contains(text(),'Delete')]"));
    public static final Target DELETE_PRODUCT_TWO = Target.the("elimina el producto dos").located(By.xpath("(//a[contains(text(),'Delete')])[2]"));
    public static final Target AMOUNT_TO_BE_PAID = Target.the("valor total").located(By.xpath("//h3[@id='totalp']"));

    public static Target lblProductName(String productName) {
        return Target.the("producto").located(By.xpath("//a[contains(text(),'" + productName + "')]"));
    }

    public static Target lblProductPrice(String productPrice) {
        return Target.the("precio").located(By.xpath("//a[contains(text(),'" + productPrice + "')]/following::h5[1]"));
    }


}