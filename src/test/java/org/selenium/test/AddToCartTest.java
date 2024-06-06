package org.selenium.test;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    @FrameworkAnnotation(author = {AuthorType.ZANKHANA},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SANITY", "SMOKE", "REGRESSION"})
    public void addProdsToCart(){

    }
}
