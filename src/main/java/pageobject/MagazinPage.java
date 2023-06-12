package pageobject;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static data.UniformResourceLocator.BASE_URL;


public class MagazinPage {
    private static final By baseCourseButton = By.xpath("//a[contains(@href, '/index.php/magazin/kurs') and contains(text(), 'Базовый курс тестирования ПО')]");
    private static final By toTheBasketButton = By.xpath("//input[@type='submit' and @class='btn btn-primary button btn-buy' and @value='В корзину']");

    private static final By quantity = By.name("quantity");
    // - <input type="text" name="quantity" id="quantity" onkeyup="reloadPrices();" class="inputbox" value="1">
    private  static final By korzina = By.xpath("//a[@href='/index.php/magazin/korzina']");

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

    @Step("Click the button to the basket")
    public void clickBasketButton() {
        driver.findElement(toTheBasketButton).click();
    }

    @Step("Go to the Basket Page")
    public void goToTheBasketPage() {
        driver.findElement(korzina).click();
    }
    @Step("Click the button of quantity")
    public void clickQuantityButton() {
        driver.findElement(quantity).click();
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys("10");
    }

}