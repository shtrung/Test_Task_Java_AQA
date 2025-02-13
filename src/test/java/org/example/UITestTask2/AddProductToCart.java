package org.example.UITestTask2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddProductToCart extends ElementWait{

    @FindBy(xpath = "//a[contains(text(), 'Samsung galaxy s7')]")
    private WebElement product;

    @FindBy(xpath = "//a[contains(text(), 'Add to cart')]")
    private WebElement addToCartButton;

    public AddProductToCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        waitWebElement(product);
        click(product);
        waitWebElement(addToCartButton);
        addToCartButton.click();
    }

}
