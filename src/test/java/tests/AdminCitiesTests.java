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
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void ChecksInputTypesForCreateOrEditNewCity() {

        navPage.clickOnAdminButton();
        navPage.waitUntilAdminListIsVisible();
        navPage.clickOnAdminCitiesFromAdminLIst();
        navPage.waitUntilCurrentUrlContainsAdminCities();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitUntilPopUpMessageForAddOrEditCityIsVisible();
        Assert.assertEquals(citiesPage.getNameInputFieldValueForAttributeType(), "text",
                "Name input field should have value 'text' for its type");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void CreateNewCity() {

        String cityName = "Marko Peric's city";

        navPage.clickOnAdminButton();
        navPage.waitUntilAdminListIsVisible();
        navPage.clickOnAdminCitiesFromAdminLIst();
        navPage.waitUntilCurrentUrlContainsAdminCities();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitUntilPopUpMessageForAddOrEditCityIsVisible();
        citiesPage.fillInNameInputField(cityName);
        citiesPage.clickOnSaveButton();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulAddOrEditCityIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForSuccessfulAddOrEditCity(),
                "Pop up message should contain text 'Saved successfully'.");

    }
}
