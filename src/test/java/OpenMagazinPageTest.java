import data.ChangeBrowser;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.MagazinPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static data.UniformResourceLocator.*;


public class OpenMagazinPageTest {
    @Test
    public void newTest() throws InterruptedException {
        //WebDriver driver = ChangeBrowser.getBrowser(CHROME_WDM);
        WebDriver driver = ChangeBrowser.getBrowser(CHROME);
        //WebDriver driver = ChangeBrowser.getBrowser(YANDEX);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        MagazinPage magazinPage = new MagazinPage(driver);
        magazinPage.openMagazinPage()
                .clickBaseCourseButton();

        magazinPage.clickQuantityButton();
        magazinPage.clickBasketButton();


        TimeUnit.SECONDS.sleep(5);
        driver.quit();
    }
}