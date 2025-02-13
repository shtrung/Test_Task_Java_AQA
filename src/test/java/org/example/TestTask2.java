package org.example;

import org.example.UITestTask2.AddProductToCart;
import org.example.UITestTask2.EqualsPriceInCart;
import org.example.UITestTask2.LoginResources;
import org.example.UITestTask2.PlaceOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {


    private static WebDriver driver;
    private static LoginResources login;
    private static final ChromeOptions options = new ChromeOptions();

    static {
        options.addArguments("--headless");
        options.addArguments("--disable-javascript");
        options.addArguments("blink-settings=imagesEnabled=false");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
    }

    @BeforeAll
    public static void init() {
        driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        login = new LoginResources(driver);
    }

    @Test
    public void testAddToCartAndComparePrices() {
        //1. Логинимся.
        login.login("samsis2310", "passwords12345");

        //2. Добавляем любой товар в корзину.
        AddProductToCart addProductToCart = new AddProductToCart(driver);
        addProductToCart.addToCart();

        //3.  Переодим в корзину.
        EqualsPriceInCart equalsPriceInCart = new EqualsPriceInCart(driver);
        equalsPriceInCart.goToCart();

        //3.1 Сравниваем цену в корзине с ценой в карточке товара
        String cardPrice = equalsPriceInCart.getPriceProductCard();
        String expectedPrice = equalsPriceInCart.getCountBasket();

        //Если тест пройдет - идем дальше
        assertEquals(expectedPrice, cardPrice);

        //4. Оформляем заказ
        PlaceOrder placeOrder = new PlaceOrder(driver);
        placeOrder.placeOrder();

        //4.1 Сравниваем цену заказа с ценой в карточке товара
        String amount = placeOrder.getAmount();
        assertEquals(amount, cardPrice);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}
