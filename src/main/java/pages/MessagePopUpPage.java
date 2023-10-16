package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getPopUpMessageForInvalidLogin () {
        return driver.findElement(By.cssSelector(".v-snack__content ul li"));
    }

    public void waitUntilPopUpMessageForInvalidLoginIsVisible () {
        wait
                .withMessage("Pop-up message for invalid login should be visible.")
                .until(ExpectedConditions.visibilityOf(getPopUpMessageForInvalidLogin()));
    }

    public String getTextFromPopUpMessageForInvalidLogin () {
        return getPopUpMessageForInvalidLogin().getText();
    }
}
