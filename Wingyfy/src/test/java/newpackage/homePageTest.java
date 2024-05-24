package newpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import PackageJava.HomePage;
import PackageJava.LoginPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class homePageTest extends BaseTest {

    @Test
    public void testAmountSorting() throws InterruptedException {
        LoginPage loginPage = new PackageJava.LoginPage(driver);
        loginPage.login("validUser", "validPassword");
        Thread.sleep(6000);
        HomePage homePage = new HomePage(driver);
        homePage.clickAmountHeader();

        List<String> sortedAmounts = homePage.getAmountValues();
        List<String> expectedSortedAmounts = new ArrayList<>(sortedAmounts);
        Collections.sort(expectedSortedAmounts);

        Assert.assertEquals(sortedAmounts, expectedSortedAmounts, "Amounts are not sorted correctly.");
    }
}