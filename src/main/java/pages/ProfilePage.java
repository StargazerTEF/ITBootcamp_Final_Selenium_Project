package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getLoadDialog () {
        return driver.findElement(By.className("v-card__text"));
    }
    public void waitUntilLoadDialogBecomesInvisible () {
        wait
                .withMessage("Load dialog should be invisible.")
                .until(ExpectedConditions.invisibilityOf(getLoadDialog()));
    }
    public WebElement getEmailInputField () {
        return driver.findElement(By.id("email"));
    }
    public String getEmailInputFieldValue () {
        return getEmailInputField().getAttribute("value");
    }
    public String getEmailInputFieldValueForAttributeType() {
        return getEmailInputField().getAttribute("type");
    }
    public String getEmailInputFieldValueForAttributeDisabled() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return arguments[0].getAttribute('disabled');", getEmailInputField()).toString();
    }
    public WebElement getNameInputField () {
        return driver.findElement(By.id("name"));
    }
    public String getNameInputFieldValueForAttributeType() {
        return getNameInputField().getAttribute("type");
    }
    public WebElement getCityInputField () {
        return driver.findElement(By.id("city"));
    }
    public String getCityInputFieldValueForAttributeType() {
        return getCityInputField().getAttribute("type");
    }
    public WebElement getCountryInputField () {
        return driver.findElement(By.id("country"));
    }
    public String getCountryInputFieldValueForAttributeType() {
        return getCountryInputField().getAttribute("type");
    }
    public WebElement getUrlTwitterInputField () {
        return driver.findElement(By.id("urlTwitter"));
    }
    public String getUrlTwitterInputFieldValueForAttributeType() {
        return getUrlTwitterInputField().getAttribute("type");
    }
    public WebElement getUrlGitHubInputField () {
        return driver.findElement(By.id("urlGitHub"));
    }
    public String getUrlGitHubInputFieldValueForAttributeType() {
        return getUrlGitHubInputField().getAttribute("type");
    }
    public WebElement getPhoneInputField () {
        return driver.findElement(By.id("phone"));
    }
    public String getPhoneInputFieldValueForAttributeType() {
        return getPhoneInputField().getAttribute("type");
    }
    public void inputNewName (String name) {
        getNameInputField().click();
        getNameInputField().sendKeys(Keys.chord(Keys.CONTROL, "a"), name);
    }
    public void inputNewPhone (String phone) {
        getPhoneInputField().sendKeys(Keys.chord(Keys.CONTROL, "a"), phone);
    }
    public void inputNewCity (String city) {
        getCityInputField().sendKeys(Keys.chord(Keys.CONTROL, "a"), city);
        getCityInputField().sendKeys(Keys.ENTER);
    }
    public void inputNewCountry (String country) {
        getCountryInputField().click();
        getCountryInputField().sendKeys(Keys.chord(Keys.CONTROL, "a"), country);
    }
    public void inputNewTwitterUrl (String twitter) {
        getUrlTwitterInputField().sendKeys(Keys.chord(Keys.CONTROL, "a"), twitter);
    }
    public void inputNewGitHubUrl (String gitHub) {
        getUrlGitHubInputField().sendKeys(Keys.chord(Keys.CONTROL, "a"), gitHub);
    }
    public WebElement getSaveButton () {
        return driver.findElement(By.className("btnSave"));
    }
    public void clickOnSaveButton () {
        getSaveButton().click();
    }
    public String getNameInputFieldValue() {
        return getNameInputField().getAttribute("value");
    }
    public String getPhoneInputFieldValue() {
        return getPhoneInputField().getAttribute("value");
    }
    public String getCityInputFieldValue () {
        return getCityInputField().getAttribute("value");
    }
    public String getCountryInputFieldValue () {
        return getCountryInputField().getAttribute("value");
    }
    public String getTwitterUrlInputFieldValue () {
        return getUrlTwitterInputField().getAttribute("value");
    }
    public String getGitHubUrlInputFieldValue () {
        return getUrlGitHubInputField().getAttribute("value");
    }
}
