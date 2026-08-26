package ru.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    // Публичные локаторы для использования в тестах
    public static final By ORDER_BUTTON_LOCATOR = By.xpath("//*[@id='root']/div/main/section[2]/div/button[text()='Оформить заказ']");

    // Локаторы табов – теперь указывают на родительский div (кликабельный контейнер)
    @FindBy(xpath = "//*[@id='root']/div/main/section[1]/div[1]/div[1]")
    private WebElement bunsTab;

    @FindBy(xpath = "//*[@id='root']/div/main/section[1]/div[1]/div[2]")
    private WebElement saucesTab;

    @FindBy(xpath = "//*[@id='root']/div/main/section[1]/div[1]/div[3]")
    private WebElement fillingsTab;

    @FindBy(xpath = "//*[@id='root']/div/main/section[2]/div/button[text()='Войти в аккаунт']")
    private WebElement loginAccountButton;

    @FindBy(xpath = "//*[@id='root']/div/header/nav/a/p")
    private WebElement personalAccountButton;

    @FindBy(xpath = "//*[@id='root']/div/main/section[2]/div/button[text()='Оформить заказ']")
    private WebElement orderButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    // ---- Клики через JavaScript (обход перекрытия) ----
    public void clickBunsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(bunsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bunsTab);
    }

    public void clickSaucesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(saucesTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saucesTab);
    }

    public void clickFillingsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(fillingsTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fillingsTab);
    }

    // ---- Проверка активности (явное ожидание появления класса) ----
    public boolean isBunsTabActive() {
        try {
            wait.until(ExpectedConditions.attributeContains(bunsTab, "class", "tab_tab_type_current"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSaucesTabActive() {
        try {
            wait.until(ExpectedConditions.attributeContains(saucesTab, "class", "tab_tab_type_current"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFillingsTabActive() {
        try {
            wait.until(ExpectedConditions.attributeContains(fillingsTab, "class", "tab_tab_type_current"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ---- Остальные методы ----
    public void clickLoginAccountButton() {
        loginAccountButton.click();
    }

    public void clickPersonalAccountButton() {
        personalAccountButton.click();
    }

    public boolean isOrderButtonDisplayed() {
        try {
            return orderButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}