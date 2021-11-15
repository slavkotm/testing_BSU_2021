package tests;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TravelSmorodinaAviaPageTest {

    private WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080",
                "--disable-extensions", "--proxy-server='direct://'", "--proxy-bypass-list=*", "--start-maximized",
                "--disable-gpu", "--ignore-certificate-errors");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchAviaTicketsWithoutDate() {
        String source = "Минск";
        String destination = "Рим";


    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    /*@Test
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://smorodina.com");

        WebElement searchInput = driver.findElement(By.id("mainSearchButton"));

        searchInput.sendKeys("Москва");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id='mainSearchButton']/span"));

        searchButton.click();


        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .attributeToBe(searchInput,"class", "abc"));


        driver.quit();
    }*/
}
