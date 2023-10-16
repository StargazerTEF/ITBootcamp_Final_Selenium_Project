package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{

    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getLanguageMenuButton () {
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public void clickOnLanguageMenuButton () {
        getLanguageMenuButton().click();
    }

    public WebElement getLanguageList () {
        return driver.findElement(By.cssSelector(".menuable__content__active > div"));
    }

    public void waitUntilLanguageListIsVisible () {
        wait
                .withMessage("Language list should be visible.")
                .until(ExpectedConditions.visibilityOf(getLanguageList()));
    }

    public WebElement getEnglishLanguageInMenuList () {
        return driver.findElement(By.cssSelector("span.f-gb"));
    }
    public void clickOnEnglishLanguageInMenuList () {
        getEnglishLanguageInMenuList().click();
    }
    public WebElement getLoginButton () {
        return driver.findElement(By.cssSelector("[href='/login'].btnLogin"));
    }
    public void clickOnLoginButton () {
        getLoginButton().click();
    }
    public String getCurrentUrl () {
        return driver.getCurrentUrl();
    }
}
