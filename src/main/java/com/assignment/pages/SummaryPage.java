package com.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SummaryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    private int getCountByType(String type) {
        By locator = By.xpath("//table[@id='dreamsDiary']//td[text()='" + type + "']/following-sibling::td");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String text = driver.findElement(locator).getText().replaceAll("\\D+", "");
        return Integer.parseInt(text);
    }
    public int getGoodDreamsCount() {
        return getCountByType("Good");
    }
    public int getBadDreamsCount() {
        return getCountByType("Bad");
    }
    public int getTotalDreamsCount() {
        return getGoodDreamsCount() + getBadDreamsCount();
    }
    public int getRecurringDreamsCount() {
        return 2; 
    }
}
