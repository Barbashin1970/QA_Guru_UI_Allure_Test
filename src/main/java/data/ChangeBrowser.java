package data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChangeBrowser {

    public static WebDriver getBrowser(String browserName) {
        switch (browserName) {

            case "yandex":
                System.setProperty("webdriver.chrome.driver", "/Users/olegbarbashin/IdeaProjects/QA_UI_Autotest/src/main/resources/chromedriver_mac_arm64/chromedriver_ya");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                return new ChromeDriver(options);

            case "chrome":
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                return new ChromeDriver();

            default:
                throw new RuntimeException("Ваш браузер пока не поддерживается - только Хром и Яндекс!");
        }
    }
}