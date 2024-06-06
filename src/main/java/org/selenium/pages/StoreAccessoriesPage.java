package org.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StoreAccessoriesPage extends BasePage{
    public StoreAccessoriesPage(WebDriver driver) {
        super(driver);
    }

    public StoreAccessoriesPage loadAccessoriesPage() {
        load("product-category/accessories");
        return this;
    }
    public Boolean Isloader() {

        return wait.until(ExpectedConditions.urlContains("/aproduct-category/accessories"));
    }

}
