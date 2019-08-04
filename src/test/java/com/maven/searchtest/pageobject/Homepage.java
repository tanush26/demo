package com.maven.searchtest.pageobject;


import com.maven.searchtest.Driver.driverfactory;
import org.openqa.selenium.By;

public class Homepage extends driverfactory {


    public void dosearch(String item){
        driver.findElement(By.cssSelector("._1Rz0y")).sendKeys(item);
        driver.findElement(By.cssSelector("._1gqeQ")).click();
    }
    public String getcurrenturl(){
        return driver.getCurrentUrl();


    }

    public String getProductHeader(){
        return  driver.findElement(By.cssSelector(".search-title__term")).getText();
    }
}




