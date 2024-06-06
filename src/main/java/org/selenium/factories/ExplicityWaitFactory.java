package org.selenium.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.constants.FramworkConstants;
import org.selenium.driver.DriverManager;
import org.selenium.enums.WaitStrategy;

import java.time.Duration;

public final class ExplicityWaitFactory {
    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {

        WebElement element = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        }
        else if (waitStrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if (waitStrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if (waitStrategy == WaitStrategy.NONE) {
            System.out.println("Not Waiting for anything");
            element = DriverManager.getDriver().findElement(by);
        }


        return element;

        // wait.until(d -> d.findElement(link_logout).isEnabled());// Java 8 way

    }
}
