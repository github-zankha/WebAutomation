package org.selenium.test;

import org.junit.Assert;
import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.StoreAccessoriesPage;
import org.selenium.pages.StorePage;
import org.testng.annotations.Test;

public class StoreAccessoriesTest extends BaseTest {
    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"})
    public void VerifyStoreAccessoriesPage() throws InterruptedException {
        StoreAccessoriesPage strAcsPg = new StoreAccessoriesPage(getdr());
        StorePage strPg = new StorePage(getdr());
        strAcsPg.loadAccessoriesPage();
        System.out.println("Current URL:" + getdr().getCurrentUrl());
        Assert.assertTrue(getdr().getCurrentUrl(), strAcsPg.Isloader());
        System.out.println(getdr().getClass().getName() + " Assert True executed");

        strPg.captureProductsInfoThrPagination();
    }
}
