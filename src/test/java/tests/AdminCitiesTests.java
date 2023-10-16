package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VisitsTheAdminCitiesPage() {

        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        navPage.waitUntilCurrentUrlContainsLogin();
        loginPage.fillInEmailInputField(email);
        loginPage.fillInPasswordInputField(password);
        loginPage.clickOnLoginButton();
        navPage.clickOnAdminButton();
        navPage.waitUntilAdminListIsVisible();
        navPage.clickOnAdminCitiesFromAdminLIst();
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/admin/cities",
                "Current url should be " + baseUrl + "/admin/cities");

    }
}
