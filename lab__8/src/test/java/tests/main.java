package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class main {


    @Test
    public void common()     {


        WebDriver driver = new ChromeDriver();
        driver.get("https://smorodina.com/");


        WebElement searchInput = driver.findElement(By.id("mainSearchFieldInput"));
        searchInput.sendKeys("Минск");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id='mainSearchButton']"));

        searchButton.click();


        new WebDriverWait(driver,10)
                .until(ExpectedConditions
                        .attributeToBe(searchInput,"class","abc"));


        driver.quit();
    }
}
