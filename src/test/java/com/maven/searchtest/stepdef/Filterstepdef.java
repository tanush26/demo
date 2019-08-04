package com.maven.searchtest.stepdef;

import com.maven.searchtest.pageobject.Resultspage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Filterstepdef {
Resultspage resultspage = new Resultspage();

    @And("^I select a customer price as \"([^\"]*)\"$")
    public void iSelectACustomerPriceAs(String arg0) throws Throwable {
       resultspage.getallpriceranges("£10 - £15");
    }

    @Then("^I should be able to see product with in range of customer priceselection$")
    public void iShouldBeAbleToSeeProductWithInRangeOfCustomerPriceselection() {
resultspage.getheader();
    }

}