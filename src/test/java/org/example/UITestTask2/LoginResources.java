package org.example.UITestTask2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginResources extends ElementWait{

    @FindBy(xpath = "//a[@id='login2' and contains(@class, 'nav-link')]")
    private WebElement signUpButtonLogin;

    @FindBy(xpath = "//input[@id='loginusername']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
    private WebElement signUpButton;


    public LoginResources(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        waitWebElement(signUpButtonLogin);
        signUpButtonLogin.click();

        waitWebElement(usernameField);
        waitWebElement(passwordField);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        waitWebElement(signUpButton);
        signUpButton.click();
    }
}
