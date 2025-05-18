package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends BasePage {

    private By searchBox = By.name("q");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String query) {
        WebElement box = driver.findElement(searchBox);
        box.clear();
        box.sendKeys(query + Keys.ENTER);
    }
}
