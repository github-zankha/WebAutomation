package org.selenium.test;


import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.StorePage;
import org.testng.annotations.Test;

public class StoreTest extends BaseTest {
    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"})
    public void VerifyStorePage() throws InterruptedException {
        StorePage strPg = new StorePage(getdr());
        Assert.assertTrue(getdr().getCurrentUrl(),strPg.Isloader());
        System.out.println(getdr().getClass().getName()+" Assert True executed");

        Thread.sleep(2000);
        strPg.slidPriceRange();
        Thread.sleep(2000);
    }
}
//addtocart
//change quant
//scroll down and take picture