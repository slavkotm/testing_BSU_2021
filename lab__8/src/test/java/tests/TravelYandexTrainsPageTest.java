package tests;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TravelYandexTrainsPage;

public class TravelYandexTrainsPageTest {

    private WebDriver driver;

    @BeforeMethod
    public void browserSetup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080",
                "--disable-extensions", "--proxy-server='direct://'", "--proxy-bypass-list=*", "--start-maximized",
                "--disable-gpu", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchResultForTrainTicketsWithoutEnteringDate()
    {
        String source = "Москва";
        String destination = "Минск";
        String date = "Сегодня";

        TravelYandexTrainsPage trainsPage = new TravelYandexTrainsPage(driver)
                .openPage()
                .enterFrom(source)
                .enterTo(destination)
                .submit();
        String sourceAndDestination = trainsPage.getSourceAndDestination();

        Assert.assertTrue(
                sourceAndDestination.contains(source)
                        && sourceAndDestination.contains(destination)
                        && trainsPage.getDateString().equals(date));
    }

    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
