package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TravelPlanningTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void searchFlightsFromCairoToMarsaAlam() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Flights from Cairo to Marsa Alam");
        searchBox.submit();
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("cairo"));
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("marsa alam"));
    }

    @Test(priority = 2)
    public void checkWeatherInMarsaAlam() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Marsa Alam weather");
        searchBox.submit();
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("marsa alam"));
    }

    @Test(priority = 3)
    public void searchRestaurantsNearMarsaAlam() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("restaurant near Marsa Alam");
        searchBox.submit();
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("restaurant"));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
