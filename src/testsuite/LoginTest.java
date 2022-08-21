package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest {

    String BaseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp()
    {
        openbrowse(BaseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //* Enter “tomsmith” username

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith");

        //* Enter “SuperSecretPassword!” password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");

        //* Click on ‘LOGIN’ button
        WebElement Login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        Login.click();

        //* Verify the text “Secure Area”
        WebElement VerifyText = driver.findElement(By.xpath("//div[@class='example']"));
            String actualtest = VerifyText.getText();
            String expectedtest = "Secure Area\n" +
                    "Welcome to the Secure Area. When you are done click logout below.\n" +
                    "Logout";
        Assert.assertEquals(expectedtest,actualtest);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){

        //* Enter “tomsmith1” username

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith1");

        //* Enter “SuperSecretPassword!” password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");

        //* Click on ‘LOGIN’ button
        WebElement Login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        Login.click();
        //* Verify the error message “Your username is invalid!”
        WebElement VerifyText = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualTest= VerifyText.getText();
        String expectedTest = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals(expectedTest,actualTest);

    }
    @Test
    public void verifyThePasswordErrorMessage(){

        //* Enter “tomsmith” username
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith");

        //* Enter “SuperSecretPassword” password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword");

        //* Click on ‘LOGIN’ button
        WebElement Login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        Login.click();

        //* Verify the error message “Your password is invalid!”
        WebElement VerifyText4 = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualTest= VerifyText4.getText();
        String expectedTest = "Your password is invalid!\n" +
                "×";
        Assert.assertEquals(expectedTest,actualTest);

    }
    @After
    public void closebrowser(){
       // driver.quit();
    }



}