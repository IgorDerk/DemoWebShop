package DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(); // Инициализируем драйвер
        driver.get("https://demowebshop.tricentis.com/"); // Открываем ссылку на домашнюю страницу сайта, который тестируем
        driver.manage().window().setPosition(new Point(-1500, 0)); // Подвинуть окно браузера на 2500 пикселей вправо, чтобы он запускался на втором мониторе
        driver.manage().window().maximize(); // На весь экран развернуть браузер
        // Неявное ожидание локатора. Если элемент появится до истечения времени, Selenium сразу продолжит выполнение, не дожидаясь окончания таймера.
        // Устанавливает глобальное ожидание на все элементы, которые вы пытаетесь найти с помощью методов findElement или findElements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false) // включение или отключения закрытия браузера после тестов
    public void tearDown() {
        driver.quit();
    }

    public boolean isDemoWebShopPresent() {
        return isElementPresent(By.xpath("//img[@alt='Tricentis Demo Web Shop']"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void typePassword(String password) {
        type(By.id("Password"), password);
    }

    public void typeEmail(String email) {
        type(By.id("Email"), email);
    }

    public void clickOnRememberMe() {
        click(By.id("RememberMe"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//input[@value='Log in']"));
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[.='Log in']"));
    }

    public void checkLogin() {
        Assert.assertFalse(isElementPresent(By.xpath("//input[@value='Continue']"))); /* Проверяем,
        что кнопка "Continue" НЕ появилась */
    }
}
