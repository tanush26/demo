package com.maven.searchtest;


import com.maven.searchtest.Driver.driverfactory;
import cucumber.api.java.Before;

public class Hooks {
private driverfactory driverfactorys = new driverfactory();
@Before
public void setup(){
    driverfactorys.OpenBrowser();
    driverfactorys.Maximize();
    driverfactorys. ImplicitWait();
   // driverfactorys.del();
}
//@After
//public void quit(){
//    driverfactory.CloseBrowser();
//}
}