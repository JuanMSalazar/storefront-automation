package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemIframe {
    private WebDriver driver;

    public ItemIframe(WebDriver driver) {
        super();
        this.driver = driver;
        //focus on iframe to be able to add item to the cart
        driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
    }

    @FindBy(id = "add_to_cart")
    WebElement addToCartButton;

    public void addToCart() {

        addToCartButton.click();

        // focus back to main content outside of the iframe
        driver.switchTo().defaultContent();
        //wait for element to be added to the cart
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.id("layer_cart"))));
    }
}


