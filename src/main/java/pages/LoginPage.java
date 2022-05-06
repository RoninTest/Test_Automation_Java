package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameFiled=By.id("username");
    private By passwordFiled=By.id("password");
    private By loginButton=By.cssSelector("#login button");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }
    // Username
    public void setUsername (String username){
       driver.findElement(usernameFiled).sendKeys(username);
    }

    //Password
    public void setPassword(String password) {
        driver.findElement(passwordFiled).sendKeys(password);
    }

    //Button
    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
}
