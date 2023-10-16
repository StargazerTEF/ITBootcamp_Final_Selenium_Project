package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AuthRoutesTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void ForbidsVisitsToHomeUrlIfNotAuthenticated() {

        driver.navigate().to(baseUrl + "/home");
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");

    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void ForbidsVisitsToProfileUrlIfNotAuthenticated() {

        driver.navigate().to(baseUrl + "/profile");
        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/login",
                "Current url should be " + baseUrl + "/login");
    }
}
