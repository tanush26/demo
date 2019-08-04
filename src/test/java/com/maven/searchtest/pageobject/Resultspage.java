package com.maven.searchtest.pageobject;

import com.maven.searchtest.Driver.Helpers;
import com.maven.searchtest.Driver.driverfactory;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Resultspage extends driverfactory {


    public void priceselecttest() {

        getallpriceranges("£10 - £15");
        List<Double> actuallist = selectedpricerange();
        assertThat(actuallist, Matchers.everyItem(greaterThanOrEqualTo(10.0)));
        assertThat(actuallist, Matchers.everyItem(lessThanOrEqualTo(15.0)));

    }

    public static void getallpriceranges(String customerselectedprice) {

        List<WebElement> pricefilters = driver.findElements(By.cssSelector(".checkbox__label"));
        for (WebElement pricefilter : pricefilters) {
            if (pricefilter.getText().equalsIgnoreCase(customerselectedprice)) {
                pricefilter.click();
                break;

            }
        }
    }


    public List<Double> selectedpricerange() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Double> Customerselectedrange = new ArrayList<>();
        List<WebElement> priceranges = driver.findElements(By.cssSelector(" .ac-product-price__amount"));
        for (WebElement pricerange : priceranges) {
            String priceinstring = pricerange.getText().replace("£", "");
            double priceindouble = Double.parseDouble(priceinstring);
            Customerselectedrange.add(priceindouble);
        }
        return Customerselectedrange;
    }
    public void categorytest() {
        getallcategoryfilters("Sofas");
        getallsofafilters("2 seater");    //sofa type
        getallsofafilters("Fabric");      //sofa materialtype
        getallsofafilters("Greys");       //sofa colourgroup
        getallsofafilters("£250 - £500"); // sofa price
        // getallsofafilters("Kayla");     //sofa collection
        //getallsofafilters("4or more");// sofa ratings
        //String expected = selectrandomproduct();

    }
    public void getallcategoryfilters(String selectedcategory) {//Argos/home/category
        List<WebElement> category = driver.findElements(By.cssSelector(".ac-facet__filters--category .ac-facet__label--category "));
        System.out.println(category.size());
        for (WebElement categorys : category) {
            if (categorys.getText().equalsIgnoreCase(selectedcategory)) {
                categorys.click();
                break;


            }

        }
    }

    public void getallsofafilters(String selectedsofafilter) { //Argos/home/category/sofas/filterby
        List<WebElement> sofafilter = driver.findElements(By.cssSelector(".ac-drawer__content .ac-facet__label"));
        System.out.println(sofafilter.size());
        for (WebElement sofafilters : sofafilter) {
            if (sofafilters.getText().equalsIgnoreCase(selectedsofafilter)) {
                sofafilters.click();
                break;
            }
        }
    }
    public String selectAnyProducts() {
        List<WebElement> productNamesWebelements = driver.findElements(By.cssSelector(""));
        int numberOfProducts = productNamesWebelements.size();
        int randomnumber = new Helpers().randomNumberGenerator(numberOfProducts);
        String selectedProduct=productNamesWebelements.get(randomnumber).getText();
        productNamesWebelements.get(randomnumber).click();
        return selectedProduct;
    }



    public String getheader() {
        return driver.findElement(By.cssSelector(".search-title")).getText();
    }

}

