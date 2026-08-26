package ru.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stellarburgers.base.BaseAuthUITest;
import ru.stellarburgers.data.ClientData;
import ru.stellarburgers.pageobject.LoginPage;
import ru.stellarburgers.pageobject.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@Feature("Конструктор")
public class ConstructorTest extends BaseAuthUITest {

    @Before
    @Step("Авторизация перед тестами конструктора")
    public void login() {
        driver.get(ClientData.BASE_URL + "login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(client.getEmail(), client.getPassword());

        // Явное ожидание загрузки главной страницы (кнопка "Оформить заказ" видима)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MainPage.ORDER_BUTTON_LOCATOR));
    }

    @Test
    @Story("Переход к разделу «Булки»")
    @Description("Клик по табу «Булки» — проверка, что у таба появляется активный класс")
    public void testBunsTabActive() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBunsTab();
        assertTrue("Таб 'Булки' не активен", mainPage.isBunsTabActive());
    }

    @Test
    @Story("Переход к разделу «Соусы»")
    @Description("Клик по табу «Соусы» — проверка, что у таба появляется активный класс")
    public void testSaucesTabActive() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesTab();
        assertTrue("Таб 'Соусы' не активен", mainPage.isSaucesTabActive());
    }

    @Test
    @Story("Переход к разделу «Начинки»")
    @Description("Клик по табу «Начинки» — проверка, что у таба появляется активный класс")
    public void testFillingsTabActive() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsTab();
        assertTrue("Таб 'Начинки' не активен", mainPage.isFillingsTabActive());
    }
}