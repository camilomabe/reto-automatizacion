package co.com.choucair.certificacion.screenplay.tasks;

import co.com.choucair.certificacion.screenplay.interaction.AddsProduct;
import co.com.choucair.certificacion.screenplay.interaction.CalculatesTotal;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import java.time.Duration;
import java.util.Map;

import static co.com.choucair.certificacion.screenplay.ui.PhonePage.*;
import static co.com.choucair.certificacion.screenplay.util.Constants.*;
import static co.com.choucair.certificacion.screenplay.util.SessionVariables.*;

@AllArgsConstructor
public class AddsTwoProducts implements Task {

    private final Map<String, String> productsInfo;

    public static Performable toCart(Map<String, String> productsInfo) {
        return Tasks.instrumented(AddsTwoProducts.class, productsInfo);
    }

    @Override
    @Step("{0} creates new business unit")
    public <T extends Actor> void performAs(T actor) {

        String productOne = lblProductName(productsInfo.get(NAME_ONE)).resolveFor(actor).getText();
        String productTwo = lblProductName(productsInfo.get(NAME_TWO)).resolveFor(actor).getText();
        String priceOne = lblProductPrice(productsInfo.get(NAME_ONE)).resolveFor(actor).getText();
        String priceTwo = lblProductPrice(productsInfo.get(NAME_TWO)).resolveFor(actor).getText();

        actor.attemptsTo(CalculatesTotal.value(priceTwo, priceOne));

        actor.remember(PRODUCT_NAME_ONE.toString(), productsInfo.get(NAME_ONE));
        actor.remember(PRODUCT_NAME_TWO.toString(), productsInfo.get(NAME_TWO));
        actor.remember(PRODUCT_PRICE_ONE.toString(), productsInfo.get(PRICE_ONE));
        actor.remember(PRODUCT_PRICE_TWO.toString(), productsInfo.get(PRICE_TWO));

        actor.attemptsTo(Click.on(FILTER_PHONES));
        actor.attemptsTo(AddsProduct.toCart(productOne));
        actor.attemptsTo(Click.on(FILTER_PHONES));
        actor.attemptsTo(AddsProduct.toCart(productTwo));

        actor.attemptsTo(Click.on(CART.waitingForNoMoreThan(Duration.ofSeconds(5))));


    }
}
