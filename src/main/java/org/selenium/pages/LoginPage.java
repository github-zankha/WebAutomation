package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.enums.WaitStrategy;
import org.testng.annotations.Optional;
import utils.ConfigLoader;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //locator od account menu
    //click on account menu

    private final By userName = By.id("username");
    private final By password =By.id("password");
    private final By loginBtn = By.xpath("//button[@name='login']");

    private final By loginerror = By.xpath("//div[@id='content']//li[1]//strong");
    private final By lostPasswordTxt = By.xpath("//a[contains(text(),'Lost your password')]");

    /*public LoginPage login() {
        // Builder Pattern - Method chaining
        return enterUserName(ConfigLoader.getInstance().getUsername()).enerPassword(ConfigLoader.getInstance().getPassword())
                .waitForLoginBtnToDisapper();
    }*/
    public LoginPage enterUserName(String txt){
        sendKey(userName, WaitStrategy.PRESENCE,txt,"User Name");
        return this;
    }
    public LoginPage enerPassword(String txt){
        sendKey(password, WaitStrategy.PRESENCE,txt,"User Name");
        return this;
    }
    public LoginPage clickLoginBtn() {
        // driver.findElement(loginBtn).click();
        // wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        click(loginBtn, WaitStrategy.CLICKABLE, "Login button");
        return this;
    }
    private AccountPage waitForLoginBtnToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginBtn));
        return new AccountPage(driver);
    }
    public LoginPage enterUserNameThrConfig(String txt){
        sendKey(userName, WaitStrategy.PRESENCE,txt,"User Name");
        return this;
    }
    public  AccountPage LoginThrConfig(){
        //method chainng
        System.out.println("LoginThrConfig Called");
        return enterUserName(ConfigLoader.getInstance().getUsername()).enerPassword(ConfigLoader.getInstance().getPassword()).clickLoginBtn()
                .waitForLoginBtnToDisappear();

    }
    public  LoginPage LoginWithParam(String Username, String Password){
        //method chainng

        return enterUserName(Username).enerPassword(Password).clickLoginBtn();

    }
    public String VerifyLoginErrorMsg(){
          return getText(loginerror);
    }
    public String GetTxtLotPassword(){
        System.out.println("Verify lost password text");
        return getText(lostPasswordTxt);
    }
}
