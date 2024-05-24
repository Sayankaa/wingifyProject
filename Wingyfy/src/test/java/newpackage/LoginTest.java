package newpackage;
import org.testng.Assert;
import org.testng.annotations.Test;

import PackageJava.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("validUser", "validPassword");

        String expectedUrl = "https://sakshingp.github.io/assignment/home.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Thread.sleep(6000);
    }

    @Test
    public void testEmptyUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "validPassword");
        Thread.sleep(6000);

        // Assuming there's an error message or staying on login page
        Assert.assertTrue(driver.getCurrentUrl().contains("login.html"));
    }

    @Test
    public void testEmptyPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("validUser", "");
        Thread.sleep(6000);

        // Assuming there's an error message or staying on login page
        Assert.assertTrue(driver.getCurrentUrl().contains("login.html"));
    }

    @Test
    public void testEmptyUsernameAndPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        Thread.sleep(6000);

        // Assuming there's an error message or staying on login page
        Assert.assertTrue(driver.getCurrentUrl().contains("login.html"));
    }
}