package behavior.petstore;

import com.google.inject.Inject;
import contract.ActionBot;
import contract.po.PageRouter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobject.petstore.*;

import java.util.Map;

public class PetStoreSteps {

    private PageRouter router;
    private final ActionBot actionBot;
//    private userFactory userFactory;

    @Inject
    public PetStoreSteps(PageRouter router,ActionBot actionBot) {
        this.router = router;
        this.actionBot = actionBot;
    }


    @Given("a logged in pet-store user with: {string} | {string}")
    public void a_logged_in_pet_store_user_with(String userName, String password) throws Exception {

        router.goTo(PetStoreSignInPage.class).signIn(userName, password);

//        userFactory.getDefaultUser();
//        userFactory.getBlockedUser();
//        userFactory.getNotExistUser();
//
//        userFactory.setName("Clack").setAge(30).build();
    }

    @Given("search for {string} in the query box")
    public void search_for_in_the_query_box(String queryText) {
        router.build(PetStoreHomePage.class).search(queryText);
    }

    @Given("add a male bulldog to cart")
    public void add_a_male_bulldog_to_cart() {
        router.build(PetSearchListPage.class)
                .selectPetByIndex(1)
                .addShoppingCartByPetDescription("Male Adult Bulldog");
    }

    @When("submit order with this information:")
    public void submit_order_with_this_information(Map<String, String> map) throws Exception {
        router.build(PetShoppingCart.class)
                .proceedToCheckout()
                .fillShippingInformation(map)
                .submitShippingInformation()
                .confirmOrder();
    }

    @Then("check the order amount is {double}")
    public void check_the_order_amount_is(Double orderAmount) throws Exception {

        PetOrderReviewPage page = router.build(PetOrderReviewPage.class);
        Assert.assertEquals("wrong", String.format("Total: $%.2f",orderAmount),page.getTotalAmountText());

    }
}
