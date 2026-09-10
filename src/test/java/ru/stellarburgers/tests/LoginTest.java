package ru.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.Test;
import ru.stellarburgers.base.BaseAuthUITest;
import ru.stellarburgers.data.ClientData;
import ru.stellarburgers.pageobject.ForgotPasswordPage;
import ru.stellarburgers.pageobject.LoginPage;
import ru.stellarburgers.pageobject.MainPage;
import ru.stellarburgers.pageobject.RegisterPage;

import static org.junit.Assert.assertTrue;

@Feature("Вход в аккаунт")
public class LoginTest extends BaseAuthUITest {

    @Step("Выполнение входа и проверка отображения кнопки 'Оформить заказ'")
    private void performLoginAndCheck() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(client.getEmail(), client.getPassword());
        MainPage mainPage = new MainPage(driver);
        assertTrue("Кнопка 'Оформить заказ' не отображается", mainPage.isOrderButtonDisplayed());
    }

    @Test
    @Story("Вход через кнопку «Войти в аккаунт» на главной странице")
    @Description("Клик по кнопке на главной → переход на логин → успешный вход")
    public void testLoginViaAccountButton() {
        driver.get(ClientData.BASE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginAccountButton();
        performLoginAndCheck();
    }

    @Test
    @Story("Вход через кнопку «Личный кабинет» на главной странице")
    @Description("Клик по кнопке в хедере → переход на логин → успешный вход")
    public void testLoginViaPersonalAccountButton() {
        driver.get(ClientData.BASE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        performLoginAndCheck();
    }

    @Test
    @Story("Вход через ссылку «Войти» на странице регистрации")
    @Description("Клик по ссылке на странице /register → переход на логин → успешный вход")
    public void testLoginViaRegisterPageLink() {
        driver.get(ClientData.BASE_URL + "register");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginLink();
        performLoginAndCheck();
    }

    @Test
    @Story("Вход через ссылку «Войти» на странице восстановления пароля")
    @Description("Клик по ссылке на странице /forgot-password → переход на логин → успешный вход")
    public void testLoginViaForgotPasswordPageLink() {
        driver.get(ClientData.BASE_URL + "forgot-password");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginLink();
        performLoginAndCheck();
    }
}