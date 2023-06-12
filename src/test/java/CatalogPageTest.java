import data.ChangeBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.BasketPage;
import pageobject.CatalogPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static data.UniformResourceLocator.*;

public class CatalogPageTest {
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
        CatalogPage catalogPage = new CatalogPage(driver);
        String expectedText = "690.00 DogCoin";
        String newQuantity = "10";
        catalogPage.openMagazinPage().clickBaseCourseButton();
        catalogPage.setNewQuantity(newQuantity);
        catalogPage.clickBasketButton();
        String actualText = catalogPage.getTextOfTotalSum();
        Assert.assertEquals("Sum is not equal to expected", expectedText, actualText);
    }
    @Test
    @DisplayName("Check Basket And Go Back To Product Catalog Page Test")
    public void checkBasketAndGoBackToCatalogTest() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openMagazinPage();
        catalogPage.goToTheBasketPage();
        catalogPage.goBackToTheMagazinPage();
        Assert.assertTrue("Product Catalog Page is not displayed", catalogPage.isCatalogPageOpen());
    }

    @Test
    @DisplayName("Check Order Button Go To User Page Test")
    public void checkOrderButtonSendToUserPageTest() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openMagazinPage().clickBaseCourseButton();
        catalogPage.clickBasketButton();
        catalogPage.clickOrderButton();
        Assert.assertTrue("Button GoToNext on User Page Is Not Displayed", catalogPage.isUserDataButtonDisplayed());
    }

    @Test
    @DisplayName("Change Quantity Inside Basket Test")
    public void changeQuantityInsideBasketTest() {
        CatalogPage catalogPage = new CatalogPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        String expectedText = "6934500.00 DogCoin";
        String newQuantity = "100500";
        catalogPage.openMagazinPage();
        catalogPage.clickBuyCourseButton();
        catalogPage.setNewQuantityInBasketFirst(newQuantity);
        catalogPage.updateBasketButtonClick();
        String actualText = catalogPage.getTextOfTotalSum();
        Assert.assertEquals("Sum is not equal to expected", expectedText, actualText);
    }

    @DisplayName("Change Test")
    public void changeTest() throws InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver);
        BasketPage basketPage = new BasketPage(driver);

        TimeUnit.SECONDS.sleep(5);
    }
    @After
    public void tearDown(){driver.quit();}
}