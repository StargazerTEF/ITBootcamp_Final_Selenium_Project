package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VisitsTheLoginPage() {

        navPage.clickOnLanguageMenuButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnEnglishLanguageInMenuList();
        navPage.clickOnLoginButton();
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");

    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void ChecksInputTypes() {

        navPage.clickOnLoginButton();
        navPage.waitUntilCurrentUrlContainsLogin();
        Assert.assertEquals(loginPage.getEmailInputFieldValueForAttributeType(), "email",
                "Email input field should have value 'email' for its type");
        Assert.assertEquals(loginPage.getPasswordInputFieldValueForAttributeType(), "password",
                "Password input field should have value 'password' for its type");

    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void DisplaysErrorWhenUserDoesNotExist() {

        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.clickOnLoginButton();
        loginPage.fillInEmailInputField(email);
        loginPage.fillInPasswordInputField(password);
        loginPage.clickOnLoginButton();
        messagePopUpPage.waitUntilPopUpMessageForInvalidLoginIsVisible();
        Assert.assertEquals(messagePopUpPage.getTextFromPopUpMessageForInvalidLogin(), "User does not exists",
                "Error message should be 'User does not exists'.");
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");

    }
}
