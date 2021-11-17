import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Google {
    public WebDriver driver;
   @BeforeTest
 public void setup() throws MalformedURLException {
//     System.out.println("User directory is - "+System.getProperty("user.dir"));
//    System.setProperty("webdriver.chrome.driver", "/home/circleci/project/src/test/resources/chromedriver.exe");
//
//     driver=new ChromeDriver();
//
//     driver.manage().window().maximize();
//     driver.get("https://www.google.co.in/");
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setBrowserName("chrome");
       driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub" ), capabilities);
   }
   @Test
    public void testGoogleSearch() throws InterruptedException {
      Thread.sleep(1000);
       driver.findElement(By.xpath("//input[@name='q' and @type='text']")).sendKeys("Selenium");
       driver.findElement(By.xpath("//input[@name='q' and @type='text']")).sendKeys(Keys.ENTER);
       String link=driver.findElement(By.xpath("(//div[@class='yuRUbf']/a)[1]")).getAttribute("href");
       if(link.contains("selenium")){
           System.out.println("Selenium content is displayed");
       }
       else {
           System.out.println("Selenium content is not displayed");
       }
   }
   @AfterTest
    public void close(){
       driver.quit();
   }
}
