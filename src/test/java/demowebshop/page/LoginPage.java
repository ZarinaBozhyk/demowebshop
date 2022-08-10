package demowebshop.page;

import demowebshop.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 8/9/2022
 * #Comments:
 */
public class LoginPage extends AbstractPage {
    private final String BASE_URL = "http://demowebshop.tricentis.com/login";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@class='email']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@class='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[contains(@class,'login-button')]")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
        return this;
    }

    public HomePage login(User user) {
        inputLogin.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        buttonLogin.click();
        logger.info("Login performed");
        return new HomePage(driver);
    }
}
