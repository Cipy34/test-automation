package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void SearchOnGoogle() {
        driver = new ChromeDriver();
        driver.get("https://google.com");

        WebElement acceptCookiesButton = driver.findElement(By.id("L2AGLb"));
        acceptCookiesButton.click();

        WebElement SearchInput = driver.findElement(By.name("q"));
        SearchInput.sendKeys("Google Atelierul Digital", Keys.ENTER);

        WebElement ClickOnLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/span/a/h3"));
        ClickOnLink.click();

        WebElement Scroll = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/section[1]/div/div[2]/a"));
        new Actions(driver).scrollToElement(Scroll).perform();
    }
}
