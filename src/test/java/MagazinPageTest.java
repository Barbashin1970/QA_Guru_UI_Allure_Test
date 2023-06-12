import data.ChangeBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
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
    @DisplayName("Change Quantity In Product Page And Check Sum Total Test")
    public void changeQuantityInProductPageAndCheckSumTotalTest() {
        MagazinPage magazinPage = new MagazinPage(driver);
        String expectedText = "690.00 DogCoin";
        String newQuantity = "10";
        magazinPage.openMagazinPage().clickBaseCourseButton();
        magazinPage.setNewQuantity(newQuantity);
        magazinPage.clickBasketButton();
        String actualText = magazinPage.getTextOfTotalSum();
        Assert.assertEquals("Sum is not equal to expected", expectedText, actualText);
    }

    @Test
    @DisplayName("Change Quantity In Basket Page And Check Sum Total Test")
    public void changeQuantityInBasketPageAndCheckSumTotalTest() {
        MagazinPage magazinPage = new MagazinPage(driver);
        String expectedText = "690.00 DogCoin";
        String newQuantity = "10";
        magazinPage.openMagazinPage().clickBaseCourseButton();
        magazinPage.setNewQuantity(newQuantity);
        magazinPage.clickBasketButton();
        String actualText = magazinPage.getTextOfTotalSum();
        Assert.assertEquals("Sum is not equal to expected", expectedText, actualText);
    }
    @Test
    @DisplayName("Check Basket And Go Back To Magazin Page Test")
    public void checkBasketAndGoBackToMagazinTest() {
        MagazinPage magazinPage = new MagazinPage(driver);
        magazinPage.openMagazinPage();
        magazinPage.goToTheBasketPage();
        magazinPage.goBackToTheMagazinPage();
        Assert.assertTrue("Magazin Page is not displayed", magazinPage.isMagazinPageOpen());
    }

    @Test
    @DisplayName("Check Order Button Go To User Page Test")
    public void checkOrderButtonGoToUserPageTest() {
        MagazinPage magazinPage = new MagazinPage(driver);
        magazinPage.openMagazinPage().clickBaseCourseButton();
        magazinPage.clickBasketButton();
        magazinPage.clickOrderButton();
        Assert.assertTrue(magazinPage.isUserDataButtonDisplayed());
    }

    @Test
    public void changeQuantityInsideBasketTest() throws InterruptedException {
        MagazinPage magazinPage = new MagazinPage(driver);
        magazinPage.openMagazinPage();
        magazinPage.clickBuyCourseButton();
        magazinPage.setNewQuantityInBasket("22");
        TimeUnit.SECONDS.sleep(5);
    }

    @After
    public void tearDown(){driver.quit();}
}