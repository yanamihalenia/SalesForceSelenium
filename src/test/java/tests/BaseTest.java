package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest implements ITestConstants, IConstants {
    WebDriver driver;
    AccountPage accountPage;
    AccountsListPage accountsListPage;
    HomePage homePage;
    LoginPage loginPage;
    NewAccountModalPage newAccountModalPage;
    ContactPage contactPage;
    ContactsListPage contactsListPage;
    NewContactModalPage newContactModalPage;

    public void initPages(){
        accountPage = new AccountPage(driver);
        accountsListPage = new AccountsListPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        newAccountModalPage = new NewAccountModalPage(driver);
        contactPage = new ContactPage(driver);
        contactsListPage = new ContactsListPage(driver);
        newContactModalPage = new NewContactModalPage(driver);
    }

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        initPages();
    }

    @AfterMethod
    public void endTest() {
        driver.quit();
    }
}
