import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.BasketPage;
import pageobject.CatalogPage;
public class PagesTest extends Start {
    CatalogPage catalogPage = new CatalogPage(driver);
    BasketPage basketPage = new BasketPage(driver);
    @Test
    @DisplayName("Check Basket Page Button And Go Back To Product Catalog Page Test")
    public void checkBasketAndGoBackToCatalogTest() {

        catalogPage.openCatalogPage()
                   .goToTheBasketPage();
        basketPage.goBackToTheCatalogPage();
        Assert.assertTrue("Product Catalog Page is not displayed", catalogPage.isCatalogPageOpen());
    }
    @Test
    @DisplayName("Check Order Button Go To User Page Test")
    public void checkOrderButtonSendToUserPageTest() {

        catalogPage.openCatalogPage()
                   .clickBaseCourseButton()
                   .clickBasketButton();
        basketPage.clickOrderButton();
        Assert.assertTrue("Button GoToNext on User Page Is Not Displayed", catalogPage.isUserDataButtonDisplayed());
    }
}
