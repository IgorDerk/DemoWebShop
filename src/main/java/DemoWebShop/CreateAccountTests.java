package DemoWebShop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {

    @Test
    public void CreateAccountPositiveTest() {
        driver.findElement(By.xpath("//a[.='Register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).click();
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Igor");
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Derk");
        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("derk.i262523@gmail.com");
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("Password@1");
        driver.findElement(By.id("ConfirmPassword")).click();
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Password@1");
        driver.findElement(By.id("register-button")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='Log out']")));

    }

    @Test
    public void CreateAccountNegativeTest() {
        driver.findElement(By.xpath("//a[.='Register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).click();
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Igor");
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Derk");
        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("derk.i262523@gmail.com");
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("Password@1");
        driver.findElement(By.id("ConfirmPassword")).click();
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Password@1");
        driver.findElement(By.id("register-button")).click();
        Assert.assertFalse(isElementPresent(By.xpath("//input[@value='Continue']"))); /* Проверяем,
        что кнопка "Continue" НЕ появилась */
    }

    @Test
    public void CreateAccountNegativeSoftAssertTest() {
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.xpath("//a[.='Register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).click();
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Igor");
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Derk");
        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("derk.i262523@gmail.com");
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("Password@1");
        driver.findElement(By.id("ConfirmPassword")).click();
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Password@1");
        driver.findElement(By.id("register-button")).click();
        softAssert.assertFalse(isElementPresent(By.xpath("//input[@value='Continue']"))); /* Проверяем,
        что кнопка "Continue" НЕ появилась */
        softAssert.assertTrue(isElementPresent(By.xpath("//li[.='The specified email already exists']")));
        softAssert.assertAll();
    }


}
