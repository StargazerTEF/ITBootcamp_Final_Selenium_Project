package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class SignUpTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VisitsTheSignUpPage() {

        navPage.clickOnSignUpButton();
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/signup",
                "Current url should be " + baseUrl + "/signup");

    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void ChecksInputTypes() {

        navPage.clickOnSignUpButton();
        navPage.waitUntilCurrentUrlContainsSignUp();
        Assert.assertEquals(signUpPage.getNameInputFieldValueForAttributeType(), "text",
                "Name input field should have value 'text' for its type");
        Assert.assertEquals(signUpPage.getEmailInputFieldValueForAttributeType(), "email",
                "Email input field should have value 'email' for its type");
        Assert.assertEquals(signUpPage.getPasswordInputFieldValueForAttributeType(), "password",
                "Password input field should have value 'password' for its type");
        Assert.assertEquals(signUpPage.getConfirmPasswordInputFieldValueForAttributeType(), "password",
                "Confirm password input field should have value 'password' for its type");

    }

}
