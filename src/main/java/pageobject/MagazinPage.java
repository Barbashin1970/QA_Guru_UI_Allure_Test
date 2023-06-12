package pageobject;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static data.UniformResourceLocator.BASE_URL;


public class MagazinPage {

    // locators for Magazine Page
    private static final By baseCourseButton = By.xpath("//a[contains(@href, '/index.php/magazin/kurs') and contains(text(), 'Базовый курс тестирования ПО')]");

    private static final By buyCourseButton = By.xpath("//a[@class='btn btn-success button_buy'][contains(@href,'product_id=4')]");

    private static final By korzina = By.xpath("//a[@href='/index.php/magazin/korzina']");
    private static final By magazin = By.xpath("//a[@href='/index.php/magazin' and @aria-expanded='false']");

    // locator for Product Page
    private static final By quantity = By.name("quantity");
    private static final By toTheBasketButton = By.xpath("//input[@type='submit' and @class='btn btn-primary button btn-buy' and @value='В корзину']");

    // locators for Basket Page
    private static final By goBackToMagazin = By.xpath("//a[@href='/index.php/magazin' and @class='btn btn-arrow-left']");
    private static final By valueTotal = By.xpath(" //td[@class='value']");
    private static final By orderButton = By.xpath("//a[@class='btn btn-arrow-right']");
    private static final By updateBasketButton = By.xpath("//img[@src='https://qahacking.guru/components/com_jshopping/images/reload.png']");
    private static final By quantityInBasketFirstLine = By.xpath("//input[@name='quantity[0]']");
    private static final By quantityInBasketSecondLine = By.xpath("//input[@name='quantity[1]']");

    // locators for User Data Page
    private static final By userDataButton = By.xpath("//input[@type='submit' and @name='next' and @value='Далее' and @class='btn btn-primary button']");

    private final WebDriver driver;

    public MagazinPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Magazin Page")
    public MagazinPage openMagazinPage() {
        driver.get(BASE_URL);
        return this;
    }
    @Step("Click the button of the Base Course of QA")
    public void clickBaseCourseButton() {
        driver.findElement(baseCourseButton).click();
    }

    @Step("Click the Buy Button of the Base Course of QA")
    public void clickBuyCourseButton() {
        driver.findElement(buyCourseButton).click();
    }
    @Step("Click the button to the basket")
    public void clickBasketButton() {
        driver.findElement(toTheBasketButton).click();
    }

    @Step("Go to the Basket Page")
    public void goToTheBasketPage() {
        driver.findElement(magazin).click();
        driver.findElement(korzina).isDisplayed();
        driver.findElement(By.linkText("Корзина")).click();
    }

    @Step("Go back to the Magazin Page")
    public void goBackToTheMagazinPage() {
        driver.findElement(goBackToMagazin).isDisplayed();
        driver.findElement(goBackToMagazin).click();
    }
    @Step("Set new quantity")
    public void setNewQuantity(String quant) {
        driver.findElement(quantity).click();
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys(quant);



    }

    @Step("Check condition of displayed Magazin Page")
    public boolean isMagazinPageOpen() {
        return driver.findElement(magazin).isDisplayed();
    }

    @Step("Get text of total sum in basket")
    public String getTextOfTotalSum() {
        return driver.findElement(valueTotal).getText();
    }

    @Step("Set new quantity inside Basket Page")
    public void setNewQuantityInBasket(String quant) {
        driver.findElement(quantityInBasketFirstLine).click();
        driver.findElement(quantityInBasketFirstLine).clear();
        driver.findElement(quantityInBasketFirstLine).sendKeys(quant);
    }

    @Step("Click to the Order button")
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    @Step("Check the condition of displaying User Data Ok Button")
    public boolean isUserDataButtonDisplayed() {
        return driver.findElement(userDataButton).isDisplayed();
    }


}