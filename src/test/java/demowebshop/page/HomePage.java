package demowebshop.page;

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
public class HomePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "http://demowebshop.tricentis.com/";

    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement linkLogin;

    @FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
    private WebElement linkLoggedInUser;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public LoginPage invokeLoginPage() {
        linkLogin.click();
        return new LoginPage(driver);
    }

    public String getLoggedInUserName() {
        return linkLoggedInUser.getText();
    }
}
