package ru.stellarburgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    // Публичный локатор для ожидания загрузки главной страницы
    public static final By ORDER_BUTTON_LOCATOR = By.xpath(".//button[text()='Оформить заказ']");

    // Табы: ищем span по тексту, но кликаем по родительскому div (чтобы активный класс появился у него)
    @FindBy(xpath = ".//div[contains(@class, 'tab_tab') and .//span[text()='Булки']]")
    private WebElement bunsTab;

    @FindBy(xpath = ".//div[contains(@class, 'tab_tab') and .//span[text()='Соусы']]")
    private WebElement saucesTab;

    @FindBy(xpath = ".//div[contains(@class, 'tab_tab') and .//span[text()='Начинки']]")
    private WebElement fillingsTab;

    // Кнопки
    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private WebElement loginAccountButton;

    @FindBy(xpath = ".//a[contains(@href, '/account')]")
    private WebElement personalAccountButton;

    @FindBy(xpath = ".//button[text()='Оформить заказ']")
    private WebElement orderButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки главной страницы")
    public void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_BUTTON_LOCATOR));
    }

    @Step("Клик по табу «Булки»")
    public void clickBunsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(bunsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bunsTab);
    }

    @Step("Клик по табу «Соусы»")
    public void clickSaucesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(saucesTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saucesTab);
    }

    @Step("Клик по табу «Начинки»")
    public void clickFillingsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(fillingsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fillingsTab);
    }

    @Step("Проверка активности таба «Булки»")
    public boolean isBunsTabActive() {
        try {
            wait.until(ExpectedConditions.attributeContains(bunsTab, "class", "tab_tab_type_current"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Проверка активности таба «Соусы»")
    public boolean isSaucesTabActive() {
        try {
            wait.until(ExpectedConditions.attributeContains(saucesTab, "class", "tab_tab_type_current"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Проверка активности таба «Начинки»")
    public boolean isFillingsTabActive() {
        try {
            wait.until(ExpectedConditions.attributeContains(fillingsTab, "class", "tab_tab_type_current"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Клик по кнопке «Войти в аккаунт»")
    public void clickLoginAccountButton() {
        loginAccountButton.click();
    }

    @Step("Клик по кнопке «Личный кабинет»")
    public void clickPersonalAccountButton() {
        personalAccountButton.click();
    }

    @Step("Проверка отображения кнопки «Оформить заказ»")
    public boolean isOrderButtonDisplayed() {
        try {
            return orderButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}