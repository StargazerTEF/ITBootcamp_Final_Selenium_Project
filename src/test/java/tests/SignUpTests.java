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
}
