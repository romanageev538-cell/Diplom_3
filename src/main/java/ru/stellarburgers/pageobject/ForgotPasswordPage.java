package ru.stellarburgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(xpath = ".//a[contains(@href, '/login')]")
    private WebElement loginLink;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по ссылке «Войти» на странице восстановления пароля")
    public void clickLoginLink() {
        loginLink.click();
    }
}