package org.selenium.test;


import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
import org.testng.annotations.Test;
import utils.Loggers;
import utils.ScreenShotUtils;

public class SortSelectAddTpCardTest extends BaseTest {

    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"}, enabled = true)
    public void SortAddTocart() throws InterruptedException{
        HomePage HomePg = new HomePage(getdr());

        HomePg.openURL("");
        StorePage strPg = HomePg.clickStoreMenu();

        Thread.sleep(2000);
        System.out.println("Done sleeping, no interrupt.");

        strPg.prodSorting("rating");
        Thread.sleep(2000);
        Loggers.log.info("Product sorted by Low to High Price");
        strPg.captureProductsInfoThrPagination();
        strPg.bestSellerProducts();

    }
}
