package pageobject;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static data.UniformResourceLocator.BASE_URL;


public class MagazinPage {
    //private static final By baseCourseButton = By.xpath("//a[@href='/index.php/magazin/kurs' and text()='Базовый курс тестирования ПО']");

    private static final By baseCourseButton = By.xpath("//a[contains(@href, '/index.php/magazin/kurs') and contains(text(), 'Базовый курс тестирования ПО')]");
    private static final By toTheBasketButton = By.xpath("//input[@type='submit' and @class='btn btn-primary button btn-buy' and @value='В корзину']");
    //and @onclick="jQuery('#to').val('cart');"]
    private static final By quantity = By.id("quantity");
    private final WebDriver driver;

    public MagazinPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Magazin Page")
    public MagazinPage openMagazinPage() {
        driver.get(BASE_URL);
        return this;
    }
    @Step("Push the button of the Base Course of QA")
    public void clickBaseCourseButton() {
        driver.findElement(baseCourseButton).click();
    }

    @Step("Push the button to the basket")
    public void clickBasketButton() {
        driver.findElement(toTheBasketButton).click();
    }


}