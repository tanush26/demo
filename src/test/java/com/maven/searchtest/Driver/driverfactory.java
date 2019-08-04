package com.maven.searchtest.Driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class driverfactory {


        public static WebDriver driver;

        public  void OpenBrowser() {
            switch ("browser") {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.get("https://www.argos.co.uk/");
                    break;
                default:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.get("https://www.argos.co.uk/");
                    break;

                   
            }
        }
        public  void Maximize(){
            driver.manage().window().maximize();
        }

        public  void ImplicitWait(){
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

       /* public  void del(){
            driver.manage().deleteAllCookies();
        }*/
        public static void CloseBrowser(){
            driver.quit();
        }

    }


