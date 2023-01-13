package co.com.choucair.certificacion.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static co.com.choucair.certificacion.screenplay.ui.HomeLoginHomePage.lblUserLogged;
import static co.com.choucair.certificacion.screenplay.util.SessionVariables.USER;

public class ValidatesUser implements Question<String> {

    public static Question<String> displayed() {
        return new ValidatesUser();
    }

    @Override
    @Step("{0} searches user logged name")
    public String answeredBy(Actor actor) {
        return lblUserLogged(actor.recall(USER.toString())).resolveFor(actor).getText();
    }
}
