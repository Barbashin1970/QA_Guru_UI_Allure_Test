import data.ChangeBrowser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.MagazinPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static data.UniformResourceLocator.*;

public class MagazinPageTest {
    WebDriver driver;

    @Before
    public void startUp() {
        //WebDriver driver = ChangeBrowser.getBrowser(CHROME_WDM);
        driver = ChangeBrowser.getBrowser(CHROME);
        //WebDriver driver = ChangeBrowser.getBrowser(YANDEX);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void changeQuantityTest() {
        MagazinPage magazinPage = new MagazinPage(driver);
        magazinPage.openMagazinPage().clickBaseCourseButton();
        magazinPage.clickQuantityButton();
        magazinPage.clickBasketButton();
    }
    @Test
    public void checkBasketPageTest() throws InterruptedException {
        MagazinPage magazinPage = new MagazinPage(driver);
        magazinPage.openMagazinPage();
        magazinPage.goToTheBasketPage();
        magazinPage.goBackToTheMagazinPage();
        magazinPage.goToTheBasketPage();
        TimeUnit.SECONDS.sleep(5);
    }

    @After
    public void tearDown(){driver.quit();}
}