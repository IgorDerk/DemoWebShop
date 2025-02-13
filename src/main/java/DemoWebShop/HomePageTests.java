package DemoWebShop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isDemoWebShopPresentTest() {
        Assert.assertTrue(isDemoWebShopPresent(), "Demo Web Shop is not found " + isDemoWebShopPresent());
    }

}
