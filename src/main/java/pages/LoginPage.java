package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getEmailInputField () {
        return driver.findElement(By.id("email"));
    }
    public String getEmailInputFieldValueForAttributeType() {
        return getEmailInputField().getAttribute("type");
    }
    public WebElement getPasswordInputField () {
        return driver.findElement(By.id("password"));
    }
    public String getPasswordInputFieldValueForAttributeType() {
        return getPasswordInputField().getAttribute("type");
    }
}
