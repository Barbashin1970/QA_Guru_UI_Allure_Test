import data.ChangeBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.ProductCatalogPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static data.UniformResourceLocator.*;

public class ProductCatalogPageTest {
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
    @DisplayName("Change Quantity In Product Page And Check Sum Total Test")
    public void changeQuantityInProductPageAndCheckSumTotalTest() {
        ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
        String expectedText = "690.00 DogCoin";
        String newQuantity = "10";
        productCatalogPage.openMagazinPage().clickBaseCourseButton();
        productCatalogPage.setNewQuantity(newQuantity);
        productCatalogPage.clickBasketButton();
        String actualText = productCatalogPage.getTextOfTotalSum();
        Assert.assertEquals("Sum is not equal to expected", expectedText, actualText);
    }
    @Test
    @DisplayName("Check Basket And Go Back To Magazin Page Test")
    public void checkBasketAndGoBackToMagazinTest() {
        ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
        productCatalogPage.openMagazinPage();
        productCatalogPage.goToTheBasketPage();
        productCatalogPage.goBackToTheMagazinPage();
        Assert.assertTrue("Magazin Page is not displayed", productCatalogPage.isMagazinPageOpen());
    }

    @Test
    @DisplayName("Check Order Button Go To User Page Test")
    public void checkOrderButtonSendToUserPageTest() {
        ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
        productCatalogPage.openMagazinPage().clickBaseCourseButton();
        productCatalogPage.clickBasketButton();
        productCatalogPage.clickOrderButton();
        Assert.assertTrue("Button GoToNext on User Page Is Not Displayed", productCatalogPage.isUserDataButtonDisplayed());
    }

    @Test
    @DisplayName("Change Quantity Inside Basket Test")
    public void changeQuantityInsideBasketTest() throws InterruptedException {
        ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
        productCatalogPage.openMagazinPage();
        productCatalogPage.clickBuyCourseButton();
        productCatalogPage.setNewQuantityInBasket("22");
        TimeUnit.SECONDS.sleep(5);
    }

    @After
    public void tearDown(){driver.quit();}
}