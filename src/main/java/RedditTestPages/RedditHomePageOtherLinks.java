package RedditTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedditHomePageOtherLinks {
    WebDriver driver;
    By RedditHomeIcon = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[1]/header/div/div[1]/a");
    By UserMenuIcon = By.xpath("//*[@id=\"USER_DROPDOWN_ID\"]");
    By RedditiOSIcon = By.xpath("/html/body/div[5]/div/div/div[3]/a[1]");
    By RedditAndroidIcon = By.xpath("/html/body/div[5]/div/div/div[3]/a[2]");
    By ReRedditIcon = By.xpath("/html/body/div[5]/div/div/div[3]/a[3]");
    By BestCommunitiesIcon = By.xpath("/html/body/div[5]/div/div/div[3]/a[4]");
    By CommunitiesIcon = By.xpath("/html/body/div[5]/div/div/div[3]/a[5]");
    By AboutIcon = By.xpath("/html/body/div[5]/div/div/div[3]/a[6]");
    By BlogIcon = By.xpath("/html/body/div[5]/div/div/div[3]/a[7]");
    By CareersIcon = By.xpath("/html/body/div[5]/div/div/div[3]/a[8]");
    By PressIcon = By.xpath("/html/body/div[5]/div/div/div[3]/a[9]");

    public RedditHomePageOtherLinks(WebDriver driver) {
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

    public void enterRedditiOSPage() {
        WebElement RedditiOSButton = driver.findElement(RedditiOSIcon);
        RedditiOSButton.click();
    }

    public void enterRedditAndroidPage() {
        WebElement RedditAndroidButton = driver.findElement(RedditAndroidIcon);
        RedditAndroidButton.click();
    }

    public void enterReRedditPage() {
        WebElement ReRedditButton = driver.findElement(ReRedditIcon);
        ReRedditButton.click();
    }

    public void enterBestCommunitiesPage() {
        WebElement BestCommunitiesButton = driver.findElement(BestCommunitiesIcon);
        BestCommunitiesButton.click();
    }

    public void enterCommunitiesPage() {
        WebElement CommunitiesButton = driver.findElement(CommunitiesIcon);
        CommunitiesButton.click();
    }

    public void enterAboutPage() {
        WebElement AboutButton = driver.findElement(AboutIcon);
        AboutButton.click();
    }

    public void enterBlogPage() {
        WebElement BlogButton = driver.findElement(BlogIcon);
        BlogButton.click();
    }

    public void enterCareersPage() {
        WebElement CareersButton = driver.findElement(CareersIcon);
        CareersButton.click();
    }

    public void enterPressPage() {
        WebElement PressButton = driver.findElement(PressIcon);
        PressButton.click();
    }
}
