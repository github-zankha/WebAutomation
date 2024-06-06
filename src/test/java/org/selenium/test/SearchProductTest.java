package org.selenium.test;

import org.junit.Assert;
import org.selenium.Reports.ExtentLogger;
import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.*;
import org.testng.annotations.Test;
import utils.Loggers;

public class SearchProductTest extends BaseTest {

    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"}, enabled = true)

    public void searchProduct() throws InterruptedException {
        HomePage homePage = new HomePage(getdr());
        OrdersPage ordersPage = new OrdersPage(getdr());
        // LoginPage loginPage=new LoginPage(getdriver());
        //AccountPage accountPageccountPage=new AccountPage(getdriver());
        SrchProductsPage SrprdPg = new SrchProductsPage(getdr());

        homePage.openURL("");
        homePage.clickAccountMenu().LoginThrConfig().OrdersMenuClick();
        Loggers.log.info("Form OrderTest: Orders Menu Click");
        Loggers.log.debug("Ordertest: Debug level test");
        StorePage strPg= ordersPage.BrowsePriductsBtnClick();
        Assert.assertEquals(ordersPage.getPageURL(), "https://askomdch.com/store/");
        System.out.println("Successfully navigated to Stores page");
        Loggers.log.info("Successfully navigated to Stores page");

        //Product search test in strore page
        String searchProdVal = "Shirt";
        strPg.searchProducts(searchProdVal);
        Loggers.log.info("Navigated to Product Page searching: "+"'"+searchProdVal+"'"+" as a result product");
        String actualPrdSrchTxt= SrprdPg.srchPrdtxtElm().getText();
        Assert.assertEquals(actualPrdSrchTxt,"Search results: “"+searchProdVal+"”" );
        Thread.sleep(2000);
        System.out.println("Navigated page product search: "+searchProdVal);
        Loggers.log.info("Navigated page product search: "+searchProdVal);
        ExtentLogger.info("Navigated page product search: "+actualPrdSrchTxt);

        SearchProdShirt srchShirts= new SearchProdShirt(getdr());
        srchShirts.printSearchedShirts();
        //Search results: shirt -
    }
}
