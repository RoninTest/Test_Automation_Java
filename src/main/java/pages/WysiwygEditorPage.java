package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    WebDriver driver;
    private String editorIframeId="mce_0_ifr";
    private By textArea=By.id("tinymce");
    private By decreaseIndentButton=By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(3) div.tox.tox-tinymce:nth-child(3) div.tox-editor-container div.tox-editor-header div.tox-toolbar-overlord div.tox-toolbar__primary div.tox-toolbar__group:nth-child(5) > button.tox-tbtn:nth-child(2)");

    public WysiwygEditorPage(WebDriver driver){
        this.driver=driver;
    }

    public void clearTextArea(){
        switchToEditArea(); //enter iframe
        driver.findElement(textArea).clear(); //test
        switchToMainArea(); //exit iframe
    }

    /***Verify Editor Hello Ronin  ***/
    public String getTextFromEditor(){
        switchToEditArea(); //enter iframe
        String text = driver.findElement(textArea).getText(); //test
        switchToMainArea(); //exit iframe
        return text;
    }

    public void setTextArea(String text){
        switchToEditArea(); //enter iframe
        driver.findElement(textArea).sendKeys(text); //test
        switchToMainArea(); //exit iframe
    }

    /***Button Click ***/
    public void decreaseIndention(){
        driver.findElement(decreaseIndentButton).click();

    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }
    private void switchToMainArea(){ //exit iframe
        driver.switchTo().parentFrame();
    }
}
