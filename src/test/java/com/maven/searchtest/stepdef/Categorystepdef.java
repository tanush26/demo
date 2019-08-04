package com.maven.searchtest.stepdef;

import com.maven.searchtest.pageobject.Homepage;
import com.maven.searchtest.pageobject.Resultspage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class Categorystepdef {
    private Homepage homepage = new Homepage();
    Resultspage resultspage = new Resultspage();
    private String arg0;

    @Given("^I am  Homepage$")
    public void iAmHomepage() {
        String actual = homepage.getcurrenturl();
        assertThat("", actual, Matchers.endsWith("co.uk/"));
    }


    @When("^I search for a \"([^\"]*)\"$")
    public void iSearchForA(String arg0) throws Throwable {
       homepage.dosearch("home");
    }

    @And("^I select category filters as \"([^\"]*)\"$")
    public void iSelectCategoryFiltersAs(String arg0) throws Throwable {
        resultspage.getallcategoryfilters("Sofas");
    }

    @And("^I select category price Sofa filters as \"([^\"]*)\"$")
    public void iSelectCategoryPriceSofaFiltersAs(String arg0) throws Throwable {
       resultspage.getallsofafilters("Fabric");

    }

    @And("^I select category colour Sofa filters as \"([^\"]*)\"$")
    public void iSelectCategoryColourSofaFiltersAs(String arg0) throws Throwable {
       resultspage.getallsofafilters("Greys");
    }

    @Then("^I should be able to see the respective product$")
    public void iShouldBeAbleToSeeTheRespectiveProduct() {
        resultspage.getheader();
    }

}
