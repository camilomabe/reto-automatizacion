package co.com.choucair.certificacion.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static co.com.choucair.certificacion.screenplay.ui.PhonePage.AMOUNT_TO_BE_PAID;
import static co.com.choucair.certificacion.screenplay.util.CommonMethod.waitSeconds;

public class ValidatesFullPrice implements Question<String> {

    public static Question<String> ofProducts() {
        return new ValidatesFullPrice();
    }

    @Override
    @Step("{0} full product price")
    public String answeredBy(Actor actor) {
        waitSeconds(6000);
        return AMOUNT_TO_BE_PAID.resolveFor(actor).getText();
    }
}
