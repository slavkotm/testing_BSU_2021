package org.testing.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultOnTravellingPage extends AbstractPage {

    private static final String PAGE_URL = "https://smorodina.com";
    private static final String MAIN_INPUT = "//*[@id='mainSearchFieldInput']";
    private static final String MAIN_BUTTON = "//*[@id='mainSearchButton']";
    private static final String BUTTON_TESTING_ONE = "//*[@id='searchCategories']/div/button[2]";
    private static final String BUTTON_WHICH_ELEMENT = "//a[@href='/objects/paleontologicheskiy-muzey-im-yu-a-orlova-g-moskva']/b";
    private static final String ARRIVAL_CITY = "//*[@id='flights-destination-prepop-bbf7f70dad1eb1eb261b0b381b1e0588']";
    private static final String DEPARTURE_CITY = "//*[@id='flights-origin-prepop-bbf7f70dad1eb1eb261b0b381b1e0588']";

    @FindBy(xpath = "//*[@id='mainSearchFieldInput']")
    private WebElement searchInputMain;

    @FindBy(xpath = "//*[@id='mainSearchButton']")
    private WebElement searchButtonMain;

    @FindBy(xpath = "//*[@id='searchCategories']/div/button[2]")
    private WebElement searchTabViews;

    @FindBy(xpath = "//a[@href='/objects/paleontologicheskiy-muzey-im-yu-a-orlova-g-moskva']/b")
    private WebElement searchButtonWhichElement;

    @FindBy(xpath = "//*[@id='flights-destination-prepop-bbf7f70dad1eb1eb261b0b381b1e0588']")
    private WebElement searchInputArrivalCity;

    @FindBy(xpath = "//*[@id='flights-origin-prepop-bbf7f70dad1eb1eb261b0b381b1e0588']")
    private WebElement searchInputDepartureCity;

    public SearchResultOnTravellingPage searchInputDeparture(String departureCity) {
        searchInputDepartureCity.sendKeys(departureCity);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ARRIVAL_CITY)));
        return this;
    }

    public SearchResultOnTravellingPage searchInputArrival(String arrivalCity) {
        searchInputArrivalCity.sendKeys(arrivalCity);
        return this;
    }

    public SearchResultOnTravellingPage searchPlaceTravelling(String place) {
        searchInputMain.sendKeys(place);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(MAIN_BUTTON)));
        return this;
    }

    public SearchResultOnTravellingPage completePlaceTravelling() {
        searchButtonMain.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_TESTING_ONE)));
        return this;
    }

    public SearchResultOnTravellingPage completeWhichElement() {
        searchButtonWhichElement.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DEPARTURE_CITY)));
        return this;
    }

    public SearchResultOnTravellingPage completeView() {
        searchTabViews.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_WHICH_ELEMENT)));
        return this;
    }

    public SearchResultOnTravellingPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultOnTravellingPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(MAIN_INPUT)));
        return this;
    }

    public String getMainInput() {
        return searchInputMain.getText();
    }

    public String getArrivalCity() {
        return searchInputArrivalCity.getText();
    }

    public String getDepartureCity() {
        return searchInputDepartureCity.getText();
    }
}
