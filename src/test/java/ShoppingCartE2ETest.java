import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.ItemIframe;
import pageObjects.ShoppingCart;
import pageObjects.SignInPage;
import pageObjects.StorefrontPage;

import java.util.concurrent.TimeUnit;

public class ShoppingCartE2ETest {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void addSummerDressToCart() {

        //Navigate to store front and initialize objects
        StorefrontPage storeFront = PageFactory.initElements(driver, StorefrontPage.class);
        storeFront.clickSummerDress();

        // Focus on the iframe and add item to the cart
        ItemIframe item = PageFactory.initElements(driver, ItemIframe.class);
        item.addToCart();

        storeFront.goToShoppingCart();

        //Once in the cart, perform various validation to make sure the item has been added correctly
        ShoppingCart cart = PageFactory.initElements(driver, ShoppingCart.class);
        assertEquals(cart.howManyItemsInCart(), "1 Product");
        assertEquals(cart.getDressName(), "Printed Summer Dress");
        assertEquals(cart.getNumberOfDressesAdded(), "1");

        cart.clickCheckoutButton();

        // Make sure I have landed on the Sign In page
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        assertTrue(signInPage.isCreateAccountFormPresent());
        assertTrue(signInPage.isLoginFormPresent());
    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
