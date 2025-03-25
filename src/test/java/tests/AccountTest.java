package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AccountTest extends BaseTest{

    Random random = new Random(50);

    @Test
    public void createAccountTest(){
        Account account = new Account();
        account.setAccountName("Account" + random.nextInt(50));
        account.setWebSite("test.com");
        account.setType("Investor");
        account.setPhone("123456");
        account.setDescription("desc");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(ACCOUNT_NEW)
                .createNewAccount(account);
        accountsListPage.openPage(ACCOUNTS_PAGE_URL);
        Assert.assertEquals(accountsListPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        Assert.assertEquals(accountsListPage.getExistPhoneNumberByAccountName(account.getAccountName()), account.getPhone());
    }
}
