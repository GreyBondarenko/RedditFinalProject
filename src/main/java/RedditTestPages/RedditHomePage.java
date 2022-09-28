package RedditTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class RedditHomePage {
    WebDriver driver;
    //    By Header=By.xpath("//h1");
//    By RedditHomeIcon=By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[1]/header/div/div[1]/a");
    By TrendingPostsContainer = By.cssSelector("div.cslJXYWf-T5weuzAPoO3X");
    By TrendingPostsContainerChildren = By.cssSelector("div.cslJXYWf-T5weuzAPoO3X>*");
    By HomeIcon = By.cssSelector("a._30BbATRhFv3V83DHNDjJAO");
    By SignUpIcon = By.cssSelector("a[href='https://www.reddit.com/register/?dest=https%3A%2F%2Fwww.reddit.com%2F']");

    public RedditHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkCarouselHasChildren() {
        WebElement Carousel = driver.findElement(TrendingPostsContainer);
        WebElement CarouselChildren = driver.findElement(TrendingPostsContainerChildren);
        assertNotNull(CarouselChildren);
//        for (int i = 0; i < CarouselChildren.size(); i++) {
//            System.out.println(CarouselChildren.get(i).getText());
    }

    public void signingUp() {
        WebElement HomeButton = driver.findElement(HomeIcon);
        WebElement SignUpButton = driver.findElement(SignUpIcon);
        driver.get(SignUpButton.getAttribute("href"));

    }
}
