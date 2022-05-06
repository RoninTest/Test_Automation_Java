package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAccept(){
       var alertsPage= homePage.clickJavaScriptAlerts();
       alertsPage.triggerAlert();
       alertsPage.alert_clikToAccept();
       assertEquals (alertsPage.getResult(),"You successfully clicked an alert","RoNiN");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage =homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text=alertsPage.alert_getText();
        alertsPage.alert_clikToDismiss();
        assertEquals(text,"I am a JS Confirm","Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        var alertsPage=homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text="Ronin !";
        alertsPage.alert_setInput("Ronin !");
        alertsPage.alert_clikToAccept();
        assertEquals(alertsPage.getResult(),"You entered: "+text,"Results text incorrect");



    }
}
