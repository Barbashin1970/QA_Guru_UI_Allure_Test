import data.ChangeBrowser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static data.UniformResourceLocator.CHROME;

public class Start {

    WebDriver driver;

    @Before
    public void startUp() {
        //WebDriver driver = ChangeBrowser.getBrowser(CHROME_WDM);
        driver = ChangeBrowser.getBrowser(CHROME);
        //WebDriver driver = ChangeBrowser.getBrowser(YANDEX);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
