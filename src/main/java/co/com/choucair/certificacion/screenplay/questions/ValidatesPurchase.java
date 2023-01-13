package co.com.choucair.certificacion.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static co.com.choucair.certificacion.screenplay.ui.PlaceOrderPage.TXT_PURCHASE_SUCCESS;

public class ValidatesPurchase implements Question<String> {

    public static Question<String> done() {
        return new ValidatesPurchase();
    }

    @Override
    @Step("{0} confirms the purchase made")
    public String answeredBy(Actor actor) {
        return TXT_PURCHASE_SUCCESS.resolveFor(actor).getText();
    }
}
