package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SrchProductsPage extends BasePage{
    public SrchProductsPage(WebDriver driver) {
        super(driver);
    }

    /*public ProductThumbnail getProductThumbnail() {
        return ProductThumbnail;

    }  */
    //public final By srchPrdPgTxtElm = By.xpath("//h1";
    WebElement srchPrdPgTxtElm = null;
    public WebElement srchPrdtxtElm(){
        srchPrdPgTxtElm = driver.findElement(By.xpath("//h1"));
        highlighElement(srchPrdPgTxtElm);
         return srchPrdPgTxtElm;
    }
    public String prdSrchPgtxt(){
        return srchPrdPgTxtElm.getText();
    }
}

