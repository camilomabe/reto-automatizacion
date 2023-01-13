package co.com.choucair.certificacion.screenplay.interaction;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.choucair.certificacion.screenplay.ui.PhonePage.lblProductName;

@AllArgsConstructor
public class FiltersByCategory implements Interaction {

    private final String category;

    public static Performable selectProduct(String category) {
        return Tasks.instrumented(FiltersByCategory.class, category);
    }

    @Override
    @Step("{0} filters the products by categories")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(lblProductName(category)));
    }
}
