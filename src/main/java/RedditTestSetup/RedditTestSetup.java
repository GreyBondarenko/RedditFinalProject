package RedditTestSetup;

import RedditTestPages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// Delcarations
// Constructor
// Functions

public class RedditTestSetup { //<- class scope

    // Delcarations
    WebDriver driver;

    RedditHomePage ObjRedditHomePage;
    RedditSignUpPage OBJRedditSignUpPage;
    //    RedditSignUpGoogle OBJRedditSignUpGoogle;
//    RedditSignUpApple OBJRedditSignUpApple;
    RedditCreateCommunityPage OBJRedditCreateCommunityPage;
    RedditCreatePostPage OBJRedditCreatePostPage;
    RedditHelpPage OBJRedditHelpPage;
    RedditHomePageOtherLinks OBJRedditHomePageOtherLinks;
    @Parameters ({"browser"})
    @BeforeTest
    public void redditTestSetup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maxim\\Desktop\\HackerU\\chromedriver.exe");
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            // options.addArguments("--headless"); // only if you are ACTUALLY running headless
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            driver.get("https://www.reddit.com/");
        }
        if (browser.equalsIgnoreCase("FF")){
            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().driverVersion("0.31.0").setup();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maxim\\Desktop\\HackerU\\chromedriver.exe");
//            options.addArguments("start-maximized");
//            options.addArguments("enable-automation");
//            // options.addArguments("--headless"); // only if you are ACTUALLY running headless
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--disable-browser-side-navigation");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--port 58660");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            driver.get("https://www.reddit.com/");
        }
    }
    @Test(priority = 0)
    public void home_page_test() {
        ObjRedditHomePage = new RedditHomePage(driver);
//        ObjRedditHomePage.checkCarouselHasChildren();
    }

    @Test(priority = 1)
    public void signing_up_process() {
        ObjRedditHomePage.signingUp();
    }

    @Test(priority = 2)
    public void signing_up() {
        OBJRedditSignUpPage = new RedditSignUpPage(driver);
        for (int i = 0; i < OBJRedditSignUpPage.Emails.length; i++) {
            OBJRedditSignUpPage.enterEmailAddress(OBJRedditSignUpPage.Emails[i]);
        }
    }

    @Test(priority = 3)
    public void continue_to_scnd() {
        OBJRedditSignUpPage.continuedangit();
    }

    @Test(priority = 4)
    public void signing_up_scnd() {
        for (int i = 0; i < OBJRedditSignUpPage.Usernames.length; i++) {
            OBJRedditSignUpPage.chooseUsername(OBJRedditSignUpPage.Usernames[i]);
        }
    }

    @Test(priority = 5)
    public void signing_up_thrd() {
        for (int i = 0; i < OBJRedditSignUpPage.Passwords.length; i++) {
            OBJRedditSignUpPage.choosePassword(OBJRedditSignUpPage.Passwords[i]);
        }
    }

    @Test(priority = 6)
    public void signing_up_frth() {
        OBJRedditSignUpPage.suggestUsername();

    }


    @Test(priority = 7)
    public void community_creation_process() throws InterruptedException {
        OBJRedditCreateCommunityPage = new RedditCreateCommunityPage(driver);
//        TODO:try to do with ONLY visible element
        OBJRedditCreateCommunityPage.killTheDamnBox();
        OBJRedditCreateCommunityPage.enterCommunityCreation();

    }

    @Test(priority = 8)
    public void community_creation_name() {
        for (int i = 0; i < OBJRedditCreateCommunityPage.Names.length; i++) {
            OBJRedditCreateCommunityPage.enterCommunityName(OBJRedditCreateCommunityPage.Names[i]);
        }
    }
//TODO : Test 8 nullifies Test 9
    @Test(priority = 9)
    public void community_creation_type() {
        OBJRedditCreateCommunityPage.chooseCommunityType();
    }

    @Test(priority = 10)
    public void community_creation_nsfw() {
        OBJRedditCreateCommunityPage.chooseCommunityNSFW();
    }

    @Test(priority = 11)
    public void community_creation_end() {
        OBJRedditCreateCommunityPage.createCommunity();
    }

    @Test(priority = 12)
    public void post_creation_process() {
        OBJRedditCreatePostPage = new RedditCreatePostPage(driver);
        OBJRedditCreatePostPage.enterPostCreation();
    }


    @Test(priority = 13)
    public void post_creation_title() {
        for (int i = 0; i < OBJRedditCreatePostPage.Titles.length; i++) {
            OBJRedditCreatePostPage.enterPostTitle(OBJRedditCreatePostPage.Titles[i]);
        }
    }

    @Test(priority = 14)
    public void post_creation_textbox() {
        for (int i = 0; i < OBJRedditCreatePostPage.Contents.length; i++) {
            OBJRedditCreatePostPage.enterTextBox(OBJRedditCreatePostPage.Contents[i]);
        }
    }

    @Test(priority = 15)
    public void post_creation_oc() {
        OBJRedditCreatePostPage.clickOCButton();
    }

    @Test(priority = 16)
    public void post_creation_spoiler() {
        OBJRedditCreatePostPage.clickSpoilerButton();
    }

    @Test(priority = 17)
    public void post_creation_nsfw() {
        OBJRedditCreatePostPage.clickNSFWButton();
    }

    @Test(priority = 18)
    public void post_creation_draft() {
        OBJRedditCreatePostPage.saveDraft();
    }

    @Test(priority = 19)
    public void post_creation_end() {
        OBJRedditCreatePostPage.createPost();
    }

    @Test(priority = 20)
    public void help_page_links() {
        OBJRedditHelpPage.goToHomePage();
    }

    @Test(priority = 21)
    public void help_page_links_frst() {
        OBJRedditHelpPage.openUserMenu();
    }

    @Test(priority = 22)
    public void help_page_links_scnd() {
        OBJRedditHelpPage.enterHelpPage();
    }

    @Test(priority = 23)
    public void help_page_links_thrd() {
        OBJRedditHelpPage.enterAccountStatusPage();
    }

    @Test(priority = 24)
    public void help_page_links_frth() {
        OBJRedditHelpPage.enterReddit101Page();
    }

    @Test(priority = 25)
    public void help_page_links_ffth() {
        OBJRedditHelpPage.enterRedditExpPage();
    }

    @Test(priority = 26)
    public void help_page_links_sxth() {
        OBJRedditHelpPage.enterRulesPage();
    }

    @Test(priority = 27)
    public void help_page_links_svnth() {
        OBJRedditHelpPage.enterPrivacyPage();
    }

    @Test(priority = 28)
    public void help_page_links_eght() {
        OBJRedditHelpPage.enterRedditAppsPage();
    }

    @Test(priority = 29)
    public void other_links() {
        OBJRedditHomePageOtherLinks.goToHomePage();
    }

    @Test(priority = 30)
    public void other_links_frst() {
        OBJRedditHomePageOtherLinks.openUserMenu();
    }

    @Test(priority = 31)
    public void other_links_scnd() {
        OBJRedditHomePageOtherLinks.enterRedditiOSPage();
    }

    @Test(priority = 32)
    public void other_links_thrd() {
        OBJRedditHomePageOtherLinks.enterRedditAndroidPage();
    }

    @Test(priority = 33)
    public void other_links_frth() {
        OBJRedditHomePageOtherLinks.enterReRedditPage();
    }

    @Test(priority = 34)
    public void other_links_ffth() {
        OBJRedditHomePageOtherLinks.enterBestCommunitiesPage();
    }

    @Test(priority = 35)
    public void other_links_svnth() {
        OBJRedditHomePageOtherLinks.enterCommunitiesPage();
    }

    @Test(priority = 36)
    public void other_links_eght() {
        OBJRedditHomePageOtherLinks.enterAboutPage();
    }

    @Test(priority = 37)
    public void other_links_nnth() {
        OBJRedditHomePageOtherLinks.enterBlogPage();
    }

    @Test(priority = 38)
    public void other_links_tnth() {
        OBJRedditHomePageOtherLinks.enterCareersPage();
    }

    @Test(priority = 39)
    public void other_links_elnvth() {
        OBJRedditHomePageOtherLinks.enterPressPage();
    }

    @AfterTest
    public void end_of_Test(){driver.quit();}
}