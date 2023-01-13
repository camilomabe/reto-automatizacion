package co.com.choucair.certificacion.screenplay.interaction;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static co.com.choucair.certificacion.screenplay.util.CommonMethod.cleanValue;
import static co.com.choucair.certificacion.screenplay.util.SessionVariables.TOTAL_PRICE;


@AllArgsConstructor
public class CalculatesTotal implements Interaction {

    private final String one;
    private final String two;

    public static Performable value(String one, String two) {
        return Tasks.instrumented(CalculatesTotal.class, one, two);
    }

    @Override
    @Step("{0} calculates product's value")
    public <T extends Actor> void performAs(T actor) {
        int price = cleanValue(one, two);
        String priceProducts = Integer.toString(price);
        actor.remember(TOTAL_PRICE.toString(), priceProducts);
    }
}
