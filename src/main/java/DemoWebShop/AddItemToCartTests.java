package DemoWebShop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        login("derk.i26252@gmail.com", "Password@1");
    }

    @Test
    public void addItemToCartPositiveTest() {
        String secondItemText = driver.findElement(By.xpath("(//h2[@class='product-title']//a)[2]")).getText();
        System.out.println("secondItemText: " + secondItemText);
        click(By.xpath("(//input[@value='Add to cart'])[2]"));
        click(By.xpath("//a[@class='ico-cart']//span[1]"));
        driver.navigate().refresh(); // обновляет страницу
        String secondItemTextInCart = driver.findElement(By.className("product-name")).getText();
        System.out.println("secondItemTextInCart: " + secondItemTextInCart);
        Assert.assertEquals(secondItemText, secondItemTextInCart);
    }
}
