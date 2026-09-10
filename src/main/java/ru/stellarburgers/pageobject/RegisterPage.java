package ru.stellarburgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    // Локаторы (относительные, без текста, максимум 4 шага)
    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement nameInput;

    @FindBy(xpath = ".//fieldset[2]//input")
    private WebElement emailInput;

    @FindBy(xpath = ".//fieldset[3]//input")
    private WebElement passwordInput;

    @FindBy(xpath = ".//form//button")
    private WebElement registerButton;

    @FindBy(xpath = ".//a[contains(@href, 'login')]")
    private WebElement loginLink;

    @FindBy(xpath = ".//fieldset[3]//p")
    private WebElement passwordError;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод имени: {name}")
    public void setName(String name) {
        nameInput.sendKeys(name);
    }

    @Step("Ввод email: {email}")
    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Ввод пароля: {password}")
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Клик по кнопке «Зарегистрироваться»")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("Клик по ссылке «Войти» на странице регистрации")
    public void clickLoginLink() {
        loginLink.click();
    }

    @Step("Заполнение формы регистрации и отправка")
    public void register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }

    @Step("Проверка, что ошибка пароля отображается")
    public boolean isPasswordErrorDisplayed() {
        try {
            return passwordError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Получение текста ошибки пароля")
    public String getPasswordErrorText() {
        return passwordError.getText();
    }
}