package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountModalPage extends BasePage{

    @FindBy(name = "SaveEdit")
    public WebElement saveButton;

    @FindBy(name = "SaveAndNew")
    public WebElement saveAndNewButton;

    @FindBy(name = "CancelEdit")
    public WebElement cancelButton;

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public NewAccountModalPage openPage(String url){
        driver.get(url);
        return this;
    }
}
