package RedditTestPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertEquals;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;




public class RedditSignUpPage {
    WebDriver driver;
    By Header = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/h1");
    By UserName = By.xpath("//*[@id=\"regUsername\"]");
    By PassWord = By.xpath("//*[@id=\"regPassword\"]");
    By EmailAddress = By.xpath("//*[@id=\"regEmail\"]");
    By EmailError = By.xpath("/html/body/div[1]/main/div[1]/div/div[2]/form/fieldset[1]/div");
    By UsernameError = By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div[1]/form/fieldset[1]/div");
    By PasswordError = By.xpath("//*[@id=\"registerPasswordField\"]/div[2]");
    By FirstContinueIcon = By.xpath("/html/body/div/main/div[1]/div/div[2]/form/fieldset[2]/button");
    By FirstBackIcon = By.xpath("/html/body/div/main/div[2]/div/div/div[3]/a");
//    By SecondContinueIcon = By.cssSelector("[type='submit'].AnimatedForm__submitButton.m-full-width");
    By Suggestion = By.cssSelector("a.Onboarding__usernameSuggestion");
    By FinishSigningUp = By.xpath("/html/body/div[1]/main/div[2]/div/div/div[3]/button");
    public String[] Emails = {"", "           ", "maximbondarenko98@gmai.com", "maximbondarenko99@gmail.com"};
    public String[] Emails1 = {"123465789", "abcdefghij", "h", "8", "@#$%^&*"};
    public String[] Passwords = {"", "           ", "12345", "abcdefg", "1", "a", "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
    public String[] Usernames = {"", "          ", "12345678912345678912", "abcdefghijklmnop", "a", "1", "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};

    public RedditSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkHeader() {
        String getHeaderText = driver.findElement(Header).getText();
        assertEquals(getHeaderText, "Sign up");
        System.out.println(getHeaderText);
    }

    public void enterEmailAddress(String Email) {
        WebElement MailAddress = driver.findElement(EmailAddress);
        MailAddress.sendKeys(Email);
        WebElement ContinueButton = driver.findElement(FirstContinueIcon);
        ContinueButton.click();
        WebElement BackButton = driver.findElement(FirstBackIcon);
        BackButton.click();
        MailAddress.clear();
    }

    public void enterEmailAddressScnd() {
        WebElement BackButton = driver.findElement(FirstBackIcon);
        BackButton.click();
        WebElement MailAddress = driver.findElement(EmailAddress);
        MailAddress.clear();
    }
    public void continuedangit(){
        WebElement ContinueButton = driver.findElement(FirstContinueIcon);
        ContinueButton.click();}

//    Choosing from an array of usernames
    public void chooseUsername(String Username) {
        WebElement UsernameBox = driver.findElement(UserName);
        UsernameBox.sendKeys(Username);
        WebElement ScndContinueButton = driver.findElement(FinishSigningUp);
        ScndContinueButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String UsernameErr = driver.findElement(UsernameError).getText();
        assertEquals("Username must be between 3 and 20 characters",UsernameErr);

        System.out.println("Signing up Error - Username:"+UsernameErr);
        UsernameBox.clear();
    }

//    Choosing from an array of Passwords
    public void choosePassword(String Password) {
        WebElement password = driver.findElement(PassWord);
        password.sendKeys(Password);
        WebElement ScndContinueButton = driver.findElement(FinishSigningUp);
        ScndContinueButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String PasswordErr = driver.findElement(PasswordError).getText();
        assertEquals("Password must be at least 8 characters long",PasswordErr);
        System.out.println("Signing up Error - Password:"+PasswordErr);
        password.clear();
    }

    public void suggestUsername() {
        WebElement suggestUsernameelement = driver.findElement(Suggestion);
        suggestUsernameelement.click();
        WebElement suggestPassword = driver.findElement(PassWord);
        suggestPassword.sendKeys("123456k2345hg");
        WebElement FinishSignUp = driver.findElement(FinishSigningUp);
//        Scanner scanner = new Scanner("waiting for console input");
//        scanner.nextLine();
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        FinishSignUp.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create-community-button\"]")));
    }
}
