package org.selenium.test;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ScreenShotUtils;

public class PriceRangeAddToCartTest extends BaseTest {

    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"}, enabled = true)
    public void priceRangeAddTocart() throws InterruptedException {
        HomePage HomePg = new HomePage(getdr());

        HomePg.openURL("");
        StorePage strPg = HomePg.clickStoreMenu();

        Thread.sleep(2000);
        System.out.println("Done sleeping, no interrupt.");


        strPg.slidPriceRange();
        ScreenShotUtils.getBase64Image();
        Thread.sleep(5000);
        Assert.assertEquals(strPg.getAfterFilterURL(),"https://askomdch.com/store/?min_price=10&max_price=120");
    }
}
