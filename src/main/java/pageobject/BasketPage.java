package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage {

    private static final By goBackToCatalogPage = By.xpath("//a[@href='/index.php/magazin' and @class='btn btn-arrow-left']");
    private static final By valueTotal = By.xpath(" //td[@class='value']");
    private static final By orderButton = By.xpath("//a[@class='btn btn-arrow-right']");
    private static final By updateBasketButton = By.xpath("//img[@src='https://qahacking.guru/components/com_jshopping/images/reload.png']");
    private static final By quantityInBasketFirstLine = By.xpath("//input[@name='quantity[0]']");
    private static final By quantityInBasketSecondLine = By.xpath("//input[@name='quantity[1]']");

    private static final By quantityInBasketThirdLine = By.xpath("//input[@name='quantity[2]']");
    private static final By quantityInBasketForthLine = By.xpath("//input[@name='quantity[3]']");
    private final WebDriver driver;
    private WebElement element;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Go back to the Catalog Page")
    public void goBackToTheCatalogPage() {
        element = driver.findElement(goBackToCatalogPage);
        element.isDisplayed();
        element.click();
    }

    @Step("Get text of total sum in basket")
    public String getTextOfTotalSum() {
        return driver.findElement(valueTotal).getText();
    }

    @Step("Set new quantity inside Basket Page for the 1 Product")
    public BasketPage setNewQuantityInBasketFirst(String quant) {
        element = driver.findElement(quantityInBasketFirstLine);
        element.click();
        element.clear();
        element.sendKeys(quant);
        return this;
    }

    @Step("Set new quantity inside Basket Page for the 2 Product")
    public BasketPage setNewQuantityInBasketSecond(String quant) {
        element = driver.findElement(quantityInBasketSecondLine);
        element.click();
        element.clear();
        element.sendKeys(quant);
        return this;
    }

    @Step("Set new quantity inside Basket Page for the 3 Product")
    public BasketPage setNewQuantityInBasketThird(String quant) {
        element = driver.findElement(quantityInBasketThirdLine);
        element.click();
        element.clear();
        element.sendKeys(quant);
        return this;
    }
    @Step("Set new quantity inside Basket Page for the 4 Product")
    public BasketPage setNewQuantityInBasketForth(String quant) {
        element = driver.findElement(quantityInBasketForthLine);
        element.click();
        element.clear();
        element.sendKeys(quant);
        return this;
    }
    @Step("Click the Update Quantity button in the Basket")
    public void updateBasketButtonClick() {
        driver.findElement(updateBasketButton).click();
    }

    @Step("Click to the Order button")
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
}
