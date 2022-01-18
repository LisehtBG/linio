package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.BuscarPage;

public class LinioTest {
    public WebDriver driver;
    public BasePage basePage;
    public BuscarPage buscarPage;

    @Before
    public void setUp() {
        basePage = new BasePage();
        driver = basePage.configDriver();
        buscarPage = new BuscarPage(driver);

        basePage.open("https://www.linio.com.pe/");
    }

    @Test
    public void searchProduct() {
        try {
            buscarPage.search();
            Assert.assertTrue(buscarPage.isExistsProduct());
            buscarPage.selectProduct();
        } catch (Exception e) {
            System.out.println("ocurrió un error");
        }
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(30000);
            driver.quit();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
