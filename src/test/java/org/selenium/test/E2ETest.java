package org.selenium.test;


import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Loggers;


public class E2ETest extends BaseTest {
    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
   @Test
      public void e2eSingleItemPurchase() throws InterruptedException {
       HomePage homePage = new HomePage(getdr());
       StorePage strPage = new StorePage(getdr());
       homePage.openURL("");
       homePage.clickAccountMenu().LoginThrConfig();
       Assert.assertEquals(homePage.getPageTitle(), "Account – AskOmDch");

       //Click
        homePage.loadHomePage();
        Assert.assertEquals(homePage.getPageTitle(), "AskOmDch – Become a Selenium automation expert!");
        homePage.clickShopeNowBtn(); //clicking shopenowbutton navigaes store page

        //verify title of store page
        Assert.assertEquals(homePage.getPageTitle(), " Products – AskOmDch");
        //click on 'Basic Blue Jeans' to buy under strore page
        strPage.selectBasicBlueJeans();
        //verify 'View Cart' is displayed under- Basic Blue Jeans Prod ID 1205
        Assert.assertEquals(strPage.viewCartTxtProdID("1205"),"View cart");
        Loggers.log.info("Basic Blue Jeans - View Cart link virified");

    }
}
