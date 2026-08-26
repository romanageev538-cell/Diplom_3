package ru.stellarburgers.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverFactory {

    public static WebDriver getDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser", "chrome");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        if ("yandex".equalsIgnoreCase(browser)) {
            // Яндекс Браузер
            System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver-26.8.0.1788-win64\\yandexdriver.exe");
            // Указываем путь к бинарному файлу Яндекс.Браузера (если стандартный)
            options.setBinary("C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe");
            driver = new ChromeDriver(options);
        } else {
            // Обычный Chrome
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}