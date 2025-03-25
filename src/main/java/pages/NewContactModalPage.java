package pages;

import elements.Button;
import elements.Input;
import elements.InputWithSearch;
import objects.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewContactModalPage extends BasePage{

    @FindBy(xpath = "//*[@name='SaveEdit']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@name='SaveAndNew']")
    public WebElement saveAndNewButton;

    @FindBy(xpath = "//*[@name='CancelEdit']")
    public WebElement cancelButton;

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }

    public NewContactModalPage openPage(String url){
        driver.get(url);
        return this;
    }

    public void createNewContact(Contact contact){
        new Input(driver, "First Name").writeTextToInput(contact.getFirstName());
        new Input(driver, "Last Name").writeTextToInput(contact.getLastName());
        new InputWithSearch(driver, "Account Name").writeTextToInputAndSelect(contact.getAccountName());
        new Input(driver, "Description").writeTextToTextarea(contact.getDescription());
        new Input(driver, "Phone").writeTextToInput(contact.getPhone());
        new Button(driver).clickButton(saveButton);
    }
}
