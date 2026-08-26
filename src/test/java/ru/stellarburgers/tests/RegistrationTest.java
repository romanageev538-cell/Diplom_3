package ru.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stellarburgers.base.BaseApiCleanupTest;
import ru.stellarburgers.data.ClientData;
import ru.stellarburgers.model.ClientModel;
import ru.stellarburgers.pageobject.LoginPage;
import ru.stellarburgers.pageobject.RegisterPage;
import ru.stellarburgers.utils.BaseApi;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@Feature("Регистрация")
public class RegistrationTest extends BaseApiCleanupTest {

    private RegisterPage registerPage;
    private BaseApi baseApi;
    private ClientModel client;

    @Before
    public void setUp() {
        super.setUp();
        if (driver == null) {
            throw new RuntimeException("Драйвер не инициализирован в RegistrationTest");
        }
        driver.get(ClientData.BASE_URL + "register");
        registerPage = new RegisterPage(driver);
        baseApi = new BaseApi();
        client = ClientData.createDefaultClient();
    }

    @Test
    @Story("Успешная регистрация нового пользователя")
    @Description("Заполнение всех полей и нажатие кнопки 'Зарегистрироваться' приводит к переходу на страницу логина")
    public void testSuccessfulRegistration() {
        registerPage.register(client.getName(), client.getEmail(), client.getPassword());

        // Явное ожидание загрузки страницы логина по локатору (не stale)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.LOGIN_BUTTON_LOCATOR));

        // Проверяем видимость кнопки (используем метод LoginPage, который ищет элемент заново)
        LoginPage loginPage = new LoginPage(driver);
        assertTrue("Кнопка 'Войти' не отображается на странице логина", loginPage.isLoginButtonVisible());

        // Получаем токен для удаления пользователя
        accessToken = baseApi.loginAndGetToken(client);
    }

    @Test
    @Story("Ошибка при некорректном пароле")
    @Description("Ввод пароля менее 6 символов вызывает сообщение 'Некорректный пароль' и подсветку поля")
    public void testInvalidPasswordError() {
        registerPage.register(client.getName(), client.getEmail(), ClientData.INVALID_SHORT_PASSWORD);
        assertTrue("Ошибка пароля не отображается", registerPage.isPasswordErrorDisplayed());
        org.junit.Assert.assertEquals("Некорректный пароль", registerPage.getPasswordErrorText());
    }
}