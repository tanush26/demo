package com.maven.searchtest.stepdef;
import com.maven.searchtest.pageobject.Homepage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Searchstepdef {
    private Homepage homepage = new Homepage();
    @Given("^I am Homepage$")
    public void i_am_Homepage() throws Throwable {
        String actual = homepage.getcurrenturl();
        assertThat("", actual, Matchers.endsWith("co.uk/"));
    }
    @When("^I search for a product \"([^\"]*)\"$")
    public void i_search_for_a_product(String item) throws Throwable {
        homepage.dosearch(item);
    }
    @And("^I search for a ([^\"]*)$")
    public void iSearchForA(String searchitem) {
        homepage.dosearch(searchitem);
    }


    @Then("^I should be able to see respective product$")
    public void i_should_be_able_to_see_respective_product() throws Throwable {
        homepage.getProductHeader();
    }

}
