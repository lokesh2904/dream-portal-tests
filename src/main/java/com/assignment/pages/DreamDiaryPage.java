package com.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DreamDiaryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By tableRows = By.cssSelector("table#dreamsDiary tbody tr");
    private By dreamTypeCells = By.cssSelector("table#dreamsDiary tbody tr td:nth-child(3)");
    private By dreamNameCells = By.cssSelector("table#dreamsDiary tbody tr td:nth-child(1)");

    public DreamDiaryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // increased timeout
    }

    public int getDreamEntryCount() {
        wait.until(driver -> {
            List<WebElement> rows = driver.findElements(tableRows);
            return rows.size() >= 10; // waits until at least 10 rows are present
        });
        return driver.findElements(tableRows).size();
    }

    public List<String> getDreamTypes() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dreamTypeCells));
        List<String> types = new ArrayList<>();
        for (WebElement e : driver.findElements(dreamTypeCells)) {
            types.add(e.getText());
        }
        return types;
    }

    public List<String> getDreamNames() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dreamNameCells));
        List<String> names = new ArrayList<>();
        for (WebElement e : driver.findElements(dreamNameCells)) {
            names.add(e.getText());
        }
        return names;
    }

    public List<List<String>> getAllRowsData() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tableRows));
        List<List<String>> allData = new ArrayList<>();
        for (WebElement row : driver.findElements(tableRows)) {
            List<String> rowData = new ArrayList<>();
            for (WebElement cell : row.findElements(By.tagName("td"))) {
                rowData.add(cell.getText());
            }
            allData.add(rowData);
        }
        return allData;
    }
}
