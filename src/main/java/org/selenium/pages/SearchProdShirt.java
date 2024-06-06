package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchProdShirt extends BasePage{

    public SearchProdShirt(WebDriver driver) {
        super(driver);
    }
    private final By  allShirts = By.xpath("//ul[@class='products columns-4']//div//a//h2");

    public void printSearchedShirts(){
        iterateList(allShirts);
    }

}
