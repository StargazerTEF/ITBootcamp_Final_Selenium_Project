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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void ChecksInputTypes() {

        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        loginPage.loginWIthAdminCredentials(email, password);
        navPage.waitUntilCurrentUrlContainsHome();
        navPage.clickOnMyProfileButton();
        profilePage.waitUntilLoadDialogBecomesInvisible();
        Assert.assertEquals(profilePage.getEmailInputFieldValueForAttributeType(), "email",
                "Email input field type should have value 'email'.");
        Assert.assertEquals(profilePage.getEmailInputFieldValueForAttributeDisabled(), "disabled",
                "Email input field should have value 'disabled' for attribute 'disabled'.");
        Assert.assertEquals(profilePage.getNameInputFieldValueForAttributeType(), "text",
                "Name input field type should have value 'text'.");
        Assert.assertEquals(profilePage.getCityInputFieldValueForAttributeType(), "text",
                "City input field type should have value 'text'.");
        Assert.assertEquals(profilePage.getCountryInputFieldValueForAttributeType(), "text",
                "Country input field type should have value 'text'.");
        Assert.assertEquals(profilePage.getUrlTwitterInputFieldValueForAttributeType(), "url",
                "Twitter url input field type should have value 'url'.");
        Assert.assertEquals(profilePage.getUrlGitHubInputFieldValueForAttributeType(), "url",
                "Email input field type should have value 'url'.");
        Assert.assertEquals(profilePage.getPhoneInputFieldValueForAttributeType(), "tel",
                "Phone input field type should have value 'tel'.");
        navPage.clickOnLogoutButton();
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void EditProfile() {

        String email = "admin@admin.com";
        String password = "12345";
        String name = "Marko Peric";
        String phone = "+38161283223";
        String city = "Bucaramanga";
        String country = "Spain";
        String twitter = "https://twitter.com/profile/milan1232";
        String github = "https://github.com/";

        navPage.clickOnLoginButton();
        loginPage.loginWIthAdminCredentials(email, password);
        navPage.waitUntilCurrentUrlContainsHome();
        navPage.clickOnMyProfileButton();
        profilePage.waitUntilLoadDialogBecomesInvisible();
        profilePage.inputNewName(name);
        profilePage.inputNewPhone(phone);
        profilePage.inputNewCity(city);
        profilePage.inputNewCountry(country);
        profilePage.inputNewTwitterUrl(twitter);
        profilePage.inputNewGitHubUrl(github);
        profilePage.clickOnSaveButton();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulProfileUpdateIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForSuccessfulProfileUpdate(),
                "Pop up message should contain 'Profile saved successfuly'.");
        Assert.assertEquals(profilePage.getNameInputFieldValue(), name,
                "Name input field should have " + name + " value.");
        Assert.assertEquals(profilePage.getPhoneInputFieldValue(), phone,
                "Phone input field should have " + phone + " value.");
        Assert.assertEquals(profilePage.getCityInputFieldValue(), city,
                "City input field should have " + city + " value.");
        Assert.assertEquals(profilePage.getCountryInputFieldValue(), country,
                "Country input field should have " + country + " value.");
        Assert.assertEquals(profilePage.getTwitterUrlInputFieldValue(), twitter,
                "Twitter url input field should have " + twitter + " value.");
        Assert.assertEquals(profilePage.getGitHubUrlInputFieldValue(), github,
                "GitHub url input field should have " + github + " value.");
        navPage.clickOnLogoutButton();

    }
}
