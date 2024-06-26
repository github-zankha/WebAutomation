package org.selenium.test;


import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
import org.testng.annotations.Test;
import utils.Loggers;

import static org.testng.Assert.assertEquals;


public class E2ETest extends BaseTest {
    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
   @Test
      public void e2eSingleItemPurchase() throws InterruptedException {
       HomePage homePage = new HomePage(getdr());
       StorePage strPage = new StorePage(getdr());
       homePage.openURL("");
       homePage.clickAccountMenu().LoginThrConfig();
       assertEquals(homePage.getPageTitle(), "Account – AskOmDch");

       //Click
        homePage.loadHomePage();
        assertEquals(homePage.getPageTitle(), "AskOmDch – Become a Selenium automation expert!");
        homePage.clickShopeNowBtn(); //clicking shopenowbutton navigaes store page

        //verify title of store page
        assertEquals(homePage.getPageTitle(), "Products – AskOmDch");
        //click on 'Basic Blue Jeans' to buy under strore page
        strPage.selectBasicBlueJeans();
        //verify 'View Cart' is displayed under- Basic Blue Jeans Prod ID 1205

     assertEquals(strPage.viewCartTxtProdID(),"View cart");
        Loggers.log.info("Basic Blue Jeans - View Cart link virified");

    }
}
