package ru.stellarburgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // Публичный локатор для кнопки "Войти" – используется в тестах (относительный)
    public static final By LOGIN_BUTTON_LOCATOR = By.xpath(".//form//button");

    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement emailInput;

    @FindBy(xpath = ".//fieldset[2]//input")
    private WebElement passwordInput;

    @FindBy(xpath = ".//form//button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод email: {email}")
    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Ввод пароля: {password}")
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Клик по кнопке «Войти»")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Заполнение формы логина и отправка")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    @Step("Проверка видимости кнопки «Войти»")
    public boolean isLoginButtonVisible() {
        try {
            return driver.findElement(LOGIN_BUTTON_LOCATOR).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}