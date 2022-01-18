package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private WebDriver driver;

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver configDriver(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public void sendText(By locator, String text){
        findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        findElement(locator).click();
    }

    public void click(WebElement element){
        element.click();
    }

    public void open(String url){
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
}
