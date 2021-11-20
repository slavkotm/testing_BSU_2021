package org.testing.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testing.page.SearchResultOnTravellingPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultOnTravellingPageTest {

    private ChromeDriver driver;
    private static final String ARRIVAL_PLACE = "Москва";
    private static final String DEPARTURE_PLACE = "Рим";

    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080",
                "--disable-extensions", "--proxy-server='direct://'", "--proxy-bypass-list=*", "--start-maximized",
                "--disable-gpu", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchAviaTicketsForTravel() {
        SearchResultOnTravellingPage searchResultOnTravellingPage = new SearchResultOnTravellingPage(driver)
                .openPage()
                .searchPlaceTravelling(ARRIVAL_PLACE)
                .completePlaceTravelling()
                .completeView()
                .completeWhichElement()
                .searchInputDeparture(DEPARTURE_PLACE)
                .searchInputArrival(ARRIVAL_PLACE);
        Assert.assertEquals(searchResultOnTravellingPage.getArrivalCity(), searchResultOnTravellingPage.getDepartureCity());
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
