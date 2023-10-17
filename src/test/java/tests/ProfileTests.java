package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class ProfileTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VisitsTheProfilePage() {

        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        loginPage.loginWIthAdminCredentials(email, password);
        navPage.waitUntilCurrentUrlContainsHome();
        driver.navigate().to(baseUrl + "/profile");
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/profile",
                "Current url should be " + baseUrl + "/profile");
        profilePage.waitUntilLoadDialogBecomesInvisible();
        Assert.assertEquals(profilePage.getEmailInputFieldValue(), "admin@admin.com",
                "Email input field should have value 'admin@admin.com'.");
        navPage.clickOnLogoutButton();

    }
}
