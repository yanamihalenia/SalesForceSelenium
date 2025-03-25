package tests;

import com.github.javafaker.Faker;
import objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest{

    Faker faker = new Faker();

    @Test
    public void createContactTest(){
        Contact contact = new Contact();
        contact.setFirstName(faker.name().firstName());
        contact.setLastName(faker.name().lastName());
        contact.setAccountName("test");
        contact.setDescription("some description");
        contact.setPhone(faker.phoneNumber().phoneNumber());
        loginPage
                .openPage(LOGIN_URL)
                .login(username, password);
        newContactModalPage
                .openPage(CONTACT_NEW)
                .createNewContact(contact);
        contactsListPage.openPage(CONTACTS_PAGE_URL);
        Assert.assertEquals(contactsListPage.getExistContactName(contact.getAccountName()), contact.getAccountName());
        Assert.assertEquals(contactsListPage.getExistPhoneByContactName(contact.getAccountName()), contact.getPhone());
    }
}
