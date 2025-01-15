package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai19_ICEHRM_LoginTest extends BasicTest {

    @DataProvider(name = "testDataFeed")
    public Object[][] testData(){
        Object[][] account = new Object[2][3];
        account[0][0] = "admin";
        account[0][1] = "admin";
        account[0][2] = 1;

        account[1][0] = "admin";
        account[1][1] = "admin123";
        account[1][2] = 0;
        return account;
    }

    @Test(dataProvider = "testDataFeed")
    public void loginTest(String username, String password, int isPositive) throws Exception {
        driver.get("https://icehrm-open.gamonoid.com/login.php");
        WebElement emailLogin = driver.findElement(By.xpath("//input[@id='username']"));
        emailLogin.sendKeys(username);
        WebElement pwdLogin = driver.findElement(By.xpath("//input[@id='password']"));
        pwdLogin.sendKeys(password);
        WebElement btnLogin = driver.findElement(By.xpath("//button[text()='Log in ']"));
        btnLogin.click();

        if(isPositive == 1){
            String getURL = driver.getCurrentUrl();
            Assert.assertTrue(getURL.contains(username));
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger")));
            String getError = driver.findElement(By.cssSelector(".alert-danger")).getText();
            Assert.assertEquals(getError, "Login failed"); 
        }
    }

}