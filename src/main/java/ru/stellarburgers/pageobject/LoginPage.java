package ru.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // Публичный локатор для кнопки "Войти" – используется в тестах
    public static final By LOGIN_BUTTON_LOCATOR = By.xpath("//*[@id='root']/div/main/div/form/button");

    @FindBy(xpath = "//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='root']/div/main/div/form/button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    // Проверка видимости кнопки с использованием локатора (всегда свежий элемент)
    public boolean isLoginButtonVisible() {
        try {
            return driver.findElement(LOGIN_BUTTON_LOCATOR).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}