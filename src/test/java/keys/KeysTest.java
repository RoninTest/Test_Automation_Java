package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;


public class KeysTest extends BaseTests {

    @Test
    public void testBackSpace() {
        var keyPage = homePage.clickKeyPress();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE");
    }


        @Test
     public void testPi(){
         var keyPage=homePage.clickKeyPress();
         keyPage.enterPi();



    }


}
