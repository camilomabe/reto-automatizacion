package co.com.choucair.certificacion.screenplay.interaction;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.choucair.certificacion.screenplay.ui.PhonePage.*;
import static co.com.choucair.certificacion.screenplay.util.CommonMethod.waitSeconds;
import static co.com.choucair.certificacion.screenplay.util.Constants.WAIT_FOR_TWO;


@AllArgsConstructor
public class AddsProduct implements Interaction {

    private final String name;

    public static Performable toCart(String name) {
        return Tasks.instrumented(AddsProduct.class, name);
    }

    @Override
    @Step("{0} closes product's added alert")
    public <T extends Actor> void performAs(T actor) {
        waitSeconds(WAIT_FOR_TWO);
        actor.attemptsTo(Click.on(lblProductName(name)));
        actor.attemptsTo(Click.on(BTN_ADD_TO_CART));
        actor.attemptsTo(ClosesAlert.alertTo());
        actor.attemptsTo(Click.on(HOME_PRODUCTS));
    }
}
