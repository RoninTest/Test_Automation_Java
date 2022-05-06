package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    //private WebDriver driver;
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() throws InterruptedException {

           try
           {
               System.setProperty("webdriver.chrome.driver","C:\\Users\\Eren\\Desktop\\Alieren\\TESTS\\Test_Automation_WebdriverJava\\chromedriver.exe");
               //driver=new ChromeDriver();
               driver=new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
               driver.register(new EventReporter());
               //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //İmplicit Waits
              // driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); //pageloadtimeout
              // driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS); // setScriptTimeout
               goHome();
               setCookie();
               driver.get("https://the-internet.herokuapp.com/");
               //driver.manage().window().setSize(new Dimension(375,667));
               driver.manage().window().maximize();
               String URL = driver.getCurrentUrl();
               System.out.print(" Verification = " + " "); System.out.print(URL+ " " + " *** Compare statu = ");
               System.out.print(URL.compareTo("https://the-internet.herokuapp.com/")+" ***"); //ASCII control
/*
               List<WebElement> links  =driver.findElements(By.tagName("a"));
               System.out.println("\n"+"a Link Number = " + links.size());
--
               WebElement inputlink = driver.findElement(By.linkText("Inputs"));
               inputlink.click();
*/

               homePage = new HomePage(driver);

           }
           catch (Exception e){
                System.out.println("Hata");
           }


    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage=new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void takeScreenShot(ITestResult result){
       var camera=(TakesScreenshot)driver;
        //System.out.println("Screenshot taken : "+screenshot.getAbsolutePath());
       File screenshot=camera.getScreenshotAs(OutputType.FILE);
       try
       {
           Files.move(screenshot,new File("C:\\Users\\Eren\\Desktop\\Alieren\\TESTS\\Test_Automation_WebdriverJava\\allscreenshots\\"+result.getName()+".PNG"));
       }
       catch (IOException exception)
       {
           exception.printStackTrace();
       }


    }
    @AfterMethod
    public void recordFailure(ITestResult result){
    if(ITestResult.FAILURE==result.getStatus()){
        var camera_failure=(TakesScreenshot)driver;
        File screenshot_failure=camera_failure.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot_failure,new File("C:\\Users\\Eren\\Desktop\\Alieren\\TESTS\\Test_Automation_WebdriverJava\\failurescreenshots\\"+result.getName()+".PNG"));
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars"); // when chrome open, it writes "test automation" so this method blocks this script
       // options.setHeadless(true); //without opening the browser
        return options;
    }

    private void setCookie(){
        Cookie cookie=new Cookie.Builder("ronin","123").domain("https://the-internet.herokuapp.com/").build();
        driver.manage().addCookie(cookie);

    }

/*
    public static void main (String args[]) throws InterruptedException {
        BaseTests test=new BaseTests();
        test.setUp();

    }
 */
}
