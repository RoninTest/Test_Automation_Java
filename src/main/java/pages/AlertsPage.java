package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By triggerAlertButton = By.xpath(".//button[text()=\"Click for JS Alert\"]");    // Click For JS Alert
    private By triggerConfirmButton=By.xpath(".//button[text()=\"Click for JS Confirm\"]"); // Click for JS Confirm
    private By triggerPromptButton=By.xpath(".//button[text()=\"Click for JS Prompt\"]"); // Click for JS Prompt
    private By results=By.id("result");


    public AlertsPage(WebDriver driver){
        this.driver=driver;
    }
    /*** OK Alert Button ***/
    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }

    /*** Cansel Alert Button ***/
    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }

    /*** Prompt Alert Button ***/
    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }

    /*** OK Alert Button ***/
    public void alert_clikToAccept(){
        driver.switchTo().alert().accept();
    }


    /*** Cansel Alert Button ***/
    public void alert_clikToDismiss(){
        driver.switchTo().alert().dismiss(); //click on Cancel Button
    }

    /*** Cansel Alert Button ***/
    public String alert_getText(){
        return driver.switchTo().alert().getText(); //also We need Alert text message
    }

    /*** Prompt Button ***/
    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    /*** OK Alert Button ***/
    public String getResult(){
        return driver.findElement(results).getText();
    }
}
