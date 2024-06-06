package org.selenium.test;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.HomePage;
import org.selenium.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"})
    public void LoginThrHomePage() {
        HomePage homePage = new HomePage(getdr());
        // LoginPage loginPage=new LoginPage(getdriver());
        //AccountPage accountPageccountPage=new AccountPage(getdriver());

        homePage.openURL("");
        homePage.clickAccountMenu().LoginThrConfig();
        //title is match or not
        Assert.assertEquals(homePage.getPageTitle(), "Account – AskOmDch");
        // loginPage.LoginThrConfig();


    }

    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"})
    public void InvalidLogin() {
        HomePage homePage = new HomePage(getdr());
        LoginPage loginPage = new LoginPage(getdr());
        //AccountPage accountPageccountPage=new AccountPage(getdriver());

        homePage.openURL("");
        homePage.clickAccountMenu().LoginWithParam("XYZ", "XYZ");
        Assert.assertEquals(loginPage.VerifyLoginErrorMsg(), "Error");


    }

    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"})
    public void VerifyLostPasswordTxt() {
        HomePage homePage = new HomePage(getdr());
        LoginPage loginPage = new LoginPage(getdr());
        //AccountPage accountPageccountPage=new AccountPage(getdriver());

        homePage.openURL("");
        homePage.clickAccountMenu().LoginWithParam("XYZ", "XYZ");
        Assert.assertEquals(loginPage.GetTxtLotPassword(), "Lost your password?");


    }

}
