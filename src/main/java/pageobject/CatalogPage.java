package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static data.UniformResourceLocator.BASE_URL;

public class CatalogPage {

    // locators for Product Catalog Page
    private static final By baseCourseButton = By.xpath("//a[contains(@href, '/index.php/magazin/kurs') and contains(text(), 'Базовый курс тестирования ПО')]");
    private static final By buyCourseButton = By.xpath("//a[@class='btn btn-success button_buy'][contains(@href,'product_id=4')]");
    private static final By buyPodcastButton = By.xpath("//a[@class='btn btn-success button_buy'][contains(@href,'product_id=3')]");
    private static final By buyDogSnackButton = By.xpath("//a[@class='btn btn-success button_buy'][contains(@href,'product_id=2')]");
    private static final By buyDictionaryButton = By.xpath("//a[@class='btn btn-success button_buy'][contains(@href,'product_id=1')]");
    private static final By basket = By.xpath("//a[@href='/index.php/magazin/korzina']");
    private static final By catalog = By.xpath("//a[@href='/index.php/magazin' and @aria-expanded='false']");

    // locators for Product Details Page
    private static final By quantity = By.name("quantity");
    private static final By toTheBasketButton = By.xpath("//input[@type='submit' and @class='btn btn-primary button btn-buy' and @value='В корзину']");

    // locators for User Data Page
    private static final By userDataButton = By.xpath("//input[@type='submit' and @name='next' and @value='Далее' and @class='btn btn-primary button']");
    private static final By goBackToCatalogPage = By.xpath("//a[@href='/index.php/magazin' and @class='btn btn-arrow-left']");
    private final WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Product Catalog Page")
    public CatalogPage openCatalogPage() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Click the button of the Base Course of QA")
    public CatalogPage clickBaseCourseButton() {
        driver.findElement(baseCourseButton).click(); return this;
    }

    @Step("Click the Buy Button of the Base Course of QA")
    public void clickBuyCourseButton() {
        driver.findElement(buyCourseButton).click();
    }

    @Step("Put all 4 product to the Basket")
    public void clickBuyAll() {
        driver.findElement(buyCourseButton).click();
        driver.findElement(goBackToCatalogPage).click();
        driver.findElement(buyPodcastButton).click();
        driver.findElement(goBackToCatalogPage).click();
        driver.findElement(buyDogSnackButton).click();
        driver.findElement(toTheBasketButton).click();
        driver.findElement(goBackToCatalogPage).click();
        driver.findElement(buyDictionaryButton).click();
    }
    @Step("Click the button to the basket")
    public void clickBasketButton() {
        driver.findElement(toTheBasketButton).click();
    }

    @Step("Go to the Basket Page")
    public void goToTheBasketPage() {
        driver.findElement(catalog).click();
        driver.findElement(basket).isDisplayed();
        driver.findElement(By.linkText("Корзина")).click();
    }

    @Step("Set new quantity in Product Description Card")
    public CatalogPage setNewQuantity(String quant) {
        WebElement element = driver.findElement(quantity);
        element.click();
        element.clear();
        element.sendKeys(quant);
        return this;
    }

    @Step("Check condition of displayed Product Catalog Page")
    public boolean isCatalogPageOpen() {
        return driver.findElement(catalog).isDisplayed();
    }

    @Step("Check the condition of displaying User Data Ok Button")
    public boolean isUserDataButtonDisplayed() {
        return driver.findElement(userDataButton).isDisplayed();
    }

}