package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputWithSearch {
    WebDriver driver;
    String label;

    private static final String FIELD_WITH_SEARCH_XPATH = "//label[contains(text(),'%s')]/ancestor::lightning-grouped-combobox[contains(@class,'slds-form-element')]//input";
    private static final String FIRST_FOUND_ITEM = "//li[contains(@class,'slds-listbox__item')]//lightning-base-combobox-item";

    public InputWithSearch(WebDriver driver, String label){
        this.driver = driver;
        this.label = label;
    }

    public void writeTextToInputAndSelect(String text){
        driver.findElement(By.xpath(String.format(FIELD_WITH_SEARCH_XPATH, label))).sendKeys(text);
        driver.findElement(By.xpath(String.format(FIRST_FOUND_ITEM))).click();
    }
}
