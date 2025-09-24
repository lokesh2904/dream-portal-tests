package com.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By loadingOverlay = By.id("loading-overlay");
    private By mainContent = By.className("main-container");
    private By myDreamsButton = By.id("dreamButton");
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void navigateToHomePage(String url) {
        driver.get(url);
    }
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingOverlay));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainContent));
    }
    public void clickMyDreamsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(myDreamsButton)).click();
    }
}
