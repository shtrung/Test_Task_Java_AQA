package org.example.UITestTask2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class ElementWait {

    private final WebDriverWait wait;
    private final WebDriver driver;

    public ElementWait(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void waitWebElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void click(WebElement webElement){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }

}
