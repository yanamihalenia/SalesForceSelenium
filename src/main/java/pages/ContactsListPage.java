package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsListPage extends BasePage{
    private static final String CONTACTS_TABLE_XPATH = "//table";
    private static final String CONTACT_NAME_FIELD_XPATH = CONTACTS_TABLE_XPATH + "//a[contains(@title,'%s')]";
    private static final String CONTACT_PHONE_FIELD_XPATH = CONTACT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class,'forceOutputPhone')]";
    private static final String CONTACT_OWNER_ALIAS_FIELD_XPATH = CONTACT_NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class,'uiOutputText')]";

    public ContactsListPage(WebDriver driver) {
        super(driver);
    }

    public ContactsListPage openPage(String url){
        driver.get(url);
        return this;
    }

    public String getExistContactName(String contactName){
        return driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, contactName))).getText();
    }

    public String getExistPhoneByContactName(String contactName){
        return driver.findElement(By.xpath(String.format(CONTACT_PHONE_FIELD_XPATH, contactName))).getText();
    }

    public String getExistContactOwnerByContactName(String contactName){
        return driver.findElement(By.xpath(String.format(CONTACT_OWNER_ALIAS_FIELD_XPATH, contactName))).getText();
    }

    public ContactPage clickOnContactName(String contactName){
        driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, contactName))).click();
        return new ContactPage(driver);
    }
}
