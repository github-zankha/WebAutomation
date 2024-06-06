package org.selenium.pages;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.Reports.ExtentLogger;
import org.selenium.constants.FramworkConstants;
import org.selenium.driver.DriverManager;
import org.selenium.enums.WaitStrategy;
import org.selenium.factories.ExplicityWaitFactory;
import org.selenium.listeners.ListenerClass;
import utils.ConfigLoader;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;


public class BasePage {
    /* Class level -> Not Thread safe /
    /*
     * No need to use ThreadLocal, because when we are creating the Object of Page,
     * those objects are local to test methods.
     */
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final By saleElements=By.xpath("//div[@class='astra-shop-summary-wrap']/preceding-sibling::div/span");
    private final By amountsInSale= By.xpath("//div[@class='astra-shop-summary-wrap']/child::span//ins//bdi");
    private final By withoutSaleElements=By.xpath("//div[@class='astra-shop-summary-wrap']/child::span/span/bdi");
    private final By withoutSaleProductsPrice=By.xpath("//div[@class='astra-shop-summary-wrap']/child::span/span/bdi");
    private final By productNameInSaleItems = By.xpath("//div[@class='astra-shop-summary-wrap']/child::span//ins//bdi//ancestor::li/div[2]/a/h2");
    private final By productNameWithoutSaleItems = By.xpath("//div[@class='astra-shop-summary-wrap']/child::span/span/bdi//ancestor::li/div[2]/a/h2");


    //DOMConfigurator

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(FramworkConstants.getExplicitWait()));
    }


    protected void click(By by, WaitStrategy waitStrategy, String elemName) {
        ExplicityWaitFactory.performExplicitWait(waitStrategy, by).click();


    }

    protected void sendKey(By by, WaitStrategy waitStrategy, String value, String elemName) {

        ExplicityWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
    }

    protected void clear(By by, WaitStrategy waitStrategy, String elemName) {

        ExplicityWaitFactory.performExplicitWait(waitStrategy, by).clear();
    }

    protected void clearAndSendKeys(By by, String value, WaitStrategy waitStrategy, String ElemName) {
        WebElement element = ExplicityWaitFactory.performExplicitWait(waitStrategy, by);
        element.clear();
        element.sendKeys(value);
    }

    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public void load(String endPoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint+"/");
        /*ExtentLogger.info(ICON_Navigate_Right + "  Navigating to : <b>" + ConfigLoader.getInstance().getBaseUrl()
                + endPoint + "</b>");*/
    }

    public String getText(By by) {
        return DriverManager.getDriver().findElement(by).getText();
    }

    public String getPageURL() {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitWait()))
                .until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return driver.getCurrentUrl();

    }

    public void selectFromList(By by, String value, WaitStrategy waitStrategy, String ElemName) {
        ExplicityWaitFactory.performExplicitWait(waitStrategy, by);
        Select Element = new Select(driver.findElement(by));
        Element.selectByValue(value);

    }

    public void highlighElement(WebElement elem) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", elem);
    }
    public void highlighElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(by));
    }

    public void handleActionSlider(By by) {

        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //try 1// action.dragAndDropBy(driver.findElement(by), 30, 0).release().build().perform();

        //try 2// action.clickAndHold().moveByOffset(40,0).build().perform();
        //action.moveToElement(driver.findElement(by)).click().dragAndDropBy(driver.findElement(by),40,0).build().perform();

        js.executeScript("arguments[0].setAttribute('style', 'left: 78.5714%;')",driver.findElement(by));
    }

    public void pageScroll(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));

    }

    public void setAttribute(By by, String attName, String attValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                driver.findElement(by), attName, attValue);
    }

    public void refreshPage(WebDriver driver){
        driver.navigate().refresh();
    }
    public boolean valideText(By by, String expectedText){
        String observedText = driver.findElement(by).getText();
        if (observedText.equals(expectedText)) {
            return true;
        }
       return false;

    }
    public void iterateList(By by){
        List<WebElement> listeditems =    driver.findElements(by);
        for(int i=0;i<listeditems.size();i++){
            System.out.println("List item: "+i+" "+listeditems.get(i).getText());
        }

    }


    public void captureAmountThrPagination(){
        List<String> amountsList = new ArrayList<>();
        List<WebElement> saleElements1=driver.findElements(saleElements);

        if(saleElements1.size()!=0){
            List<WebElement> amountsInSale1= driver.findElements(amountsInSale);
            for(WebElement amount: amountsInSale1)
                amountsList.add(amount.getText()+" on sale item");
        }
        List<WebElement> withoutSaleElements1=driver.findElements(withoutSaleElements);
        for(WebElement amount: withoutSaleElements1)
            amountsList.add(amount.getText());


        try{
            WebElement nextBtn=driver.findElement(By.xpath("//a[@class='next page-numbers']"));
            while(nextBtn.isDisplayed()){
                nextBtn.click();
                if(saleElements1.size()!=0){
                    List<WebElement> amountsInSale1= driver.findElements(amountsInSale);
                    for(WebElement amount: amountsInSale1)
                        amountsList.add(amount.getText()+" on sale item");
                }
                List<WebElement> withoutSaleProductsPrice1=driver.findElements(withoutSaleProductsPrice);
                for(WebElement amount: withoutSaleProductsPrice1)
                    amountsList.add(amount.getText());
            }}
        catch (Exception e){
            e.printStackTrace();
            System.out.println("next button is not exist");
        }

        for(String amountFound: amountsList)
            System.out.println("amountFound : "+amountFound);
        System.out.println("product count : "+amountsList.size());

        //String count=Integer.toString(amountsList.size());
        //Assert.assertTrue(driver.findElement(By.className("woocommerce-result-count")).getText().contains(count));

    }
    public void captureAmountProductTitleThrPagination(){
        Map<String,String> productNameAndAmount= new HashMap<>();

        ////////////////////////////////////////////////////////
        try {
            List<WebElement> saleElements1 = driver.findElements(saleElements);

            if (saleElements1.size() != 0) {

                List<WebElement> amountsInSale1 = driver.findElements(amountsInSale);
                List<WebElement> productNameInSaleItems1 = driver.findElements(productNameInSaleItems);
                for (int i = 0; i < productNameInSaleItems1.size(); i++) {
                    productNameAndAmount.put(productNameInSaleItems1.get(i).getText(), amountsInSale1.get(i).getText() + " on sale item");

                }
            }
        }catch (Exception e){
            System.out.println("No item in sale on this page");

        }
        ////////////////////////////////////////////////////////
        try {

            List<WebElement> withoutSaleProductsPrice1 = driver.findElements(withoutSaleProductsPrice);
            if (withoutSaleProductsPrice1.size() != 0) {
                List<WebElement> productNameWithoutSaleItems1 = driver.findElements(productNameWithoutSaleItems);
                for (int i = 0; i < withoutSaleProductsPrice1.size(); i++) {
                    productNameAndAmount.put(productNameWithoutSaleItems1.get(i).getText(), withoutSaleProductsPrice1.get(i).getText());

                }
            }
        }catch (Exception e){
            System.out.println("No item without sale on this page");

        }

////////////////////////////////////////////////////////
        try{
            WebElement nextBtn=driver.findElement(By.xpath("//a[@class='next page-numbers']"));
            while(nextBtn.isDisplayed()) {
                nextBtn.click();

                ////////////////////////////////////////////////////////
                try {
                    List<WebElement> saleElements1 = driver.findElements(saleElements);

                    if (saleElements1.size() != 0) {
                        List<WebElement> amountsInSaleItems = driver.findElements(By.xpath("//div[@class='astra-shop-summary-wrap']/child::span//ins//bdi"));
                        List<WebElement> productNameInSaleItems1 = driver.findElements(productNameInSaleItems);
                        for (int i = 0; i < productNameInSaleItems1.size(); i++) {
                            productNameAndAmount.put(productNameInSaleItems1.get(i).getText(), amountsInSaleItems.get(i).getText() + " on sale item");

                        }
                    }
                }catch (Exception e){
                    System.out.println("No item in sale on this page");

                }

                ////////////////////////////////////////////////////////
                try {

                    List<WebElement> withoutSaleProductsPrice1 = driver.findElements(withoutSaleProductsPrice);
                    if (withoutSaleProductsPrice1.size() != 0) {
                        List<WebElement> productNameWithoutSaleItems = driver.findElements(By.xpath("//div[@class='astra-shop-summary-wrap']/child::span/span/bdi//ancestor::li/div[2]/a/h2"));
                        for (int i = 0; i < withoutSaleProductsPrice1.size(); i++) {
                            productNameAndAmount.put(productNameWithoutSaleItems.get(i).getText(), withoutSaleProductsPrice1.get(i).getText());

                        }
                    }
                }catch (Exception e){
                    System.out.println("No item without sale on this page");

                }

            }}
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("next button is not exist");
        }

////////////////////////////////////////////////////////
        // Print the HashMap
        for (Map.Entry<String, String> entry : productNameAndAmount.entrySet()) {
            System.out.println("Product Name: " + entry.getKey() + ", Amount: " + entry.getValue());
        }
        System.out.println("Total products count on all pages after sort : "+productNameAndAmount.size());

    }

}

