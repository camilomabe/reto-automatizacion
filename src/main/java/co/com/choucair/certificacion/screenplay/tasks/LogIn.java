package co.com.choucair.certificacion.screenplay.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Step;

import java.time.Duration;

import static co.com.choucair.certificacion.screenplay.ui.LoginHomePage.*;
import static co.com.choucair.certificacion.screenplay.ui.HomeLoginHomePage.lblUserLogged;
import static co.com.choucair.certificacion.screenplay.util.SessionVariables.USER;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@AllArgsConstructor
public class LogIn implements Task {

    private final String user;
    private final String pass;

    public static Performable forLoginIn(String user, String pass) {
        return Tasks.instrumented(LogIn.class, user, pass);
    }

    @Override
    @Step("{0} is going to log in with a user")
    public <T extends Actor> void performAs(T actor) {
        actor.remember(USER.toString(), user);
        actor.attemptsTo(Click.on(LBL_LOG_IN));
        actor.attemptsTo(Enter.theValue(user).into(TXT_USER));
        actor.attemptsTo(Enter.theValue(pass).into(TXT_PASSWORD));
        actor.attemptsTo(Click.on(BTN_LOGIN));
        actor.attemptsTo(Wait.until(the(lblUserLogged(user)), isPresent()).forNoMoreThan(Duration.ofMillis(5000)));
    }
}
