package com.assignment.tests;

import com.assignment.pages.HomePage;
import com.assignment.pages.DreamDiaryPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DreamPortalTest extends BaseTest {

    @Test
    public void testDreamPortalFunctionality() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage("https://arjitnigam.github.io/myDreams/");
        homePage.waitForPageToLoad();
        homePage.clickMyDreamsButton();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        DreamDiaryPage diaryPage = new DreamDiaryPage(driver);

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("screenshots/dream_diary.png"));

        int entryCount = diaryPage.getDreamEntryCount();
        Assert.assertEquals(entryCount, 10, "Total dream entries should be 10");

        List<String> types = diaryPage.getDreamTypes();
        int goodCount = 0;
        int badCount = 0;
        for(String type : types) {
            Assert.assertTrue(type.equals("Good") || type.equals("Bad"), "Invalid dream type: " + type);
            if(type.equals("Good")) goodCount++;
            else badCount++;
        }

        List<List<String>> allRows = diaryPage.getAllRowsData();
        for(List<String> row : allRows) {
            Assert.assertEquals(row.size(), 3, "Each row must have 3 columns");
            for(String cell : row) {
                Assert.assertFalse(cell.isEmpty(), "Column should not be empty");
            }
        }

        Assert.assertEquals(goodCount, 6, "Good dreams count mismatch");
        Assert.assertEquals(badCount, 4, "Bad dreams count mismatch");
    }
}
