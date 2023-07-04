import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.BasketPage;
import pageobject.CatalogPage;

import java.util.concurrent.TimeUnit;

public class ChangeQuantityTest extends Start {
    CatalogPage catalogPage;
    BasketPage basketPage;
    @Test
    @DisplayName("Change Quantity In Product Page And Check Sum Total Test")
    public void changeQuantityInProductPageAndCheckSumTotalTest() {
        catalogPage = new CatalogPage(driver);
        basketPage = new BasketPage(driver);
        String expectedText = "690.00 DogCoin";
        String newQuantity = "10";
        catalogPage.openCatalogPage()
                .clickBaseCourseButton()
                .setNewQuantity(newQuantity)
                .clickBasketButton();
        String actualText = basketPage.getTextOfTotalSum();
        Assert.assertEquals("Sum is not equal to expected", expectedText, actualText);
    }

    @Test
    @DisplayName("Change Quantity To Very Big 100500 Inside Basket Test")
    public void changeQuantityInsideBasketTest() {
        catalogPage = new CatalogPage(driver);
        basketPage = new BasketPage(driver);
        String expectedText = "6934500.00 DogCoin";
        String newQuantity = "100500";
        catalogPage.openCatalogPage()
                   .clickBuyCourseButton();
        basketPage.setNewQuantityInBasketFirst(newQuantity)
                  .updateBasketButtonClick();
        String actualText = basketPage.getTextOfTotalSum();
        Assert.assertEquals("Sum is not equal to expected", expectedText, actualText);
    }

    @Test
    @DisplayName("Put All Products to the Basket and Update Quantity Test")
    public void changeAllProductInTheBasketTest() throws InterruptedException {
        catalogPage = new CatalogPage(driver);
        basketPage = new BasketPage(driver);
        String expectedText = "1867.50 DogCoin";
        catalogPage.openCatalogPage().clickBuyAll();
        basketPage.setNewQuantityInBasketFirst("5")
                .setNewQuantityInBasketSecond("6")
                .setNewQuantityInBasketThird("7")
                .setNewQuantityInBasketForth("8")
                .updateBasketButtonClick();
        String actualText = basketPage.getTextOfTotalSum();
        Assert.assertEquals("Sum is not equal to expected", expectedText, actualText);
        TimeUnit.SECONDS.sleep(5);
    }

}