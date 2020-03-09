package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StorefrontPage {
    private WebDriver driver;

    public StorefrontPage(WebDriver driver) {
        super();
        driver.get("http://automationpractice.com/index.php");
        this.driver = driver;
    }

    @FindBy(css = "div[class='product-image-container']")
    List<WebElement> featuredItems;

    public void clickSummerDress() {
        featuredItems.get(4).click();
    }

    public void goToShoppingCart() {
        driver.get("http://automationpractice.com/index.php?controller=order");
    }
}
