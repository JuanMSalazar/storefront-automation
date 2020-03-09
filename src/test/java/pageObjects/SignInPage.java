package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    @FindBy(id = "create-account_form")
    WebElement createAccountForm;

    @FindBy(id = "login_form")
    WebElement loginForm;

    public boolean isCreateAccountFormPresent() {
        return createAccountForm.isDisplayed();
    }

    public boolean isLoginFormPresent() {
        return loginForm.isDisplayed();
    }
}


