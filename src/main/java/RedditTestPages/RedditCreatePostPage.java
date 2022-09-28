package RedditTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class RedditCreatePostPage {
    WebDriver driver;
//    From "Create Your First Post" After Community Create
    By PostIcon = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/section/footer/a");  //*[@id="SHORTCUT_FOCUSABLE_DIV"]/div[4]/div/div/section/footer/a
    By TitleBox = By.xpath("//*[@id=\"AppRouter-main-content\"]/div[1]/div/div[2]/div[3]/div[1]/div[2]/div[3]/div[2]/div[1]/div/textarea");
    By TextBox = By.xpath("//*[@id=\"AppRouter-main-content\"]/div[1]/div/div[2]/div[3]/div[1]/div[2]/div[3]/div[2]/div[2]/div/div/div[3]/div/div[1]/div/div/div");
    By OCIcon = By.xpath("//*[@id=\"AppRouter-main-content\"]/div[1]/div/div[2]/div[3]/div[1]/div[2]/div[3]/div[3]/div[1]/div/button[1]");
    By OCIconErr = By.xpath("//*[@id=\"AppRouter-main-content\"]/div[1]/div/div[2]/div[3]/div[1]/div[2]/div[3]/div[3]/div[1]/div/button[3]/div/div");
    By SpoilerIcon = By.xpath("//*[@id=\"AppRouter-main-content\"]/div[1]/div/div[2]/div[3]/div[1]/div[2]/div[3]/div[3]/div[1]/div/button[2]");
    By NSFWIcon = By.xpath("//*[@id=\"AppRouter-main-content\"]/div[1]/div/div[2]/div[3]/div[1]/div[2]/div[3]/div[3]/div[1]/div/button[3]");
    By DraftIcon = By.xpath("//*[@id=\"AppRouter-main-content\"]/div[1]/div/div[2]/div[3]/div[1]/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/button");
    By CreatePostIcon = By.xpath("//*[@id=\"AppRouter-main-content\"]/div[1]/div/div[2]/div[3]/div[1]/div[2]/div[3]/div[3]/div[2]/div/div/div[1]/button");
    public String[] Titles ={"@@","","           ","@#$%^&*<>@#$%^&*@#$%","abcdefghijlmnopfdthf","1234567891234567912","11111111111111111111111111111111111111111555555555555555555555555555555555555555&&&&&&&&&&&&&&&&&&&&&&&&&&&&&gggggggggggggggggggggggggggggggggggssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"};
    public String[] Contents ={"@%","@@@@@@@@@@@@@@@@@@@@","aaaaaaaaaaaaaaaa","2222222222222222","11111111111111111111111111111111111111111555555555555555555555555555555555555555&&&&&&&&&&&&&&&&&&&&&&&&&&&&&gggggggggggggggggggggggggggggggggggsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"};
    public RedditCreatePostPage (WebDriver driver){this.driver= driver;}

    public void enterPostCreation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement PostButton = driver.findElement(PostIcon);
        PostButton.click();
    }

    public void enterPostTitle(String Title){
        WebElement TitleTextBox = driver.findElement(TitleBox);
        TitleTextBox.click();
        TitleTextBox.sendKeys(Title);
    }

    public void enterTextBox(String Content){
        WebElement MainTextBox = driver.findElement(TextBox);
        MainTextBox.click();
        MainTextBox.sendKeys(Content);
//        MainTextBox.clear();
    }

    public void clickOCButton(){
        WebElement OCButton = driver.findElement(OCIcon);
        OCButton.click();
        String OCButtonErr = driver.findElement(OCIconErr).getText();
        assertEquals("This community does not allow original content tag",OCButtonErr);
        System.out.println("Post Creation Error - OC :"+OCButtonErr);
    }

    public void clickSpoilerButton(){
        assertEquals(1,1);
        WebElement SpoilerButton = driver.findElement(SpoilerIcon);
        SpoilerButton.click();
    }

    public void clickNSFWButton(){
        assertEquals(1,1);
        WebElement NSFWButton = driver.findElement(NSFWIcon);
        NSFWButton.click();
    }

    public void saveDraft(){
        assertEquals(1,1);
        WebElement DraftButton = driver.findElement(DraftIcon);
        DraftButton.click();
    }

    public void createPost(){
        assertEquals(1,1);
        WebElement CreatePost = driver.findElement(CreatePostIcon);
        CreatePost.click();
    }
}
