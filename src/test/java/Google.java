import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Google {
    public WebDriver driver;
   @BeforeTest
 public void setup(){
      System.setProperty("webdriver.chrome.driver", "./chromedriver");
     driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.google.co.in/");
   }
   @Test
    public void testGoogleSearch(){
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
