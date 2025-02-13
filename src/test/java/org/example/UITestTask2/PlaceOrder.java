package org.example.UITestTask2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrder extends ElementWait {

    @FindBy(xpath = "//button[contains(text(), 'Place Order')]")
    private WebElement placeOrder;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement countryField;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@id='card']")
    private WebElement creditCardField;

    @FindBy(xpath = "//input[@id='month']")
    private WebElement monthCreditCardField;

    @FindBy(xpath = "//input[@id='year']")
    private WebElement yearCreditCardField;

    @FindBy(xpath = "//button[contains(text(), 'Purchase')]")
    private WebElement purchase;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    private WebElement resultAmount;


    public PlaceOrder(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void placeOrder(){
        waitWebElement(placeOrder);
        placeOrder.click();


        waitWebElement(nameField);
        waitWebElement(countryField);
        waitWebElement(cityField);
        waitWebElement(creditCardField);
        waitWebElement(monthCreditCardField);
        waitWebElement(yearCreditCardField);

        nameField.sendKeys("Sam");
        countryField.sendKeys("Russia");
        cityField.sendKeys("Moscow");
        creditCardField.sendKeys("1000 0000 0000 1230");
        monthCreditCardField.sendKeys("12");
        yearCreditCardField.sendKeys("2029");

        waitWebElement(purchase);
        purchase.click();
    }

    public String getAmount(){
        String amount = resultAmount.getText();
        for(String line : amount.split("\n")){
            if(line.startsWith("Amount:")){
                amount = line.replaceAll("\\D","");
            }
        }
        return amount;
    }
}
