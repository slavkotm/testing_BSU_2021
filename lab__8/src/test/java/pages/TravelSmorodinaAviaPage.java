package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelSmorodinaAviaPage extends AbstractPage
{
    public static String TRAINS_PAGE_URL = "https://smorodina.com";

    public TravelSmorodinaAviaPage(WebDriver driver)
    {
        super(driver);
    }

    public TravelSmorodinaAviaPage openPage()
    {
        driver.get(TRAINS_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='flights-origin-prepop-2bdc6ed511239f63231a22554da76d55']")));
        return this;
    }
}
