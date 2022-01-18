package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BuscarPage extends BasePage {

    By searchXpath =  By.xpath("//form/div/div/input");
    By searchButtonXpath =  By.xpath("//form/div/div/div/button");
    By productsClass =  By.className("catalogue-product");

    public BuscarPage(WebDriver driver){
        super(driver);
    }

    public void search(){
        sendText(searchXpath, "alexa");
        click(searchButtonXpath);
    }

    public boolean isExistsProduct(){
        return findElements(productsClass).size() > 0;
    }

    public void selectProduct(){
        List<WebElement> products = findElements(productsClass);
        for (WebElement product : products) {
            click(product);
            break;
        }
    }
}
