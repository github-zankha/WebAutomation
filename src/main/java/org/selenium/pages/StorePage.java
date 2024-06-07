package org.selenium.pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.enums.WaitStrategy;

import java.util.*;

import static org.selenium.factories.ExplicityWaitFactory.performExplicitWait;

public class StorePage extends BasePage {
    //private ProductThumbnail productThumbnail;
    public StorePage(WebDriver driver) {
        super(driver);
    }

    /*public ProductThumbnail getProductThumbnail() {
        return ProductThumbnail;

    }  */
    public Boolean Isloader() {


        return wait.until(ExpectedConditions.urlContains("/store"));
    }

    private final By searchTextBox = By.id("woocommerce-product-search-field-0");
    //private final By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private final By searchBtn = By.xpath("(//button[@type='submit'])[1]");
    private final By title = By.xpath("//h1[@class='woocommerce-products-header__title page-title']");
    private final By sortByList = By.xpath("//select[@name='orderby']");
    private final By anchorBracelateBtn = By.xpath("//a[@aria-label='Add “Anchor Bracelet” to your cart']");
    private final By blueShoesBtn = By.xpath("a[@aria-label='Add “Blue Shoes” to your cart']");
    private final By blueDenimShortsBtn = By.xpath("a[@aria-label='Add “Blue Denim Shorts” to your cart']]");
    private final By leftSliderBar = By.xpath("//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[2]");
    private final By filterBtn = By.xpath ("//button[normalize-space()='Filter']");
    private final By ProductsNOTSale_BY= By.xpath("//div[@class='astra-shop-summary-wrap']/child::span/span/bdi");
    private final By productsNameNOTonSale_BY =By.xpath("//div[@class='astra-shop-summary-wrap']/child::span/span/bdi//ancestor::li/div[2]/a/h2");
    private final By nextPageBtn_By= By.xpath("//a[@class='next page-numbers']");
    private final By productsAddedCartPrice = By.xpath("//a[contains(@title,'View cart')]/preceding-sibling::span[contains(@class,'price')]/ins/span/bdi/span");
    private final By productsViewCart = By.xpath("//a[contains(@title,'View cart')]/preceding-sibling::span[contains(@class,'price')]/ins/span/bdi/span");
    private final By addToCartBtnAnchorBracelet = By.xpath("//a[@aria-label='Add “Anchor Bracelet” to your cart");
    private final By addToCartBtnBlackHandBag= By.xpath("//a[@aria-label='Add “Black Over-the-shoulder Handbag” to your cart']");
    private final By saleElements_By = By.xpath("//div[@class='astra-shop-summary-wrap']/preceding-sibling::div/span");

    private final By priceOnSaleProducts_By = By.xpath("//div[@class='astra-shop-summary-wrap']/child::span//ins//bdi");

    private final By productsNameOnSale = By.xpath("//div[@class='astra-shop-summary-wrap']/child::span//ins//bdi//ancestor::li/div[2]/a/h2");

    private final By bestSellerProductsNames_By = By.xpath("//ul[@class='product_list_widget']//a/span");
    private final By bestSellerProductsPrice_By = By.xpath("//ul[@class='product_list_widget']/child::li/child::span");
    private final By ViewCartLables_By =By.xpath("//a[@title='View cart']");
    private final By productNamesAddedToCart = By.xpath("//a[@title='View cart']/preceding-sibling::a/h2");
    private final By BasicBlueJeanLbl_By =  By.xpath("//h2[contains(text(),'Basic Blue Jeans')]");

    String ProdID = null;
    private  By BasicBlueJeanAddToCartBtn_By;
    public StorePage enterTextInSearchField(String txt) {
        sendKey(searchTextBox, WaitStrategy.PRESENCE, txt, "Search Field");
        return this;
    }

    /*public StorePage search(String txt){
       search(txt).clickSearchBtn();
       return this;
   }*/
    //Step  this is annotation for allure report.
    public StorePage load() {
        load("store");
        return this;
    }

    public StorePage clickSearchBtn() {
        click(searchBtn, WaitStrategy.CLICKABLE, "Search Button");
        return this;
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }
    public String getStorePageURL(){
        return getPageURL();
    }

    public SrchProductsPage searchProducts(String searchProdValue){
      sendKey(searchTextBox,WaitStrategy.PRESENCE, searchProdValue, "Product Search Text");
      clickSearchBtn();
      return new SrchProductsPage(driver);
    }

    public void prodSorting(String val){
        selectFromList(sortByList, val,WaitStrategy.PRESENCE,"Sort By Low to High Price");

    }
    public void clikcBlueShoesBtn(){
        click(blueShoesBtn, WaitStrategy.CLICKABLE, "Blue Shoes Product Button");

    }
    public void clikcBlueDenimShortBtn(){
        click(blueDenimShortsBtn, WaitStrategy.CLICKABLE, "Blue Shoes Product Button");

    }
    public void clikcAnchorBracelatetBtn(){
        click(anchorBracelateBtn, WaitStrategy.CLICKABLE, "Blue Shoes Product Button");

    }
    public void slidPriceRange() throws InterruptedException {
        pageScroll(leftSliderBar);
        handleActionSlider(leftSliderBar);
        click(filterBtn,WaitStrategy.PRESENCE,"Filter Button");
        Thread.sleep(5000);

        //highlighElement(leftSliderBar);

    }
    public String getAfterFilterURL(){
        return driver.getCurrentUrl();

    }
    public void captureProductsInfoThrPagination() {
        Map<String, String> allProducts= new HashMap<String, String>();
        allProducts.putAll(productOnSaleInfo( ));
        allProducts.putAll(productNOTonSaleInfo( ));
        while (clickOnNextPage()==true){

            allProducts.putAll(productOnSaleInfo( ));
            allProducts.putAll(productNOTonSaleInfo( ));

        }
        // Print the HashMap
        for (Map.Entry<String, String> entry : allProducts.entrySet()) {
            System.out.println("Product Name: " + entry.getKey() + ", Amount: " + entry.getValue());
        }
        System.out.println("===================Producs(Sale/Without Sale Information)===================");
        System.out.println("Total products count on all pages after sort : " + allProducts.size());
        //String count=Integer.toString(amountsList.size());
        //Assert.assertTrue(driver.findElement(By.className("woocommerce-result-count")).getText().contains(count));

    }
    public Map<String, String> productNOTonSaleInfo() {
        Map<String, String> productNameAndAmountNOTOnSale = new HashMap<>();

        List<WebElement> withoutSaleElements = driver.findElements(ProductsNOTSale_BY);
        try {
            if (withoutSaleElements.size() != 0) {
                List<WebElement> productNameWithoutSaleItems = driver.findElements(productsNameNOTonSale_BY);
                for (int i = 0; i < withoutSaleElements.size(); i++) {
                    productNameAndAmountNOTOnSale.put(productNameWithoutSaleItems.get(i).getText(), withoutSaleElements.get(i).getText());

                }
            }
        } catch (Exception e) {
            System.out.println("No item without sale on this page");

        }

        return productNameAndAmountNOTOnSale;
    }

    public boolean clickOnNextPage(){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement nxtBtn = driver.findElement(nextPageBtn_By);
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
    public Map<String, String> productOnSaleInfo() {
        //List<String> amountsList = new ArrayList<>();
        Map<String, String> productNameAndAmountOnSale = new HashMap<>();
        List<WebElement> saleElements = driver.findElements(saleElements_By);

        if (saleElements.size() != 0)
        {
            List<WebElement> amountsInSale = driver.findElements(priceOnSaleProducts_By);
            List<WebElement> productNameInSaleItems = driver.findElements(productsNameOnSale);
            for (int i = 0; i < productNameInSaleItems.size(); i++)
            {
                productNameAndAmountOnSale.put(productNameInSaleItems.get(i).getText(), amountsInSale.get(i).getText() + " on sale item");

            }

        }
        return productNameAndAmountOnSale;
    }
    public void bestSellerProducts(){
        Map<String, String> bestSellerProducts = new HashMap<>();
        List<WebElement> bestSellerProductsName = driver.findElements(bestSellerProductsNames_By);
        try {
            if (bestSellerProductsName.size() != 0) {
                List<WebElement> bestSellerProductsPrice = driver.findElements(bestSellerProductsPrice_By);
                for (int i = 0; i < bestSellerProductsName.size(); i++) {
                    bestSellerProducts.put(bestSellerProductsName.get(i).getText(), bestSellerProductsPrice.get(i).getText());

                }
            }
        } catch (Exception e) {
            System.out.println("No item without sale on this page");

        }
        for (Map.Entry<String, String> entry : bestSellerProducts.entrySet()) {
            System.out.println("Best Seller Product Name: " + entry.getKey() + ", Amount: " + entry.getValue());
        }
        System.out.println("===================Best Sellers Products Information===================");
        System.out.println("Total Best Sellers Products : " + bestSellerProducts.size());
    }
    public void clickAddToCartBtnAnchorBracelet(){
        click(addToCartBtnAnchorBracelet,WaitStrategy.CLICKABLE,"Add to Cart Button");
    }
    public void clickAddToCartBtnBlackHandBag(){
        click(addToCartBtnBlackHandBag,WaitStrategy.CLICKABLE,"Add to Cart Button");
    }
    public void productsInfoAddedToCart(){

        Map<String, String> addedToCart = new HashMap<>();
        if (countViewCart()!=0) {
            List<WebElement> pruductNamesAddedToCartsList = driver.findElements(productNamesAddedToCart);}

        //productNamesAddedToCart
        //check added cart product is in sale or not

        //List<WebElement> productsNamesAddedList = driver.findElements("");
        //List<WebElement> ProductsNamesAddedToCart = driver.findElements();
    }
    public int countViewCart(){
        List<WebElement> viewCartLabelsList = driver.findElements(ViewCartLables_By);

        if (viewCartLabelsList.size()!=0) {
            System.out.println("Total Products in Added in the Cart: " +viewCartLabelsList.size());

        }
        return viewCartLabelsList.size();

    }
    public void selectBasicBlueJeans(){

        ProdID = driver.findElement(By.xpath("//a[contains(@aria-label,'Basic Blue Jeans')]")).getAttribute("data-product_id");
        BasicBlueJeanAddToCartBtn_By =  By.xpath("(//a[@data-product_id='"+ProdID+"'])[3]");

        click(BasicBlueJeanAddToCartBtn_By,WaitStrategy.PRESENCE,"Add to Cart Button");
    }
    public String viewCartTxtProdID() throws InterruptedException {
        performExplicitWait(WaitStrategy.PRESENCE,By.xpath("//a[@data-product_id='"+ProdID+"']/following-sibling::a[@title='View cart']"));
        WebElement ViewCartbyProdID= driver.findElement(By.xpath("//a[@data-product_id='"+ProdID+"']/following-sibling::a[@title='View cart']"));
        return ViewCartbyProdID.getAttribute("title");


    }
}