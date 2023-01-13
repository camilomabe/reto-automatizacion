package co.com.choucair.certificacion.screenplay.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.choucair.certificacion.screenplay.ui.PhonePage.DELETE_PRODUCT;
import static co.com.choucair.certificacion.screenplay.ui.PhonePage.DELETE_PRODUCT_TWO;
import static co.com.choucair.certificacion.screenplay.util.CommonMethod.waitSeconds;


public class RemoveProductFromCart implements Interaction {

    public static Performable toCart() {
        return Tasks.instrumented(RemoveProductFromCart.class);
    }

    @Override
    @Step("{0} removes the products from the cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(DELETE_PRODUCT_TWO));
        waitSeconds(4000);
        actor.attemptsTo(Click.on(DELETE_PRODUCT));
    }
}
