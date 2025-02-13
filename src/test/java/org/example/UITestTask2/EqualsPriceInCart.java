package org.example.UITestTask2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EqualsPriceInCart extends ElementWait{

    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    private WebElement cartButton;

    @FindBy(xpath = "//tr[contains(@class, 'success')]//td[3]")
    private WebElement priceProductCard;

    @FindBy(xpath = "//h3[@id='totalp']")
    private WebElement countToBasket;

    public EqualsPriceInCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPriceProductCard() {
        waitWebElement(priceProductCard);
        return priceProductCard.getText();
    }

    public String getCountBasket(){
        waitWebElement(countToBasket);
        return countToBasket.getText();
    }

    public void goToCart() {
        waitWebElement(cartButton);
        cartButton.click();
    }

}
