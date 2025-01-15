package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;

import com.utils.BasicTest;

public class Bai16_RegisterTest extends BasicTest {
    @Test
    public void registerTest() throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        WebElement emailRegister = driver.findElement(By.xpath("//input[@id='reg_email']"));
        emailRegister.sendKeys("nhanvip124@gmail.com");
        WebElement btnLogin = driver.findElement(By.xpath("//button[@name='register']"));
        btnLogin.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='woocommerce-error']")));
        WebElement errorMsg = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertTrue(errorMsg.isDisplayed());
    }
}
