package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart {
    private WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        super();
        this.driver = driver;
    }

    @FindBy(id = "summary_products_quantity")
    WebElement cartProductQuantity;

    @FindBy(xpath = "//*[@id=\"product_5_19_0_0\"]/td[2]/p/a")
    WebElement summerDress;

    @FindBy(xpath = "//*[@id=\"product_5_19_0_0\"]/td[5]/input[2]")
    WebElement numberOfDressesAdded;

    @FindBy(className = "standard-checkout")
    WebElement checkoutButton;

    public String howManyItemsInCart() {
        return cartProductQuantity.getText();
    }

    public String getDressName() {
        return summerDress.getText();
    }

    public String getNumberOfDressesAdded() {
        return numberOfDressesAdded.getAttribute("value");
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

}
