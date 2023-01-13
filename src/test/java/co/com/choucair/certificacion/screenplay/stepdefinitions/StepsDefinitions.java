package co.com.choucair.certificacion.screenplay.stepdefinitions;


import co.com.choucair.certificacion.screenplay.interaction.ClosesBrowser;
import co.com.choucair.certificacion.screenplay.interaction.RemoveProductFromCart;
import co.com.choucair.certificacion.screenplay.questions.ValidatesFullPrice;
import co.com.choucair.certificacion.screenplay.questions.ValidatesPurchase;
import co.com.choucair.certificacion.screenplay.questions.ValidatesUser;
import co.com.choucair.certificacion.screenplay.tasks.AddsTwoProducts;
import co.com.choucair.certificacion.screenplay.tasks.LogIn;
import co.com.choucair.certificacion.screenplay.tasks.PlacesOrder;
import co.com.choucair.certificacion.screenplay.util.NavigateTo;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.CoreMatchers;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepsDefinitions {

    @Before
    public void startsPage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) opens the browser in the home page$")
    public void opens_the_url_on_the_website(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(NavigateTo.theWebSideHome());
    }

    @When("^he writes his credentials, (.*) and (.*)$")
    public void writes_his_credentials(String user, String pass) {
        theActorInTheSpotlight().attemptsTo(LogIn.forLoginIn(user, pass));
    }

    @Given("^he should see his (.*) when logging in$")
    public void should_see_his_username_when_logging_in(String user) {
        theActorInTheSpotlight().should(seeThat(ValidatesUser.displayed(), CoreMatchers.equalTo("Welcome " + user)));
    }

    @And("^he adds two products to the cart$")
    public void adds_two_products_to_the_cart(Map<String, String> productsInfo) {
        theActorInTheSpotlight().attemptsTo(AddsTwoProducts.toCart(productsInfo));
    }

    @Then("^he should see the total (.*) of the products$")
    public void should_see_the_total_value_of_the_products(String price) {
        theActorInTheSpotlight().should(seeThat(ValidatesFullPrice.ofProducts(), CoreMatchers.equalTo(price)));
    }

    @And("^he removes the products from the cart$")
    public void removes_the_products_from_the_cart() {
        theActorInTheSpotlight().attemptsTo(RemoveProductFromCart.toCart());
    }

    @And("^he fills in the form to place an order$")
    public void fills_in_the_form_to_place_an_order(Map<String, String> infoOrder) {
        theActorInTheSpotlight().attemptsTo(PlacesOrder.form(infoOrder));
    }

    @Then("^he should see the confirmation message (.*)$")
    public void should_see_the_confirmation_message(String message) {
        theActorInTheSpotlight().should(seeThat(ValidatesPurchase.done(), CoreMatchers.equalTo(message)));
    }

    @And("^he closes the browser$")
    public void closes_the_browser() {
        theActorInTheSpotlight().attemptsTo(ClosesBrowser.quit());
    }
}
