import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.BasketPage;
import pageobject.CatalogPage;

import java.util.concurrent.TimeUnit;

public class ChangeQuantityTest extends Start {
    @Test
    @DisplayName("Change Quantity In Product Page And Check Sum Total Test")
    public void changeQuantityInProductPageAndCheckSumTotalTest() {
        CatalogPage catalogPage = new CatalogPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        String expectedText = "690.00 DogCoin";
        String newQuantity = "10";
        catalogPage.openCatalogPage().clickBaseCourseButton();
        catalogPage.setNewQuantity(newQuantity);
        catalogPage.clickBasketButton();
        String actualText = basketPage.getTextOfTotalSum();
        Assert.assertEquals("Sum is not equal to expected", expectedText, actualText);
    }

    @Test
    @DisplayName("Change Quantity To Very Big 100500 Inside Basket Test")
    public void changeQuantityInsideBasketTest() {
        CatalogPage catalogPage = new CatalogPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        String expectedText = "6934500.00 DogCoin";
        String newQuantity = "100500";
        catalogPage.openCatalogPage();
        catalogPage.clickBuyCourseButton();
        basketPage.setNewQuantityInBasketFirst(newQuantity);
        basketPage.updateBasketButtonClick();
        String actualText = basketPage.getTextOfTotalSum();
        Assert.assertEquals("Sum is not equal to expected", expectedText, actualText);
    }

    @Test
    @DisplayName("Put All Products to the Basket and Update Quantity Test")
    public void changeAllProductInTheBasketTest() throws InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        String expectedText = "1867.50 DogCoin";
        catalogPage.openCatalogPage().clickBuyAll();
        basketPage.setNewQuantityInBasketFirst("5");
        basketPage.setNewQuantityInBasketSecond("6");
        basketPage.setNewQuantityInBasketThird("7");
        basketPage.setNewQuantityInBasketForth("8");
        basketPage.updateBasketButtonClick();
        String actualText = basketPage.getTextOfTotalSum();
        Assert.assertEquals("Sum is not equal to expected", expectedText, actualText);
        TimeUnit.SECONDS.sleep(5);
    }

}