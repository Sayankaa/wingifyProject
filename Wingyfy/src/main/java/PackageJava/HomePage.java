package PackageJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    // Locators
    private By amountHeader = By.id("amount");
    private By amountColumn = By.cssSelector(".transaction .amount");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Page actions
    public void clickAmountHeader() {
        driver.findElement(amountHeader).click();
    }

    public List<String> getAmountValues() {
        List<WebElement> amountElements = driver.findElements(amountColumn);
        List<String> amounts = new ArrayList<>();
        for (WebElement element : amountElements) {
            amounts.add(element.getText());
        }
        return amounts;
    }
}
