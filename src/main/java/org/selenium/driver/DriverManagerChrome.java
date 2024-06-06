package org.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerChrome implements DriverManager_OC{
    /*
    Constructor to set the default values.
    public DriverManagerChrome(){


    }*/
    @Override
    public WebDriver createDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
