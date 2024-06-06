package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.Reports.ExtentLogger;
import org.selenium.enums.WaitStrategy;
import utils.ConfigLoader;
import utils.Loggers;

import static org.selenium.constants.FramworkConstants.ICON_Navigate_Right;

public class HomePage extends BasePage {
    private final By accountMenu = By.xpath("//a[@class='menu-link'][normalize-space()='Account']");
    private final By storeMenu = By.xpath("//li[@id='menu-item-1227']//a[@class='menu-link'][normalize-space()='Store']");
    private final By homeMenu = By.xpath("//li[@id='menu-item-1226']//a[@class='menu-link'][normalize-space()='Home']");
    private final By shopeNowBtn = By.xpath("(//a[contains(text(),'Shop Now')])[1]");
    public HomePage(WebDriver driver) {
        super(driver);
        //myHeader = new MyHeader(driver);
        //productThumbnail = new ProductThumbnail(driver);

    }
    public HomePage loadHomePage(){
        load("");
        wait.until(ExpectedConditions.titleContains("AskOmDch"));
        return this;
    }


    public LoginPage clickAccountMenu(){
        click(accountMenu, WaitStrategy.PRESENCE,"Account Menu");
        ExtentLogger.info("Account Menu Click");
        //Loggers.log.info("HomePage: Account Menu Click");
        return new LoginPage(driver);
    }
    public void openURL(String endPoint) {
        load(endPoint);
        ExtentLogger.info(ICON_Navigate_Right + "  Navigating to : <b>" + ConfigLoader.getInstance().getBaseUrl()
                + endPoint + "</b>");
        //return new LoginPage(driver);
    }
    public StorePage clickStoreMenu(){
        click(storeMenu, WaitStrategy.PRESENCE,"Store Menu");
        ExtentLogger.info("Store Menu Click");
        //Loggers.log.info("HomePage: Account Menu Click");
        return new StorePage(driver);
    }

    public void clickHomeMenu(){
        click(homeMenu, WaitStrategy.PRESENCE,"Home Menu");
    }
    public StorePage clickShopeNowBtn(){
        click(shopeNowBtn, WaitStrategy.PRESENCE,"Home Menu");
        return new StorePage(driver);
    }
}
