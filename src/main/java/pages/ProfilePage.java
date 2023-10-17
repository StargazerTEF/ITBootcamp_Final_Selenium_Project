package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}
