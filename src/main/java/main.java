import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Maxim\\Desktop\\HackerU\\chromedriver.exe");
        options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
        options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
        // options.addArguments("--headless"); // only if you are ACTUALLY running headless
        options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
        options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.reddit.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/header/div/div[2]/div/div[1]/a[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        driver.findElement(By.xpath("/html/body/div/main/div[1]/div/div[2]/form/fieldset[1]/input[2]")).sendKeys("DEng");
        driver.findElement(By.tagName("input[2]")).sendKeys("fuck");
        driver.findElement(By.className("AnimatedForm__textInput ")).sendKeys("you");
        driver.findElement(By.id("regEmail")).sendKeys("damnit");
       // driver.findElement(By.id("regEmail")).sendKeys();
        //driver.findElement(By.className("AnimatedForm__submitButton m-full-width")).click();
        //<input id="regEmail" class="AnimatedForm__textInput " type="text" name="email" placeholder="
        //Email
        //" data-empty="true">
//driver.close();
    }
}
