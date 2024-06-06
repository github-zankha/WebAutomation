package org.selenium.test;

import org.junit.Assert;
import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.HomePage;
import org.selenium.pages.OrdersPage;
import org.selenium.pages.StorePage;
import org.testng.annotations.Test;
import utils.Loggers;

public class OrdersTest extends BaseTest {
    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"},enabled = false)
    public void NavigateOrdersPage(){
        HomePage homePage = new HomePage(getdr());
        OrdersPage ordersPage = new OrdersPage(getdr());
        // LoginPage loginPage=new LoginPage(getdriver());
        //AccountPage accountPageccountPage=new AccountPage(getdriver());

        homePage.openURL("");
        homePage.clickAccountMenu().LoginThrConfig().OrdersMenuClick();
        System.out.println("Successfully navigated to Orders page");
        Assert.assertEquals(ordersPage.GetBrwPrdBtnText(),"Browse products");

    }

    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"})
    public void BrowseProductsClick(){
        HomePage homePage = new HomePage(getdr());
        OrdersPage ordersPage = new OrdersPage(getdr());
        // LoginPage loginPage=new LoginPage(getdriver());
        //AccountPage accountPageccountPage=new AccountPage(getdriver());

        homePage.openURL("");
        homePage.clickAccountMenu().LoginThrConfig().OrdersMenuClick();
        Loggers.log.info("Form OrderTest: Orders Menu Click");
        Loggers.log.debug("Ordertest: Debug level test");
        ordersPage.BrowsePriductsBtnClick();
        Assert.assertEquals(ordersPage.getPageURL(),"https://askomdch.com/store/");
        System.out.println("Successfully navigated to Stores page");
    }

    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"},enabled = false)
    public void VerifyStorePage(){

        StorePage strPg = new StorePage(getdr());
        Assert.assertTrue(getdr().getCurrentUrl(),strPg.Isloader());
        System.out.println(getdr().getClass().getName()+" Assert True executed");
    }
}
