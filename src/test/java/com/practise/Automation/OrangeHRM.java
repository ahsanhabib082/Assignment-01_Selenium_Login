package com.practise.Automation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OrangeHRM {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }
    @Test
    public void testOrangeHRM() throws Exception {

        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(15000);

        //Login username
        WebElement name = driver.findElement(By.name("username"));
        name.sendKeys("Admin");
        Thread.sleep(3000);
        //Login Password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        Thread.sleep(3000);

        //Login Button
        WebElement login = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]"));
        login.click();
        Thread.sleep(3000);

        //Navigation to view Employee
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        Thread.sleep(3000);
        //Navigate to PIM
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
        Thread.sleep(3000);

        //For First Name
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ahsan");
        Thread.sleep(5000);

        //For Sec ond Name
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Habib");
        Thread.sleep(5000);

         // For Save Button
        WebElement save = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]"));
        save.click();
        Thread.sleep(15000);


    }

    @AfterSuite

    public void closeChromeBrowser() {
        driver.quit();

    }

}

