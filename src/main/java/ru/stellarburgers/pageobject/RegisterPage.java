package ru.stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='root']/div/main/div/form/button")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id='root']/div/main/div/div/p/a")
    private WebElement loginLink;

    @FindBy(xpath = "//*[@id='root']/div/main/div/form/fieldset[3]/div/p")
    private WebElement passwordError;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void setName(String name) {
        nameInput.sendKeys(name);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public boolean isPasswordErrorDisplayed() {
        return passwordError.isDisplayed();
    }

    public String getPasswordErrorText() {
        return passwordError.getText();
    }

    public void register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }
}