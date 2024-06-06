package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.enums.WaitStrategy;

public class OrdersPage extends BasePage{

    public OrdersPage(WebDriver driver) {
        super(driver);
    }
    private final By BrowseProductsBtn = By.xpath("//a[@class='woocommerce-Button button']");

    public StorePage BrowsePriductsBtnClick() {
        click(BrowseProductsBtn, WaitStrategy.PRESENCE, "AccBrowse Products Button on Orders page");
        return new StorePage(driver);
    }
    public String GetBrwPrdBtnText(){
        return getText(BrowseProductsBtn);
    }

}
