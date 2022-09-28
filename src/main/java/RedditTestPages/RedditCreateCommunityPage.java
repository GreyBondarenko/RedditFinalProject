package RedditTestPages;

import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.AssertJUnit.assertEquals;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class RedditCreateCommunityPage {
    WebDriver driver;
    //from Home page :
    By CommunityIcon = By.xpath("//*[@id=\"create-community-button\"]");//*[@id="create-community-button"]//*[@id="create-community-button"]
    By CommunityName = By.xpath("//*[@id='SHORTCUT_FOCUSABLE_DIV']/div[4]/div/div/div/div/div/div/div[1]/div[2]/input");
    By CommunityTypes = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/div/div/div/div[2]/div[2]/div");
    By CommunityPublic = By.xpath("//*[@id='SHORTCUT_FOCUSABLE_DIV']/div[4]/div/div/div/div/div/div/div[3]/div[2]/div/div[1]");
    By CommunityRestricted = By.xpath("//*[@id='SHORTCUT_FOCUSABLE_DIV']/div[4]/div/div/div/div/div/div/div[3]/div[2]/div/div[2]");
    By CommunityPrivate = By.xpath("//*[@id='SHORTCUT_FOCUSABLE_DIV']/div[4]/div/div/div/div/div/div/div[3]/div[2]/div/div[3]");
    By CommunityNSFW = By.xpath("//*[@id='SHORTCUT_FOCUSABLE_DIV']/div[4]/div/div/div/div/div/div/div[4]/div[2]");  ////*[@id="SHORTCUT_FOCUSABLE_DIV"]/div[4]/div/div/div/div/div/div/div[4]/div[2]/svg
    By CommunityCreate = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/div/div/div/div[4]/button[2]");//*[@id="SHORTCUT_FOCUSABLE_DIV"]/div[4]/div/div/div/div/div/div/div[4]/button[2]
    By CommunityCancel = By.xpath("//*[@id='SHORTCUT_FOCUSABLE_DIV']/div[4]/div/div/div/div/div/div/div[4]/button[1]");
    By CommunityNameErr = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/div/div/div/div[2]");
    By ProfileBoxSkip = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/header/div[1]/div[2]/button"); ////*[@id="SHORTCUT_FOCUSABLE_DIV"]/div[4]/div/div/div/header/div[1]/div[2]/button//
    By ProfileBoxTwo = By.cssSelector("button._3oCL2oMbe3H81mue3bR1CQ");
    By ProfileBoxGender = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/div/div/label[1]/span");
    By ProfileBoxContinue = By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[4]/div/div/div/div[2]/button");   ////*[@id="SHORTCUT_FOCUSABLE_DIV"]/div[4]/div/div/div/div[2]/button
    By ProfileBoxSelect = By.cssSelector("div._2h_rraB53rhUmsB6cnedRY ");   //Selects Elements (Communities)
    public String[] Names = {"", "12", "               ", "^<>!@#$%^&*()!@#$%^&", "abcdefghijlpnmobd", "12345678912345678912", "11111111111111111111111111111111111111111555555555555555555555555555555555555555&&&&&&&&&&&&&&&&&&&&&&&&&&&&&ggggggggggggggggggggggggggggggggggg"};
//    public String[] Types =(CommunityPublic,CommunityRestricted,CommunityPrivate);

    public RedditCreateCommunityPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
    }

    public void killTheDamnBox() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
//        WebElement ProfileBoxElmnt = driver.findElement(ProfileBoxSkip);
//        ProfileBoxElmnt.click();            //Step 1
        WebElement ProfileBoxWoman = driver.findElement(ProfileBoxGender);
        ProfileBoxWoman.click();            //Step 1.1
            Thread.sleep(1000);
        List<WebElement> ProfileBoxElmntTwo = driver.findElements(ProfileBoxTwo);
        ProfileBoxElmntTwo.get(0).click();  //Step 2
        ProfileBoxElmntTwo.get(1).click();  //Step 2
        ProfileBoxElmntTwo.get(2).click();  //Step 2
            Thread.sleep(1000);
        WebElement ProfileBoxElmntThree = driver.findElement(ProfileBoxContinue);
        ProfileBoxElmntThree.click();   //Step 3
        List<WebElement> ProfileBoxElmntForth = driver.findElements(ProfileBoxSelect);
            Thread.sleep(2000);
        ProfileBoxElmntForth.get(0).click();   //Step 4
        ProfileBoxElmntForth.get(1).click();   //Step 4
        ProfileBoxElmntForth.get(2).click();   //Step 4
            Thread.sleep(1000);
        ProfileBoxElmntThree.click();   //Step 5
            Thread.sleep(1000);
            //        ProfileBoxElmnt.click();            //Step 6
        ProfileBoxElmntThree.click();   //Step 6.1
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//              wait(10000);        //Step 7.1
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Step 7
    }

    public void enterCommunityCreation()  {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement CommunityButton = driver.findElement(CommunityIcon);
        CommunityButton.click();
    }
//  TODO: "Sorry, r/() is taken. Try another." error
    public void enterCommunityName(String Name) {
        try {
            Thread.sleep(500);
            WebElement CommunityNameElmnt = driver.findElement(CommunityName);
        CommunityNameElmnt.click();         //Step 1
        CommunityNameElmnt.sendKeys(Name);  //Step 1
            Thread.sleep(500);
        List<WebElement> CommunityType = driver.findElements(CommunityTypes);
        CommunityType.get(0).click();              //Step 2
            Thread.sleep(500);
        String CommunityErr = driver.findElement(CommunityNameErr).getText();                   //Step 3
        assertEquals("Community names must be between 3–21 characters",CommunityErr);  //Step 3
        System.out.println("Signing up Error - Community Name:"+CommunityErr);   //Step 3
            Thread.sleep(500);
        CommunityNameElmnt.clear();         //Step 4
//        WebElement CommunityCreateElmnt = driver.findElement(CommunityCreate);
//        CommunityCreateElmnt.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chooseCommunityType() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement CommunityCreateElmnt = driver.findElement(CommunityCreate);
//        WebElement CommunityCancelElmnt = driver.findElement(CommunityCancel);
        WebElement CommunityTypePublic = driver.findElement(CommunityPublic);
        WebElement CommunityTypeRestricted = driver.findElement(CommunityRestricted);
        WebElement CommunityTypePrivate = driver.findElement(CommunityPrivate);
        try {
            CommunityTypePublic.click();
            Thread.sleep(1500);
            CommunityTypePrivate.click();
            Thread.sleep(1500);
            CommunityTypeRestricted.click();
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void chooseCommunityNSFW() {
        WebElement CommunityNSFWIcon = driver.findElement(CommunityNSFW);
        CommunityNSFWIcon.click();
    }

    public void createCommunity() {
        WebElement CommunityNameIcon = driver.findElement(CommunityName);
        String name = "bot_Invasions00160";
        CommunityNameIcon.sendKeys(name);
        WebElement CommunityCreateIcon = driver.findElement(CommunityCreate);
        CommunityCreateIcon.click();
    }
//    if you are willling to throw it all away... there's always a cancel button
//    public void createCommunity(){
//        WebElement CommunityCancelIcon = driver.findElement(CommunityCancel);
//        CommunityCancelIcon.click();
//    }
}
