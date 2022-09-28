package RedditTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedditHelpPage {
    WebDriver driver;
    By RedditHomeIcon = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[1]/header/div/div[1]/a");
    By UserMenuIcon = By.xpath("//*[@id=\"USER_DROPDOWN_ID\"]");
    By HelpPageIcon = By.xpath("/html/body/div[5]/div/div/a[5]/span/span[2]");
    By AccountStatusIcon = By.xpath("/html/body/main/div/section[1]/section[1]/ul/li[1]/a");
    By Reddit101Icon = By.xpath("/html/body/main/div/section[1]/section[1]/ul/li[2]/a");
    By RedditExpIcon = By.xpath("/html/body/main/div/section[1]/section[1]/ul/li[3]/a");
    By RulesIcon = By.xpath("/html/body/main/div/section[1]/section[1]/ul/li[4]/a");
    By PrivacyIcon = By.xpath("/html/body/main/div/section[1]/section[1]/ul/li[5]/a");
    By RedditAppsIcon = By.xpath("/html/body/main/div/section[1]/section[1]/ul/li[6]/a");

    public RedditHelpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        WebElement HomeButton = driver.findElement(RedditHomeIcon);
        HomeButton.click();
    }

    public void openUserMenu() {
        WebElement UserMenu = driver.findElement(UserMenuIcon);
        UserMenu.click();
    }

    public void enterHelpPage() {
        WebElement HelpButton = driver.findElement(HelpPageIcon);
        HelpButton.click();
    }

    public void enterAccountStatusPage() {
        WebElement AccountStatusButton = driver.findElement(AccountStatusIcon);
        AccountStatusButton.click();
        driver.navigate().back();
    }

    public void enterReddit101Page() {
        WebElement Reddit101Button = driver.findElement(Reddit101Icon);
        Reddit101Button.click();
        driver.navigate().back();
    }

    public void enterRedditExpPage() {
        WebElement RedditExpButton = driver.findElement(RedditExpIcon);
        RedditExpButton.click();
        driver.navigate().back();
    }

    public void enterRulesPage() {
        WebElement RulesButton = driver.findElement(RulesIcon);
        RulesButton.click();
        driver.navigate().back();
    }

    public void enterPrivacyPage() {
        WebElement PrivacyButton = driver.findElement(PrivacyIcon);
        PrivacyButton.click();
        driver.navigate().back();
    }

    public void enterRedditAppsPage() {
        WebElement RedditAppsButton = driver.findElement(RedditAppsIcon);
        RedditAppsButton.click();
        driver.navigate().back();
    }
}
