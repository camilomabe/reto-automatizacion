package co.com.choucair.certificacion.screenplay.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static co.com.choucair.certificacion.screenplay.ui.PlaceOrderPage.*;
import static co.com.choucair.certificacion.screenplay.util.Constants.*;

@AllArgsConstructor
public class PlacesOrder implements Task {

    private final Map<String, String> infoOrder;

    public static Performable form(Map<String, String> infoOrder) {
        return Tasks.instrumented(PlacesOrder.class, infoOrder);
    }

    @Override
    @Step("{0} fills in the form to place an order")
    public <T extends Actor> void performAs(T actor) {

        String name = infoOrder.get(NAME);
        String country = infoOrder.get(COUNTRY);
        String city = infoOrder.get(CITY);
        String creditCard = infoOrder.get(CREDIT_CARD);
        String month = infoOrder.get(MONTH);
        String year = infoOrder.get(YEAR);

        actor.attemptsTo(Click.on(BTN_PLACE_ORDER));
        actor.attemptsTo(Enter.theValue(name).into(TXT_NAME));
        actor.attemptsTo(Enter.theValue(country).into(TXT_COUNTRY));
        actor.attemptsTo(Enter.theValue(city).into(TXT_CITY));
        actor.attemptsTo(Enter.theValue(creditCard).into(TXT_CREDIT_CARD));
        actor.attemptsTo(Enter.theValue(month).into(TXT_MONTH));
        actor.attemptsTo(Enter.theValue(year).into(TXT_YEAR));
        actor.attemptsTo(Click.on(BTN_PURCHASE));
    }
}
