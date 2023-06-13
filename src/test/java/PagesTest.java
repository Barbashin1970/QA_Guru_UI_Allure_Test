import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.BasketPage;
import pageobject.CatalogPage;
public class PagesTest extends Start {

    @Test
    @DisplayName("Check Basket And Go Back To Product Catalog Page Test")
    public void checkBasketAndGoBackToCatalogTest() {
        CatalogPage catalogPage = new CatalogPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        catalogPage.openCatalogPage();
        catalogPage.goToTheBasketPage();
        basketPage.goBackToTheCatalogPage();
        Assert.assertTrue("Product Catalog Page is not displayed", catalogPage.isCatalogPageOpen());
    }
    @Test
    @DisplayName("Check Order Button Go To User Page Test")
    public void checkOrderButtonSendToUserPageTest() {
        CatalogPage catalogPage = new CatalogPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        catalogPage.openCatalogPage().clickBaseCourseButton();
        catalogPage.clickBasketButton();
        basketPage.clickOrderButton();
        Assert.assertTrue("Button GoToNext on User Page Is Not Displayed", catalogPage.isUserDataButtonDisplayed());
    }
}
