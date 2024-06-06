package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.Reports.ExtentLogger;
import org.selenium.enums.WaitStrategy;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    private final By ordersMenu = By.xpath("//a[contains(text(),'Orders')]");
    public OrdersPage OrdersMenuClick(){
        click(ordersMenu, WaitStrategy.PRESENCE,"Orders Menu in Account page");
        ExtentLogger.info("Orders menu link clicked");
        return new OrdersPage(driver);
    }
}
