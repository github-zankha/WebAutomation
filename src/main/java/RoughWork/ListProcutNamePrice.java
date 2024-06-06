package RoughWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;

public class ListProcutNamePrice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().clearDriverCache().setup();
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com/store/");
        driver.manage().window().maximize();
        ListProcutNamePrice listProcutNamePrice = new ListProcutNamePrice();
        //listProcutNamePrice.captureAmountThrPagination(driver);
        listProcutNamePrice.viecarttext(driver);


    }

    public void captureAmountThrPagination(WebDriver driver) {
        Map<String, String> allProducts= new HashMap<String, String>();
        allProducts.putAll(productOnSaleInfo( driver));
        allProducts.putAll(productNOTonSaleInfo( driver));
        while (clickOnNextPage(driver)==true){

                allProducts.putAll(productOnSaleInfo(driver ));
                allProducts.putAll(productNOTonSaleInfo(driver ));

            }
               // Print the HashMap
        for (Map.Entry<String, String> entry : allProducts.entrySet()) {
            System.out.println("Product Name: " + entry.getKey() + ", Amount: " + entry.getValue());
        }
        System.out.println("Total products count on all pages after sort : " + allProducts.size());
        //String count=Integer.toString(amountsList.size());
        //Assert.assertTrue(driver.findElement(By.className("woocommerce-result-count")).getText().contains(count));

    }

    public Map<String, String> productNOTonSaleInfo(WebDriver driver ) {
        Map<String, String> productNameAndAmountNOTOnSale = new HashMap<>();

        List<WebElement> withoutSaleElements = driver.findElements(By.xpath("//div[@class='astra-shop-summary-wrap']/child::span/span/bdi"));
        try {


            if (withoutSaleElements.size() != 0) {
                List<WebElement> productNameWithoutSaleItems = driver.findElements(By.xpath("//div[@class='astra-shop-summary-wrap']/child::span/span/bdi//ancestor::li/div[2]/a/h2"));
                for (int i = 0; i < withoutSaleElements.size(); i++) {
                    productNameAndAmountNOTOnSale.put(productNameWithoutSaleItems.get(i).getText(), withoutSaleElements.get(i).getText());

                }
            }
        } catch (Exception e) {
            System.out.println("No item without sale on this page");

        }

        return productNameAndAmountNOTOnSale;
    }

    public boolean clickOnNextPage(WebDriver driver){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement nxtBtn = driver.findElement(By.xpath("//a[@class='next page-numbers']"));
            js.executeScript("arguments[0].scrollIntoView(true);", nxtBtn);
            nxtBtn.click();
        } catch (NoSuchElementException e) {
            //e.printStackTrace();
            System.out.println("next button is not exist");
            return false;
        }
       catch (Exception e) {
        //e.printStackTrace();
        System.out.println("next button is not exist");
        return false;
    }
        return true;
    }
    public Map<String, String> productOnSaleInfo(WebDriver driver ) {
        //List<String> amountsList = new ArrayList<>();
        Map<String, String> productNameAndAmountOnSale = new HashMap<>();
        List<WebElement> saleElements = driver.findElements(By.xpath("//div[@class='astra-shop-summary-wrap']/preceding-sibling::div/span"));

        if (saleElements.size() != 0)
        {
            List<WebElement> amountsInSale = driver.findElements(By.xpath("//div[@class='astra-shop-summary-wrap']/child::span//ins//bdi"));
            List<WebElement> productNameInSaleItems = driver.findElements(By.xpath("//div[@class='astra-shop-summary-wrap']/child::span//ins//bdi//ancestor::li/div[2]/a/h2"));
            for (int i = 0; i < productNameInSaleItems.size(); i++)
            {
                productNameAndAmountOnSale.put(productNameInSaleItems.get(i).getText(), amountsInSale.get(i).getText() + " on sale item");

            }

        }


        return productNameAndAmountOnSale;
    }
    public void viecarttext(WebDriver driver ){
        driver.findElement(By.xpath("//a[@aria-label='Add “Anchor Bracelet” to your cart']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title,'View cart')]//preceding-sibling::span[@class='price']/ins/span/bdi")));
        WebElement price = driver.findElement(By.xpath("//a[contains(@title,'View cart')]//preceding-sibling::span[@class='price']/ins/span/bdi"));


        String s = price.getText();
        System.out.println("view cart price : "+ s);
    }
}


